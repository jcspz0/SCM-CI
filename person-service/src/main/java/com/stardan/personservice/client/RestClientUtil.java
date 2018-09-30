package com.stardan.personservice.client;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.stardan.personservice.entity.Person;

public class RestClientUtil {
	public void getPersonByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8088/person/person/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Person.class, 1);
        Person Person = responseEntity.getBody();
        System.out.println("Id:"+Person.getId()+", Name:"+Person.getName()
                 +", Last Name:"+Person.getLastname());      
    }
    public void getAllPersonsDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8088/person/persons";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Person[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Person[].class);
        Person[] Persons = responseEntity.getBody();
        for(Person Person : Persons) {
        	System.out.println("Id:"+Person.getId()+", Name:"+Person.getName()
            +", Last Name:"+Person.getLastname());   
        }
    }
    public void addPersonDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8088/person/person";
		Person objPerson = new Person();
		objPerson.setName("Juan Carlos");
		objPerson.setLastname("Suarez");
		objPerson.setBirthday(new Date(1992, 9, 20));;
        HttpEntity<Person> requestEntity = new HttpEntity<Person>(objPerson, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updatePersonDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8088/person/person";
	Person objPerson = new Person();
	objPerson.setId(1);
	objPerson.setName("Marianne");
	objPerson.setLastname("Melgar");
        HttpEntity<Person> requestEntity = new HttpEntity<Person>(objPerson, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deletePersonDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8088/person/person/{id}";
        HttpEntity<Person> requestEntity = new HttpEntity<Person>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getPersonByIdDemo();
    	util.addPersonDemo();
    	//util.updatePersonDemo();
    	//util.deletePersonDemo();
    	//util.getAllPersonsDemo();    	
    }    
}
