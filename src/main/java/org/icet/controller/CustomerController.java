package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.dto.Customer;
import org.icet.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/{id}")
    Map<String, String> deleteCustomer(@PathVariable Integer id){
        return service.deleteCustomer(id);
    }

    @GetMapping("/{data}")
    List<Customer> searchCustomer(@PathVariable String data){
        return service.searchCustomer(data);
    }
}
