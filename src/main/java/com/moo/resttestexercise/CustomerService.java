package com.moo.resttestexercise;

import java.util.List;

public interface CustomerService {

    List<Customer> findBySurname(String surname);
}
