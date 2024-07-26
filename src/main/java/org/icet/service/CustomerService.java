package org.icet.service;

import org.icet.dto.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    Map<String, String> deleteCustomer(Integer id);
}
