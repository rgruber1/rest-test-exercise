package com.moo.resttestexercise.controller;

import com.moo.resttestexercise.pojo.Customer;
import com.moo.resttestexercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Customer> search(@RequestParam(value = "surname") String surname) {
        return customerService.findBySurname(surname);
    }

}
