package com.stardan.personservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stardan.personservice.entity.Person;
import com.stardan.personservice.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		List<Person> list = new ArrayList<>();
		personRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Person getPersonById(long personId) {
		Person obj = personRepository.findById(personId).get();
		return obj;
	}

	@Override
	public synchronized  boolean addPerson(Person person) {
		if (person.getName()==null || person.getLastname() == null || person.getBirthday()==null) {
			return false;
		}
		if (!validDate(person.getBirthday())) {
			return false;
		}
		List<Person> list = personRepository.findByNameAndLastname(person.getName(), person.getLastname()); 	
        if (list.size() > 0) {
        	personRepository.save(list.get(0));
        } else {
        	personRepository.save(person);
        }
        return true;
	}

	@Override
	public void updatePerson(Person person) {
		personRepository.save(person);
		
	}

	@Override
	public void deletePerson(int personId) {
		personRepository.delete(getPersonById(personId));
		
	}
	
	private boolean validDate(Date current) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date min = sdf.parse("1960-01-01");
			//Date current = sdf.parse(date);
			return min.compareTo(current)<0?true:false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Person> getPersonByName(String name) {
		List<Person> list = personRepository.findByName(name);
		if (list.size() <= 0) {
	           return null;
	        } else {
	        	return list;
	        }
	}
	
}
