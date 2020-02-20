package com.moo.resttestexercise;

import com.moo.resttestexercise.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class RestTestExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTestExerciseApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CustomerService service) {
        return args -> {
            service.addCustomer("Fred", "Bloggs", LocalDate.of(1982, 2, 11), "020 7433 1234");
            service.addCustomer("Joe", "Bloggs", LocalDate.of(1970, 1, 1), "020 8255 4444");
        };
    }

}
