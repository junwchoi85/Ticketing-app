package com.jc.users.mapper;

import com.jc.users.dto.CustomerDto;
import com.jc.users.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToDto(Customer customer, CustomerDto customerDto) {
        customerDto.setUuid(customer.getUuid());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        return customerDto;
    }

    public static Customer mapToEntity(CustomerDto customerDto, Customer customer) {
        customer.setUuid(customerDto.getUuid());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        return customer;
    }

    public static CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUuid(customer.getUuid());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        return customerDto;
    }

    public static Customer convertToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setUuid(customerDto.getUuid());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        return customer;
    }
}
