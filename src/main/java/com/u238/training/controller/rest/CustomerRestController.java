package com.u238.training.controller.rest;

import com.u238.training.entity.Customer;
import com.u238.training.errorResponse.ServerException;
import com.u238.training.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(@Qualifier("customerServiceRegular") CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List getCustomers() {
        return customerService.getCustomerList();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new ServerException("Customer id:" + customerId + " not found");
        } else {
            return customer;
        }
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new ServerException("Unable to delete. Customer id:" + customerId + " not found");
        } else
            customerService.deleteCustomer(customerId);

        return "Deleted customer id: " + customerId;
    }
    
    
}
