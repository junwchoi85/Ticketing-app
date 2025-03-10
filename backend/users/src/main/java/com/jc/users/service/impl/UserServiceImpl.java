package com.jc.users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.jc.common.exception.ConflictException;
import com.jc.common.exception.ResourceNotFoundException;
import com.jc.common.util.StringUtil;
import com.jc.users.constants.UserConstants;
import com.jc.users.dto.CustomerDto;
import com.jc.users.dto.CustomerMsgDto;
import com.jc.users.entity.Customer;
import com.jc.users.mapper.CustomerMapper;
import com.jc.users.repository.CustomerRepository;
import com.jc.users.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final StreamBridge streamBridge;

    @Override
    public CustomerDto signUpCustomer(CustomerDto customersDto) {
        Customer customersEntities = CustomerMapper.convertToEntity(customersDto);
        Optional<Customer> customers = customerRepository.findByEmail(customersEntities.getEmail());
        if (customers.isPresent()) {
            throw new ConflictException(UserConstants.RESOURCE_CUSTOMER, UserConstants.RESOURCE_EMAIL,
                    customersEntities.getEmail());
        }
        Customer savedUsers = customerRepository.save(customersEntities);
        sendMessage(savedUsers);
        return CustomerMapper.convertToDto(savedUsers);
    }

    @Override
    public CustomerDto fetchCustomerById(Long id) {
        Customer customers = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_ID, String.valueOf(id)));
        return CustomerMapper.convertToDto(customers);
    }

    @Override
    public CustomerDto fetchCustomerByUuid(String uuid) {
        StringUtil.trim(String.valueOf(uuid));
        Customer users = customerRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_UUID, uuid));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public CustomerDto fetchCustomerByEmail(String email) {
        Customer users = customerRepository.findByEmail(StringUtil.trim(email))
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_EMAIL, email));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public boolean editCustomerDetails(CustomerDto customerDto) {
        Customer customer = customerRepository.findByUuid(customerDto.getUuid())
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_UUID, customerDto.getUuid()));
        Customer updatedUsers = CustomerMapper.mapToEntity(customerDto, customer);
        customerRepository.save(updatedUsers);
        return true;
    }

    @Override
    public boolean deactivateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findByEmail(customerDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_EMAIL, customerDto.getEmail()));
        customerRepository.deleteById(customer.getId());
        return true;
    }

    @Override
    public List<CustomerDto> listAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::convertToDto).collect(Collectors.toList());
    }

    private void sendMessage(Customer customer) {
        var customerMsgDto = new CustomerMsgDto(customer.getUuid(), customer.getEmail());
        logger.info("\n\nSending message to Kafka topic: {}", UserConstants.CUSTOMER_TOPIC);
        var result = streamBridge.send(UserConstants.CUSTOMER_TOPIC, customerMsgDto);
        logger.info("\n\nMessage sent to Kafka topic: {}", result);
    }
}
