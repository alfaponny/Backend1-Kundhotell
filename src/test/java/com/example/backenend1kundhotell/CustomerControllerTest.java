package com.example.backenend1kundhotell;

import com.example.backenend1kundhotell.controllers.CustomerController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {



	@Autowired
	private MockMvc mockMvc;

    @Autowired
    private CustomerController customerController;

	@Test
    public void contextLoads() throws Exception {
        assertThat(customerController).isNotNull();
    }

	@Test
	public void shouldShowAddCustomerForm() throws Exception {
		this.mockMvc.perform(get("/customers/addCustomer"))
				.andExpect(status().isOk())
				.andExpect(view().name("addCustomer"))
				.andExpect(model().attributeExists("customer"));

	}

	@Test
	public void getAllCustomers() throws Exception {
		this.mockMvc.perform(get("/customers/all"))
				.andExpect(status().isOk())
				.andExpect(view().name("customers"))
				.andExpect(model().attributeExists("allCustomers"));
	}

}




