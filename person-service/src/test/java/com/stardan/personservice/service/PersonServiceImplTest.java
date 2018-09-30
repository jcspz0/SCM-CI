package com.stardan.personservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito.Then;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import com.stardan.personservice.entity.Person;
import com.stardan.personservice.repository.PersonRepository;
import com.stardan.personservice.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {
	
	@Autowired
	private PersonServiceImpl personService;
	
	@MockBean
	private RestTemplate template;
	
	@MockBean
	private PersonRepository personRepository;
	
	@Test
	public void testAddPersonBirthDayLessThan1960ReturnFalse() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		Person p = new Person();
		p.setName("Sofia");
		p.setLastname("Suarez");
		p.setBirthday(Utils.getDate("1950-09-20"));
//		String url = "http://localhost:8088/person/person/8";
//		HttpEntity<Person> requestEntity = new HttpEntity<Person>(p, headers);
		
		//Optional<Person> o=Optional.of(p);
		List<Person> list = new ArrayList<Person>();
		
		try {
//			when(template.postForLocation(url, requestEntity)).thenReturn(new URI("asd"));
//			when(personService.addPerson(p)).thenReturn(true);
//			when(template.getForEntity(url, Person.class)).thenReturn(new ResponseEntity(p,HttpStatus.OK));
//			when(personRepository.findById(10L)).thenReturn(Optional.of(p));
			when(personRepository.findByNameAndLastname("Sofia","Suarez")).thenReturn(list);
			//when(personRepository.save(p)).th;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//when(template.getForEntity("",String.class,new ResponseEntity(p, HttpStatus.OK)));
		assertFalse(personService.addPerson(p));
		
	}
	
	@Test
	public void testAddPersonWithoutLastnameReturnFalse() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		Person p = new Person();
		p.setName("Sofia");
		//p.setLastname("Suarez");
		p.setBirthday(Utils.getDate("1992-09-20"));
//		String url = "http://localhost:8088/person/person/8";
//		HttpEntity<Person> requestEntity = new HttpEntity<Person>(p, headers);
		
		//Optional<Person> o=Optional.of(p);
		List<Person> list = new ArrayList<Person>();
		
		try {
//			when(template.postForLocation(url, requestEntity)).thenReturn(new URI("asd"));
//			when(personService.addPerson(p)).thenReturn(true);
//			when(template.getForEntity(url, Person.class)).thenReturn(new ResponseEntity(p,HttpStatus.OK));
//			when(personRepository.findById(10L)).thenReturn(Optional.of(p));
			when(personRepository.findByNameAndLastname("Sofia","Suarez")).thenReturn(list);
			//when(personRepository.save(p)).th;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//when(template.getForEntity("",String.class,new ResponseEntity(p, HttpStatus.OK)));
		assertFalse(personService.addPerson(p));
		
	}
	
	@Test
	public void testGetPersonById() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		Person p = new Person();
		p.setName("Sofia");
		p.setLastname("Suarez");
		p.setBirthday(Utils.getDate("1992-09-20"));
		
		when(personRepository.findById(10L)).thenReturn(Optional.of(p));
		
		Person personByName = personService.getPersonById(10);
		System.out.println(personByName.getId());
		assertThat(personByName).isNotNull();
		assertThat(personByName.getName()).contains("Sofia");
	}

}
