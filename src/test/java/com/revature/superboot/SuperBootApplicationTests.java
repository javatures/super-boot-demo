package com.revature.superboot;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import com.revature.superboot.controllers.TrainerController;
import com.revature.superboot.models.Person;
import com.revature.superboot.repositories.TrainerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class SuperBootApplicationTests {
	private MockMvc mockMvc;

	@MockBean
	TrainerRepository trainerRepository;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new TrainerController(trainerRepository)).build();
	}

	@Test
	void testHello() throws Exception {
		this.mockMvc.perform(get("/api/v1/trainers/hello/mehrab"))
			.andExpect(status().isOk())
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}

	@Test
	void testGetAll() throws Exception {
		this.mockMvc.perform(get("/api/v1/trainers/all"))
			.andExpect(status().isOk())
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}

	@Test
	void testGetAllForReal() throws Exception {
		// given(this.service.greet()).willReturn("Hello");
        // String actual = this.userOfService.makeUse();
		given(this.trainerRepository.getAll()).willReturn(new ArrayList<Person>());

		this.mockMvc.perform(get("/api/v1/trainers/all"))
			.andExpect(status().isOk())
			.andDo(MockMvcResultHandlers.print())
			.andExpect(content().string("[]"))
			.andReturn();
	}

	@Test
	void testGetOne() throws Exception {
		given(this.trainerRepository.findById(1)).willReturn(new Person(1, "bob", new Pokemon()));
		this.mockMvc.perform(get("/api/v1/trainers/1"))
			.andExpect(status().isOk())
			.andExpect(content().string("['name':'Bob', 'pokemon':{
				'name':'Eevee',
			}]"))
			.andDo(MockMvcResultHandlers.print())
			.andReturn();
	}

}
