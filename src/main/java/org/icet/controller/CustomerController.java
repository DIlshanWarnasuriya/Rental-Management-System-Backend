package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Customer;
import org.icet.service.CustomerService;
import org.springframework.web.bind.annotation.*;

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
}
