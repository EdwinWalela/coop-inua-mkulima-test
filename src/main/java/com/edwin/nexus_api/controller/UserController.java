package com.edwin.nexus_api.controller;

import com.edwin.nexus_api.DTO.UserRequestDTO;
import com.edwin.nexus_api.model.User;
import com.edwin.nexus_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequest){
        User user = this.userService.createUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = this.userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
