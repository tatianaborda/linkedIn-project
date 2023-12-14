package com.tatianaborda.linkedInproject.tasks;

import com.tatianaborda.linkedInproject.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DirectoryRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DirectoryRunner.class);

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Directory of persons: ");
        personService.getAllPersons().forEach(person ->{
            LOG.info(person.toString());
        });
            LOG.info("END OF LOG");
    }
}
