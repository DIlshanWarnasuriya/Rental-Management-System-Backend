package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Customer;
import org.icet.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @GetMapping
    List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @PatchMapping
    Customer updateCustomer(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }
}
