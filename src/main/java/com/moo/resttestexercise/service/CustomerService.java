package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;
import com.moo.resttestexercise.pojo.CustomerSearchResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void deleteAll();

    Optional<Customer> findById(Long id);

    List<CustomerSearchResult> findBySurname(String surname);

    Customer addCustomer(String firstName, String surname, String city, LocalDate dateOfBirth, String telephoneNumber);

}
