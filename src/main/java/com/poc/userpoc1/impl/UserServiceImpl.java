package com.poc.userpoc1.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Filter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poc.userpoc1.dto.UserDto;
import com.poc.userpoc1.entity.User;
import com.poc.userpoc1.repository.UserRepository;
import com.poc.userpoc1.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	private EntityManager entityManager;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> searchUsers(String query) {
		
		System.out.println("Inside search service ");
		List<User> users= userRepository.searchUsers(query);
		System.out.println("Total user found "+users.size()+"for "+query);
		return users;
	}

	@Override
	public List<User> findUserWithSorting(String field) {
		// TODO Auto-generated method stub
		return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
//	public List<UserDto> searchUser(String firstName){
//		List<UserDto> user = this.searchUser(firstName);
//		List<UserDto> collect = user.stream().map((user)->this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
//		return collect;
//	}

	@Override
	public Iterable<User> softDeleteUserById(Long id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedProductFilter");
		Iterable<User> user = userRepository.findAll();
		session.disableFilter("deletedUserFilter");
		return user;
	}
}
