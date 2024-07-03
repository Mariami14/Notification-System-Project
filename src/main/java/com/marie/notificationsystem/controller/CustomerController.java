package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.model.model.Customer;
import com.marie.notificationsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    public ResponseEntity addCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.addCustomer(customer));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/updatecustomer")
    public ResponseEntity updateCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.updateCustomer(customer));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/deletecustomer")
    public ResponseEntity deleteCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.deleteCustomer(customer.getId()));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getcustomers")
    public ResponseEntity findCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.findCustomer());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
