package com.app.appapiusers.mapper;

import com.app.appapiusers.entity.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void userDTOToUserEntity() {
        UserDTO user = new UserDTO();
        user.setEmail("Email@gmail.com");
        user.setUserId("43");
        user.setFirstName("Ashraf");
        user.setLastName("Makki");
        user.setEncryptedPass("test");
        user.setPassword("POSL");

        UserEntity userEntity = UserMapper.INSTANCE.userDTOToUserEntity(user);

        assertEquals(user.getEmail(), userEntity.getEmail());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
    }
}