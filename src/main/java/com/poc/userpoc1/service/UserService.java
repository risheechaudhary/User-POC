package com.poc.userpoc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.userpoc1.controller.UserController;
import com.poc.userpoc1.entity.User;
import com.poc.userpoc1.repository.UserRepository;

@Service
public interface UserService  {
	
	List<User> searchUsers(String query);
	
//	List<User> searchUser(String keyword);
	
//	public List<User> listAll(String keyword){
//		if(keyword!= null) {
//			return userRepository.findAll(keyword);
//		}
//		return userRepository.findAll();
//	}
	List<User> findUserWithSorting(String field);
	
	Iterable<User> findAll();
}
