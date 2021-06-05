package com.ps.user.services;

import com.ps.user.services.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        return userRepository.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
