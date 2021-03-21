package com.didahdx.demospringweb.dao;

import com.didahdx.demospringweb.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccess implements PersonDao {
    private static List<Person> DB=new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(person);
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe=selectPersonById(id);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p->{
            int personIndex=DB.indexOf(p);
            if (personIndex>=0){
                DB.set(personIndex,new Person(id,person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
