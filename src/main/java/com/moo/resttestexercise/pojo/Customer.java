package com.moo.resttestexercise.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String telephoneNumber;

    public Customer(final String firstName, final String lastName, final LocalDate dateOfBirth,
                    final String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
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
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) &&
                Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
