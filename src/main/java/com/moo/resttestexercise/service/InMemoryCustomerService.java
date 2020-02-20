package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class InMemoryCustomerService implements CustomerService {

    private AtomicLong idGenerator = new AtomicLong(1);
    private Map<Long, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public void deleteAll() {
        customers.clear();
        idGenerator.set(1);
    }

    @Override
    public Optional<Customer> findById(final Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    @Override
    public List<Customer> findBySurname(String surname) {
        return customers.values().stream()
                .filter(customer -> StringUtils.containsIgnoreCase(customer.getSurname(), surname))
                .collect(Collectors.toList());
    }

    @Override
    public Customer addCustomer(String firstName, String surname, LocalDate dateOfBirth, String telephoneNumber) {
        Optional<Customer> optionalCustomer = customers.values().stream()
                .filter(customer -> Objects.equals(customer.getDateOfBirth(), dateOfBirth) &&
                        Objects.equals(customer.getFirstName(), firstName) &&
                        Objects.equals(customer.getSurname(), surname)).findAny();
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            Customer result =
                    new Customer(idGenerator.getAndIncrement(), firstName, surname, dateOfBirth, telephoneNumber);
            customers.put(result.getId(), result);
            return result;

        }
    }
}

