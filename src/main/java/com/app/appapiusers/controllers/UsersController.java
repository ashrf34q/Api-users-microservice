package com.app.appapiusers.controllers;

import com.app.appapiusers.mapper.UserDTO;
import com.app.appapiusers.mapper.UserMapper;
import com.app.appapiusers.model.User;
import com.app.appapiusers.model.UserResponseModel;
import com.app.appapiusers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private Environment env;
    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/status")
    public String status(){
        return "Working on port " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody User user){
        UserDTO userDTO = userMapper.userToUserDTO(user);

        UserDTO savedDTO = userService.createUser(userDTO);

        UserResponseModel returnModel = userMapper.userDTOToUserResponseModel(savedDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnModel);
    }
}
