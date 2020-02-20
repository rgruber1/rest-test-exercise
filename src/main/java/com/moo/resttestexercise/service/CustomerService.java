package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void deleteAll();

    Optional<Customer> findById(Long id);

    List<Customer> findBySurname(String surname);

    Customer addCustomer(String firstName, String surname, LocalDate dateOfBirth, String telephoneNumber);

}
