package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.Customer;
import com.marie.notificationsystem.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }
    @Transactional
    @Override
    public boolean updateCustomer(Customer customer) {
        Customer oldCustomer = customerRepository.findById(customer.getId()).orElse(null);
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setLastName(customer.getLastName());
        return true;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Customer> findCustomer() {
        return customerRepository.findAll();
    }


}
