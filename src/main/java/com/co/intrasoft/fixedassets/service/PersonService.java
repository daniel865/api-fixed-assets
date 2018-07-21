package com.co.intrasoft.fixedassets.service;

import com.co.intrasoft.fixedassets.exceptions.NotFoundException;
import com.co.intrasoft.fixedassets.model.Person;
import com.co.intrasoft.fixedassets.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPerson(String id) {
        return personRepository.findById(id);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(String id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (!optionalPerson.isPresent()) {
            throw new NotFoundException();
        }
        personRepository.deleteById(id);
    }

}
