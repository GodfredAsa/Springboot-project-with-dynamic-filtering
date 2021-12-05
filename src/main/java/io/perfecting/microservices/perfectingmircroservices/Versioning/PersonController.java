package io.perfecting.microservices.perfectingmircroservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("person1/v1" )
    public Person1 getPerson1Version(){
        Person1 person1 = new Person1(new Name("John", "Doe"));
        return   person1;
    }

    @GetMapping("person2/v1" )
    public Person2 getPerson2Version(){
        Person2 person2 = new Person2("John Doe");
        return   person2;
    }
}
