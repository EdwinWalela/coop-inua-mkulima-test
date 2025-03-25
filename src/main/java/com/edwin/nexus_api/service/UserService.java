package com.edwin.nexus_api.service;

import com.edwin.nexus_api.DTO.UserCreationDTO;
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

    public UserRequestDTO createUser(UserCreationDTO userRequest){
        User user = new User(
                null,
                userRequest.getEmailAddress(),
                userRequest.getPassword(),
                null
        );
        User createdUser = this.userRepository.save(user);
        return new UserRequestDTO(
                createdUser.getId(),
                createdUser.getEmailAddress()
        );
    }

    public List<UserRequestDTO> getAllUsers(){
        List<User> users = this.userRepository.findAll();
        List<UserRequestDTO> userDTOs = users.stream().map(user -> {
            UserRequestDTO userDTO = new UserRequestDTO();
            userDTO.setId(user.getId());
            userDTO.setEmailAddress(user.getEmailAddress());
            return userDTO;
        }).toList();
        return userDTOs;
    }

    public UserRequestDTO getUserById(Integer id){
        User user = this.userRepository.findById(id).orElseThrow();
        return new UserRequestDTO(
                user.getId(),
                user.getEmailAddress()
        ) ;
    }
}
