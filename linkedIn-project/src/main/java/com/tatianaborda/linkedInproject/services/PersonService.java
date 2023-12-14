package com.tatianaborda.linkedInproject.services;

import com.tatianaborda.linkedInproject.data.PersonRepository;
import com.tatianaborda.linkedInproject.models.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional <Person> getById(long id){
        return personRepository.findById(id);
    }
}
