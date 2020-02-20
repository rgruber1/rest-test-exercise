package com.moo.resttestexercise.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {

    private Long id;
    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;
    private String telephoneNumber;

    public Customer(final Long id, final String firstName, final String surname, final LocalDate dateOfBirth,
                    final String telephoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
