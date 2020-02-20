package com.moo.resttestexercise.pojo;

import java.util.Objects;

public class CustomerSearchResult {

    private Long id;
    private String firstName;
    private String surname;
    private String city;

    public static CustomerSearchResult from(Customer customer) {
        return new CustomerSearchResult(customer.getId(),
                customer.getFirstName(), customer.getSurname(), customer.getCity());
    }

    /**
     * Constructor.
     *
     * @param id
     * @param firstName
     * @param surname
     * @param city
     */
    private CustomerSearchResult(final Long id, final String firstName, final String surname, final String city) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final com.moo.resttestexercise.pojo.CustomerSearchResult customer = (com.moo.resttestexercise.pojo.CustomerSearchResult) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

