package com.app.appapiusers.service;

import com.app.appapiusers.mapper.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
}