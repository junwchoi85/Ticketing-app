package com.jc.users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jc.common.exception.ConflictException;
import com.jc.common.exception.ResourceNotFoundException;
import com.jc.users.constants.UsersConstants;
import com.jc.users.dto.CustomerDto;
import com.jc.users.entity.Customer;
import com.jc.users.mapper.CustomerMapper;
import com.jc.users.repository.CustomerRepository;
import com.jc.users.service.IUsersService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements IUsersService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto signUpCustomer(CustomerDto customerDto) {
        Customer customerEntities = CustomerMapper.convertToEntity(customerDto);
        Optional<Customer> user = customerRepository.findByEmail(customerEntities.getEmail());
        if (user.isPresent()) {
            throw new ConflictException(UsersConstants.RESOURCE_CUSTOMER, UsersConstants.RESOURCE_EMAIL,
                    customerEntities.getEmail());
        }
        Customer savedUsers = customerRepository.save(customerEntities);
        return CustomerMapper.convertToDto(savedUsers);
    }

    @Override
    public CustomerDto fetchCustomerById(Long id) {
        Customer users = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(UsersConstants.RESOURCE_CUSTOMER,
                        UsersConstants.RESOURCE_ID, String.valueOf(id)));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public CustomerDto fetchCustomerByUuid(String uuid) {
        Customer users = customerRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(UsersConstants.RESOURCE_CUSTOMER,
                        UsersConstants.RESOURCE_UUID, uuid));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public CustomerDto fetchCustomerByEmail(String email) {
        Customer users = customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(UsersConstants.RESOURCE_CUSTOMER,
                        UsersConstants.RESOURCE_EMAIL, email));
        return CustomerMapper.convertToDto(users);
    }

    @Override
    public boolean editCustomerDetails(CustomerDto usersDto) {
        Customer users = customerRepository.findByUuid(usersDto.getUuid())
                .orElseThrow(() -> new ResourceNotFoundException(UsersConstants.RESOURCE_CUSTOMER,
                        UsersConstants.RESOURCE_UUID, usersDto.getUuid()));
        Customer updatedUsers = CustomerMapper.mapToEntity(usersDto, users);
        customerRepository.save(updatedUsers);
        return true;
    }

    @Override
    public boolean deactivateCustomer(CustomerDto usersDto) {
        Customer users = customerRepository.findByEmail(usersDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException(UsersConstants.RESOURCE_CUSTOMER,
                        UsersConstants.RESOURCE_EMAIL, usersDto.getEmail()));
        customerRepository.deleteById(users.getId());
        return true;
    }

    @Override
    public List<CustomerDto> listAllCustomers() {
        List<Customer> users = customerRepository.findAll();
        return users.stream().map(CustomerMapper::convertToDto).collect(Collectors.toList());
    }
}
