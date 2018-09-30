package com.stardan.personservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stardan.personservice.entity.Person;
import com.stardan.personservice.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplIntegrationTest {

	@Autowired
	private PersonServiceImpl personServiceImpl;
	
	@Before
	public void setUp() {
		List<Person> people=personServiceImpl.getAllPersons();
		if(people.size()<=0) {
			Person p = new Person();
			p.setId(0);
			p.setName("prueba");
			p.setLastname("prueba");
			p.setBirthday(Utils.getDate("1992-09-20"));
			personServiceImpl.addPerson(p);
		}
	}
	
	@Test
	public void testAddPerson() {
		Person p = new Person();
		p.setId(0);
		p.setName("prueba");
		p.setLastname("prueba");
		p.setBirthday(Utils.getDate("1992-09-20"));
		personServiceImpl.addPerson(p);
	}
	
	@Test
	public void testGetPeople() {
		List<Person> people=personServiceImpl.getAllPersons();
		assertThat(people).isNotNull().isNotEmpty();
	}
	
}
