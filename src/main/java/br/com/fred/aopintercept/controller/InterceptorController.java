package br.com.fred.aopintercept.controller;

import br.com.fred.aopintercept.annotation.CryptoEncapsulation;
import br.com.fred.aopintercept.annotation.LogExecutionTime;
import br.com.fred.aopintercept.model.Person;
import br.com.fred.aopintercept.service.InterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterceptorController {

    @Autowired
    InterceptorService service;

    @GetMapping("/list-people")
    @LogExecutionTime
    public List<Person> getPeople() {
        return service.getPeople();
    }

    @PostMapping("/person")
    @CryptoEncapsulation
    public ResponseEntity<Person> addPerson(@RequestBody Person person, @RequestHeader("cripto") String cripto) {
        return new ResponseEntity<Person>(service.addPerson(person), HttpStatus.OK);
    }
}
