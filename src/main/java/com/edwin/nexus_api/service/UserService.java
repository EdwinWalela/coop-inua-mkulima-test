package com.edwin.nexus_api.service;

import com.edwin.nexus_api.DTO.UserRequestDTO;
import com.edwin.nexus_api.model.User;
import com.edwin.nexus_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO userRequest){
        User user = new User(
                null,
                userRequest.getUsername(),
                userRequest.getStaffId(),
                userRequest.getEmailAddress()
        );
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(Integer id){
       return this.userRepository.findById(id).orElseThrow();
    }

}
