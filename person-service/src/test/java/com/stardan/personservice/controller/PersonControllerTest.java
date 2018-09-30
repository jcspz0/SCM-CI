package com.stardan.personservice.controller;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.stardan.personservice.entity.Person;
import com.stardan.personservice.service.PersonService;
import com.stardan.personservice.service.PersonServiceImpl;
import com.stardan.personservice.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {

	MockMvc mockMvc;
	
    @Autowired
    protected WebApplicationContext wac;
	
	
    @Autowired
    private PersonController personController;
    
    @MockBean
    private PersonService personServiceImpl;

    private List<Person> people;
    
    @Before
    public void setup() throws Exception {

        this.mockMvc = standaloneSetup(this.personController).build();// Standalone context
        // mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        // .build();
		Date d=Utils.getDate("1992-09-20");
		people=new ArrayList<>();
        Person p1 = new Person();
        p1.setId(100);
        p1.setName("Luis");
        p1.setLastname("perez");
        p1.setBirthday(d);
        people.add(p1);
        Person p2 = new Person();
        p2.setId(101);
        p2.setName("Carlos");
        p2.setLastname("fernandez");
        p2.setBirthday(d);
        people.add(p2);
    }
    
    @Test
    public void testGetPeopleListReturnHTTPCode200() {
    	when(personServiceImpl.getAllPersons()).thenReturn(people);

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
	
}
