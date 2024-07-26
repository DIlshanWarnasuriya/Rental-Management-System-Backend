package org.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.icet.dto.Customer;
import org.icet.entity.CustomerEntity;
import org.icet.repository.CustomerRepository;
import org.icet.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Customer addCustomer(Customer customer) {
        CustomerEntity entity = repository.save(mapper.convertValue(customer, CustomerEntity.class));
        return mapper.convertValue(entity, Customer.class);
    }
}
