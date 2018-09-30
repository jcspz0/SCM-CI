package com.stardan.personservice.service;

import java.util.List;
import com.stardan.personservice.entity.Person;

public interface PersonService {
	
	List<Person> getAllPersons();
    Person getPersonById(long PersonId);
    List<Person> getPersonByName(String name);
    boolean addPerson(Person Person);
    void updatePerson(Person Person);
    void deletePerson(int PersonId);

}
