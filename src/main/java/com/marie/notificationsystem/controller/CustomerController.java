package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.model.model.Customer;
import com.marie.notificationsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('ADMIN')") //CRUD only accessible by admins
    @PostMapping("/addcustomer")
    public ResponseEntity addCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.addCustomer(customer));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updatecustomer")
    public ResponseEntity updateCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.updateCustomer(customer));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletecustomer")
    public ResponseEntity deleteCustomer (@RequestBody Customer customer) throws Exception{
        try {
            return ResponseEntity.ok(customerService.deleteCustomer(customer.getId()));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
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
