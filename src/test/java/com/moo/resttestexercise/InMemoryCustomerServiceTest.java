package com.moo.resttestexercise;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsIterableContaining;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

public class InMemoryCustomerServiceTest {

    private InMemoryCustomerService service;

    @Before
    public void beforeEach() {
        service = new InMemoryCustomerService();
    }

    @Test
    public void testSearch() {
        assertThat(service.findBySurname("Bloggs"), IsEmptyCollection.empty());

        Customer customer = new Customer("Joe", "Bloggs", LocalDate.of(1970, 1, 1), "020 8255 4444");
        service.addCustomer(customer);

        assertThat(service.findBySurname("Smith"), IsEmptyCollection.empty());
        assertThat(service.findBySurname("Blog"), IsIterableContaining.hasItem(customer));
        assertThat(service.findBySurname("Bloggs"), IsIterableContaining.hasItem(customer));
    }
}
