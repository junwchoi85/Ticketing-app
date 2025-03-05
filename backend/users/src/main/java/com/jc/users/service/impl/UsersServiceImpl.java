package com.jc.users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jc.common.exception.ConflictException;
import com.jc.common.exception.ResourceNotFoundException;
import com.jc.users.constants.UserConstants;
import com.jc.users.dto.CustomerDto;
import com.jc.users.entity.Customer;
import com.jc.users.mapper.CustomerMapper;
import com.jc.users.repository.CustomerRepository;
import com.jc.users.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements IUserService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto signUpCustomer(CustomerDto customersDto) {
        Customer customersEntities = CustomerMapper.convertToEntity(customersDto);
        Optional<Customer> customers = customerRepository.findByEmail(customersEntities.getEmail());
        if (customers.isPresent()) {
            throw new ConflictException(UserConstants.RESOURCE_CUSTOMER, UserConstants.RESOURCE_EMAIL,
                    customersEntities.getEmail());
        }
        Customer savedUsers = customerRepository.save(customersEntities);
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
        Customer users = customerRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(UserConstants.RESOURCE_CUSTOMER,
                        UserConstants.RESOURCE_UUID, uuid));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public CustomerDto fetchCustomerByEmail(String email) {
        Customer users = customerRepository.findByEmail(email)
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
}
