package com.tatianaborda.linkedInproject.data;

import com.tatianaborda.linkedInproject.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "persons")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
