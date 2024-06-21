/*
package com.demo.Test.Controller;




import com.demo.Test.Entities.Person;
import com.demo.Test.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    //Constructor Based Injection No need of using @Autowired
    private final PersonService personService;
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> allPerson = personService.getAllPerson();
        return ResponseEntity.ok(allPerson);
    }
}
*/
