package com.stardan.personservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stardan.personservice.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByName(String name);
    List<Person> findDistinctByLastname(String lastname);
    List<Person> findByNameAndLastname(String name, String lastname);

    @Query("SELECT a FROM Person a WHERE a.name=:name and a.lastname=:lastname")
    List<Person> fetchPersons(@Param("name") String name, @Param("lastname") String lastname);
}
