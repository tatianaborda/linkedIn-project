package com.tatianaborda.linkedInproject.controllers;

import com.tatianaborda.linkedInproject.models.Person;
import com.tatianaborda.linkedInproject.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {

    private PersonService personService;

    public PersonRestController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
}
