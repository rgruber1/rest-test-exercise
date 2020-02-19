package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findBySurname(String surname);

    void addCustomer(Customer customer);
}
