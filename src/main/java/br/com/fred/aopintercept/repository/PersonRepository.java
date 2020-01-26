package br.com.fred.aopintercept.repository;

import br.com.fred.aopintercept.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    {
        people.add(new Person(1, "Woodpecker", "New York"));
        people.add(new Person(2, "Bugs Bunny", "Las Vegas"));
        people.add(new Person(3, "Mickey Mouse", "Orlando"));
        people.add(new Person(4, "Road Runner", "Boulder"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person addPerson(Person person) {
        people.add(person);
        return person;
    }
}
