package com.didahdx.demospringweb.api;

import com.didahdx.demospringweb.model.Person;
import com.didahdx.demospringweb.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person") //used to set the path to this rest controller
@RestController //used to handle rest api request
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping //post request
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping //get request
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")  //get request with path in url
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path ="{id}") //delete request with path in url
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}") //put request with path in url
    public int updatePersonById(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody Person person){
        return personService.updatePersonById(id,person);
    }
}
