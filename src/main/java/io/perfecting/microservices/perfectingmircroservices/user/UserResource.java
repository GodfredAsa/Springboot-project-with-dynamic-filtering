package io.perfecting.microservices.perfectingmircroservices.user;

import io.perfecting.microservices.perfectingmircroservices.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

     // GET/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

//    GET USER BY ID **** uri "/users/userId"
    @GetMapping("/users/{Id}")
    public User findUser(@PathVariable("Id") Integer Id){
        User user = service.findUser(Id);
        if(user==null)
            throw new UserNotFoundException("User with " + Id + " not Found");
       return service.findUser(Id);
    }

//    GET -->   CREATE USER   [uri]==>   "/user{Id}"
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location   = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{Id}")
    public void deleteUser(@PathVariable("Id") Integer Id){
        User user = service.deleteUser(Id);
        if(user==null)
            throw new UserNotFoundException("User with Id - " + Id + " not found");
    }

}
