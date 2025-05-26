package com.example.backenend1kundhotell;

import com.example.backenend1kundhotell.controllers.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;

/*	@Test
	public void shouldReturn404() throws Exception {
		this.mockMvc.perform(get("/URLdontexist")).andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void addNewCustomer() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" +
						port + "/customers", String.class)).contains("addCustomer");//obs fel
	}

	@Test
	public void addCustomer() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" +
				port + "/add", String.class)).contains("addCustomer.html");//obs fel
	}*/

	@Autowired
	private CustomerController customerController;

	@Test
	public void contextLoads() throws Exception{
		assertThat(customerController).isNotNull();
	}

}
