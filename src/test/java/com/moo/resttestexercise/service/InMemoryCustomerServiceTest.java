package com.moo.resttestexercise.service;

import com.moo.resttestexercise.pojo.Customer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsIterableContaining;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class InMemoryCustomerServiceTest {

    private InMemoryCustomerService service;

    @Before
    public void beforeEach() {
        service = new InMemoryCustomerService();
    }

    @Test
    public void testSearch() {
        MatcherAssert.assertThat(service.findBySurname("Bloggs"), IsEmptyCollection.empty());

        Customer customer = new Customer("Joe", "Bloggs", LocalDate.of(1970, 1, 1), "020 8255 4444");
        service.addCustomer(customer);

        MatcherAssert.assertThat(service.findBySurname("Smith"), IsEmptyCollection.empty());
        MatcherAssert.assertThat(service.findBySurname("Blog"), IsIterableContaining.hasItem(customer));
        MatcherAssert.assertThat(service.findBySurname("Bloggs"), IsIterableContaining.hasItem(customer));
    }
}
