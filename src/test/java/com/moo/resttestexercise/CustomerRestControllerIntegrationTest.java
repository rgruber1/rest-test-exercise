package com.moo.resttestexercise;

import com.moo.resttestexercise.service.CustomerService;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomerRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerService service;

    @Before
    public void before() {
        service.deleteAll();
    }

    @Test
    public void get() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")).andExpect(status().is4xxClientError());

        // given
        service.addCustomer("Joe", "Bloggs", "London", LocalDate.of(1970, 1, 1), "020 8255 4444");
        // when, then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")).andExpect(status().isOk()).andExpect(content()
                .string(IsEqual.equalTo(
                        "{\"id\":1,\"firstName\":\"Joe\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1970-01-01\",\"telephoneNumber\":\"020 8255 4444\"}")));
    }

    @Test
    public void search() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/search").param("surname", "bloggs"))
                .andExpect(status().isOk()).andExpect(content().string(IsEqual.equalTo("[]")));

        // given
        service.addCustomer("Joe", "Bloggs", "London", LocalDate.of(1970, 1, 1), "020 8255 4444");
        // when, then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/search").param("surname", "bloggs"))
                .andExpect(status().isOk()).andExpect(content().string(IsEqual.equalTo(
                "[{\"id\":1,\"firstName\":\"Joe\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1970-01-01\",\"telephoneNumber\":\"020 8255 4444\"}]")));

        // given
        service.addCustomer("Fred", "Bloggs", "Manchester", LocalDate.of(1982, 2, 11), "020 7433 1234");
        // when, then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/search").param("surname", "bloggs"))
                .andExpect(status().isOk()).andExpect(content().string(IsEqual.equalTo(
                "[{\"id\":1,\"firstName\":\"Joe\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1970-01-01\",\"telephoneNumber\":\"020 8255 4444\"},{\"id\":2,\"firstName\":\"Fred\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1982-02-11\",\"telephoneNumber\":\"020 7433 1234\"}]")));
    }

}