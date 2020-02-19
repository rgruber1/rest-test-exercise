package com.moo.resttestexercise.service;

import com.moo.resttestexercise.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class InMemoryCustomerService implements CustomerService {

    private Set<Customer> customers = Collections.newSetFromMap(new ConcurrentHashMap());

    @Override
    public List<Customer> findBySurname(String surname) {
        return customers.stream().filter(customer -> StringUtils.containsIgnoreCase(customer.getLastName(), surname))
                .collect(Collectors.toList());
    }

    void addCustomer(final Customer customer) {
        customers.add(customer);
    }
}

