package com.moo.resttestexercise;

import com.moo.resttestexercise.pojo.Customer;
import com.moo.resttestexercise.service.CustomerService;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    public void search() throws Exception {
        this.mockMvc.perform(get("/search").param("surname", "bloggs")).andExpect(status().isOk())
                .andExpect(content().string(IsEqual.equalTo("[]")));

        // given
        service.addCustomer("Joe", "Bloggs", LocalDate.of(1970, 1, 1), "020 8255 4444");
        // when, then
        this.mockMvc.perform(get("/search").param("surname", "bloggs")).andExpect(status().isOk()).andExpect(content()
                .string(IsEqual.equalTo(
                        "[{\"id\":0,\"firstName\":\"Joe\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1970-01-01\",\"telephoneNumber\":\"020 8255 4444\"}]")));

        // given
        service.addCustomer("Fred", "Bloggs", LocalDate.of(1982, 2, 11), "020 7433 1234");
        // when, then
        this.mockMvc.perform(get("/search").param("surname", "bloggs")).andExpect(status().isOk()).andExpect(content()
                .string(IsEqual.equalTo(
                        "[{\"id\":1,\"firstName\":\"Fred\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1982-02-11\",\"telephoneNumber\":\"020 7433 1234\"},{\"id\":0,\"firstName\":\"Joe\",\"surname\":\"Bloggs\",\"dateOfBirth\":\"1970-01-01\",\"telephoneNumber\":\"020 8255 4444\"}]")));
    }

}