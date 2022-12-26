package com.app.appapiusers.service;

import com.app.appapiusers.entity.UserEntity;
import com.app.appapiusers.mapper.UserDTO;
import com.app.appapiusers.mapper.UserMapper;
import com.app.appapiusers.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());

        userDTO.setEncryptedPass(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        UserEntity userEntity = userMapper.userDTOToUserEntity(userDTO);

        UserEntity savedEntity = userRepository.save(userEntity);

        return userMapper.userEntityToUserDTO(savedEntity);
    }
}
