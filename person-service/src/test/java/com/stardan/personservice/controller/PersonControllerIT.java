package com.stardan.personservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.stardan.personservice.entity.Person;
import com.stardan.personservice.utils.Utils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonControllerIT {

	MockMvc mockMvc;
	
	@Autowired
    protected WebApplicationContext wac;
	
	@Autowired
    private PersonController personController;
	
	@Before
    public void setup() throws Exception {

        this.mockMvc = standaloneSetup(this.personController).build();
    }
	
	@Test
    public void testGetPeopleListReturnHTTPCode200() {
    	//when(personServiceImpl.getAllPersons()).thenReturn(people);

        MvcResult result=null;
		try {
			result = mockMvc.perform(get("/api/people").contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
			    .andDo(print())
			    .andExpect(status().is2xxSuccessful()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
    public void testAddPersonReturnHTTPCode201() {
		Person p1 = new Person();
        p1.setId(100);
        p1.setName("Prueba");
        p1.setLastname("Prueba");
        p1.setBirthday(Utils.getDate("1992-09-20"));
        MvcResult result=null;
		try {
			result = mockMvc.perform(post("/api/person")
					.contentType(MediaType.APPLICATION_JSON)
					.content(Utils.asJsonString(p1)
					//.accept(MediaType.APPLICATION_JSON)
					))
				
				.andDo(print())
			    .andDo(print())
			    .andExpect(status().is2xxSuccessful()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
