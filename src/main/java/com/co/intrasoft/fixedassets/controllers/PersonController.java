package com.co.intrasoft.fixedassets.controllers;

import com.co.intrasoft.fixedassets.exceptions.NotFoundException;
import com.co.intrasoft.fixedassets.model.Person;
import com.co.intrasoft.fixedassets.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = "/person",
        produces = { "application/json", "text/xml" },
        consumes = { "application/json", "text/xml" }
)
@CrossOrigin(origins = "*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        // TODO: Add validations
        return personService.createPerson(person);
    }

    @GetMapping(
            path = "/{personId}",
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    public ResponseEntity<Person> getPerson(@PathVariable("personId") String personId) {
        Optional<Person> optionalPerson = personService.getPerson(personId);
        if (optionalPerson.isPresent()) {
            new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Person(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PutMapping(
            path = "/{personId}",
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Person updatePerson(@PathVariable("personId") String personId, @RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping(
            path = "/{personId}",
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("personId") String personId) {
        try {
            personService.deletePerson(personId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("La persona no se pudo encontrar");
        }
    }


}
