package com.nilimesh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilimesh.spring.entities.User;
import com.nilimesh.spring.exception.ERROR_MessageException;
import com.nilimesh.spring.repositories.UserRepository;
import com.nilimesh.spring.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UserController {
	//@Autowired
	//private UserRepository userRepository;
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	//@CrossOrigin(origins = "*")
	public List<User> getUsers() throws ERROR_MessageException{
//		List<User> userList= (List<User>) userRepository.findAll();
//		if(userList.size()==0) {
//			throw new ERROR_MessageException("Data is not avalable");
//		}
//		return userList;
		List<User> userList=service.getUsers();
		return userList;
	}
	//@CrossOrigin(origins = "*")
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) throws ERROR_MessageException{
		//return  userRepository.findById(id).get();
		return service.getUser(id);
	}
	
	@DeleteMapping("/user/{id}")
	//@CrossOrigin(origins = "*")
	public boolean deleteUser(@PathVariable Long id) throws ERROR_MessageException{
		//userRepository.deleteById(id);
		service.deleteUser(id);
		return true;
	}
	//@CrossOrigin(origins = "*")
	@PostMapping("/user")
	public User createUser(@RequestBody User user) throws ERROR_MessageException{
		// return userRepository.save(user);
		return service.createUser(user);
	}
	//@CrossOrigin(origins = "*")
	@PutMapping("/user")
	public User updateeUser(@RequestBody User user) throws ERROR_MessageException{
		//return  userRepository.save(user);
		return service.updateUser(user);
	}
}
