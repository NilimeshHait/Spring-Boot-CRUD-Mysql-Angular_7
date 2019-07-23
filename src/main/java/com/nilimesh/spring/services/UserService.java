package com.nilimesh.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nilimesh.spring.entities.User;
import com.nilimesh.spring.exception.ERROR_MessageException;
import com.nilimesh.spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers() throws ERROR_MessageException{
		List<User> userList= null;
		try {
			userList=(List<User>) userRepository.findAll();
			
		}catch (Exception e) {
			throw new ERROR_MessageException("Data is not Avalable...");
		}
		return userList;
	}

	public User getUser(Long id) throws ERROR_MessageException{
		User user=null;
		try {
			user=userRepository.findById(id).get();
		} catch (Exception e) {
			throw new ERROR_MessageException("Data is not Avalable...");
		}
		return user;
	}
	
	public boolean deleteUser(Long id) throws ERROR_MessageException{
		boolean isDeleted=false;
		try {
			userRepository.deleteById(id);
			isDeleted=true;
		} catch (Exception e) {
			throw new ERROR_MessageException("Data is not Avalable.");
		}
		
		return isDeleted;
	}
	
	public User createUser(User user) throws ERROR_MessageException{
		User user1=null;
		try {
			user1=userRepository.save(user);
		} catch (Exception e) {
			throw new ERROR_MessageException("User not able to create");
		}
		return user1;
	}
	
	public User updateUser(User user) throws ERROR_MessageException{
		User user1=null;
		try {
			user1=userRepository.save(user);
		} catch (Exception e) {
			throw new ERROR_MessageException("User not able to update");
		}
		return user1;
	}
	
}
