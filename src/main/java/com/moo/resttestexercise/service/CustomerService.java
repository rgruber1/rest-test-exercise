package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    List<Customer> findBySurname(String surname);

    Customer addCustomer(String firstname, String surname, LocalDate dateOfBirth, String telephoneNumber);
}
