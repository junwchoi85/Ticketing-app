package com.jc.users.service;

import java.util.List;

import com.jc.users.dto.CustomerDto;

public interface IUsersService {
    public CustomerDto signUpCustomer(CustomerDto customerDto);
    public CustomerDto fetchCustomerById(Long id);
    public CustomerDto fetchCustomerByUuid(String uuid);
    public CustomerDto fetchCustomerByEmail(String email);
    public boolean editCustomerDetails(CustomerDto customerDto);
    public boolean deactivateCustomer(CustomerDto customerDto);
    public List<CustomerDto> listAllCustomers();
}
