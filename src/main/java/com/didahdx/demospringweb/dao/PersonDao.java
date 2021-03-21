package com.didahdx.demospringweb.dao;

import com.didahdx.demospringweb.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int  insertPerson(UUID id, Person person);

    default int addPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getAllPersons();

    int deletePersonById(UUID id);

    int updatePersonById(UUID id,Person person);

    Optional<Person> selectPersonById(UUID id);
}
