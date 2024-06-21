/*
package com.demo.Test.Service;

;
import java.util.List;

import com.demo.Test.Entities.Person;
import com.demo.Test.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class
public class PersonService {
//No need to use @Autowired when using Constructor Injection
//Dependencies are final

    private final PersonRepo repo;
    public PersonService(PersonRepo repo)
    {
        // this keyword refers to current instance
        this.repo = repo;
    }

    public List<Person> getAllPerson()
    {
        List<Person> personList = repo.findAll();
         return personList;
    }


}

*/
