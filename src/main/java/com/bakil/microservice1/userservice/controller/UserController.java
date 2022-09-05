package com.bakil.microservice1.userservice.controller;

import com.bakil.microservice1.userservice.domain.User;
import com.bakil.microservice1.userservice.domain.UserDto;
import com.bakil.microservice1.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private  final UserService userService;
    private Logger log = LoggerFactory.getLogger(UserController.class);
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("call to saveUser");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id){
        log.info("call to getUserById");
        return userService.getUserById(id);
    }
}
