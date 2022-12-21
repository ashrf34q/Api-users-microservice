package com.app.appapiusers.service;

import com.app.appapiusers.entity.UserEntity;
import com.app.appapiusers.mapper.UserDTO;
import com.app.appapiusers.mapper.UserMapper;
import com.app.appapiusers.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());

        UserEntity userEntity = UserMapper.INSTANCE.userDTOToUserEntity(userDTO);
        userEntity.setEncryptedPass("test");

        userRepository.save(userEntity);
        return null;
    }
}
