package com.edwin.nexus_api.controller;

import com.edwin.nexus_api.DTO.UserCreationDTO;
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

    @PostMapping("")
    public ResponseEntity<UserRequestDTO> createUser(@RequestBody UserCreationDTO userRequest){
        UserRequestDTO user = this.userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("")
    public ResponseEntity<List<UserRequestDTO>> getAllUsers(){
        List<UserRequestDTO> users = this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestDTO> getUserById(@PathVariable Integer id){
        UserRequestDTO user = this.userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
