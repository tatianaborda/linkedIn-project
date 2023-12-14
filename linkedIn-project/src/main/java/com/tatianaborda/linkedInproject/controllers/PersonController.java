package com.tatianaborda.linkedInproject.controllers;

import com.tatianaborda.linkedInproject.models.Person;
import com.tatianaborda.linkedInproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public String getAllPersons(Model model){
        model.addAttribute("persons", personService.getAllPersons());
        return "persons";
    }
}
