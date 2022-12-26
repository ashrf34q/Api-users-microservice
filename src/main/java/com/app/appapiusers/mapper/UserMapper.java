package com.app.appapiusers.mapper;

import com.app.appapiusers.entity.UserEntity;
import com.app.appapiusers.model.User;
import com.app.appapiusers.model.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userDTOToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDTO(UserEntity userEntity);

    UserDTO userToUserDTO(User user);

    UserResponseModel userDTOToUserResponseModel(UserDTO savedDTO);
}