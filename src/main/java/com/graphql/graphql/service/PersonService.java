package com.graphql.graphql.service;

import com.graphql.graphql.entity.Person;
import com.graphql.graphql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public Person createPerson(String personRecord) {
        Person person = new Person();
        person.setName(personRecord);

        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> existingPersonOptional = personRepository.findById(id);
        if (existingPersonOptional.isPresent()) {
            Person existingPerson = existingPersonOptional.get();
            existingPerson.setName(updatedPerson.getName());
            return personRepository.save(existingPerson);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " not found");
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

