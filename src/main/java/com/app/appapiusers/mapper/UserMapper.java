package com.app.appapiusers.mapper;

import com.app.appapiusers.entity.UserEntity;
import com.app.appapiusers.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userDTOToUserEntity(UserDTO userDTO);

    UserDTO userToUserDTO(User user);
}