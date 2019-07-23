package com.nilimesh.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nilimesh.spring.entities.User;
import com.nilimesh.spring.repositories.UserRepository;

@SpringBootApplication
public class UserCrudBackendApplication {
	
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserCrudBackendApplication.class, args);
	}
	
//	@Override
//	implements CommandLineRunner
//	public void run(String... args) throws Exception {
//		userRepository.save(new User("Nilimesh","Hait"));
//		userRepository.save(new User("Rishita","Roy"));
//		userRepository.save(new User("Sourav","Ganguly"));
//	}

}
