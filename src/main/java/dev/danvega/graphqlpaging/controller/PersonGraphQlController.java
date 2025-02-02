package dev.danvega.graphqlpaging.controller;

import dev.danvega.graphqlpaging.model.Person;
import dev.danvega.graphqlpaging.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class PersonGraphQlController {

    private final PersonRepository repository;

    //@SchemaMapping(typeName = "Query", value = "allPeople")
    @QueryMapping
    public Iterable<Person> allPeople() {
        return repository.findAll();
    }

    @QueryMapping
    public Page<Person> allPeoplePaged(@Argument int page, @Argument int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

}
