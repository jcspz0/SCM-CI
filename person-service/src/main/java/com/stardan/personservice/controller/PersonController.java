package com.stardan.personservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.stardan.personservice.entity.Person;
import com.stardan.personservice.service.PersonService;

@Controller
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {
		Person person = personService.getPersonById(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@GetMapping("person/name/{name}")
	public ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name) {
		List<Person> person = personService.getPersonByName(name);
		if(person==null) {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
	}
	
	@GetMapping("people")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> list = personService.getAllPersons();
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	@PostMapping("person")
	public ResponseEntity<Void> addPerson(@RequestBody Person person, UriComponentsBuilder builder) {
                boolean flag = personService.addPerson(person);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("person")
	public ResponseEntity<Person> updateperson(@RequestBody Person person) {
		personService.updatePerson(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	@DeleteMapping("person/{id}")
	public ResponseEntity<Void> deleteperson(@PathVariable("id") Integer id) {
		personService.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
