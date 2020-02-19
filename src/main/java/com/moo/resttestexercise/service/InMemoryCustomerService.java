package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class InMemoryCustomerService implements CustomerService {

    private AtomicInteger idGenerator = new AtomicInteger();
    private Set<Customer> customers = Collections.newSetFromMap(new ConcurrentHashMap());

    @Override
    public List<Customer> findBySurname(String surname) {
        return customers.stream().filter(customer -> StringUtils.containsIgnoreCase(customer.getSurname(), surname))
                .collect(Collectors.toList());
    }

    @Override
    public Customer addCustomer(String firstname, String surname, LocalDate dateOfBirth, String telephoneNumber) {
        Optional<Customer> optionalCustomer = customers.stream()
                .filter(customer -> Objects.equals(customer.getDateOfBirth(), dateOfBirth) &&
                        Objects.equals(customer.getFirstName(), firstname) &&
                        Objects.equals(customer.getSurname(), surname)).findAny();
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            Customer result =
                    new Customer(idGenerator.getAndIncrement(), firstname, surname, dateOfBirth, telephoneNumber);
            customers.add(result);
            return result;

        }
    }
}

