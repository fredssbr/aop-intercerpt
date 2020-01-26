package br.com.fred.aopintercept.service;

import br.com.fred.aopintercept.model.Person;
import br.com.fred.aopintercept.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterceptorService {

    @Autowired
    PersonRepository repository;

    public List<Person> getPeople() {
        return repository.getPeople();
    }

    public Person addPerson(Person person) {
        return repository.addPerson(person);
    }
}
