package com.app.appapiusers.repositories;

import com.app.appapiusers.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}