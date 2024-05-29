package com.graphql.graphql.controller;

import com.graphql.graphql.entity.Person;
import com.graphql.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    @Autowired
    public PersonService personService;

    //@SchemaMapping(typeName = "Query", value = "getPersonById")
    @QueryMapping
    public Person getPersonById(@Argument Long id){
        return personService.getPersonById(id);
    }

    @MutationMapping
    public Person createPerson(@Argument String name){
        return personService.createPerson(name);
    }
}
