package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;
import com.moo.resttestexercise.pojo.CustomerSearchResult;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsIterableContaining;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class InMemoryCustomerServiceTest {

    private InMemoryCustomerService service;

    @Before
    public void beforeEach() {
        service = new InMemoryCustomerService();
    }

    @Test
    public void findById() {
        assertEquals(service.findById(1L), Optional.empty());

        Customer customer = service.addCustomer("Joe", "Bloggs", "London", LocalDate.of(1970, 1, 1), "020 8255 4444");
        assertEquals(Optional.of(customer), service.findById(1L));
    }

    @Test
    public void testSearch() {
        assertThat(service.findBySurname("Bloggs"), IsEmptyCollection.empty());

        Customer customer = service.addCustomer("Joe", "Bloggs", "London", LocalDate.of(1970, 1, 1), "020 8255 4444");

        assertThat(service.findBySurname("Smith"), IsEmptyCollection.empty());
        assertThat(service.findBySurname("Blog"), IsIterableContaining.hasItem(CustomerSearchResult.from(customer)));
        assertThat(service.findBySurname("Bloggs"), IsIterableContaining.hasItem(CustomerSearchResult.from(customer)));
    }
}
