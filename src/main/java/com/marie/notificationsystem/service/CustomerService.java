package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer (Customer customer) throws Exception;

    boolean updateCustomer (Customer customer);

    boolean deleteCustomer(Long id);

    List<Customer> findCustomer();

}
