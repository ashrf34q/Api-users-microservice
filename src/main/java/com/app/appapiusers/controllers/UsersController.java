package com.app.appapiusers.controllers;

import com.app.appapiusers.mapper.UserDTO;
import com.app.appapiusers.mapper.UserMapper;
import com.app.appapiusers.model.User;
import com.app.appapiusers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private Environment env;

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/status")
    public String status(){
        return "Working on port" + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody User user){
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);

        userService.createUser(userDTO);

        return "Created User successfully";
    }
}
