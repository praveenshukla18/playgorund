package com.ps.playground;

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

    @GetMapping("/test")
    public void test(){
        User user = new User();
        user.setUserName("pshkl");
        user.setFirstName("Praveen");
        user.setLastName("Shukla");
        user.setEmail("praveenshkl@gmail.com");
        user.setCity("Pune");
        user.setCountry("India");
        user.setPhone("8888899999");
        userRepository.save(user);
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
