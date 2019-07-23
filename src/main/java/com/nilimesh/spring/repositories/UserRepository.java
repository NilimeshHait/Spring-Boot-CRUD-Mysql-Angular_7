package com.nilimesh.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nilimesh.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
