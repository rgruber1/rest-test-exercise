package com.moo.resttestexercise.controller;

import com.moo.resttestexercise.pojo.Customer;
import com.moo.resttestexercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> get(@PathVariable("id") long id) {
        Optional<Customer> byId = customerService.findById(id);
        return byId.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/customers/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Customer> search(@RequestParam(value = "surname") String surname) {
        return customerService.findBySurname(surname);
    }

}
