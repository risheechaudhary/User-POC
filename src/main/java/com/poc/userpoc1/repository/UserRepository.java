package com.poc.userpoc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.poc.userpoc1.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="select * from User u where "+
				"u.firstname like concat('%',:query,'%') "+
				"or u.lastname like concat('%',:query,'%') "+
				"or u.pincode like concat('%',:query,'%') ",nativeQuery = true)
	List<User> searchUsers(String query);
	
//	@Query("select u from user u where u.firstname like D%")
//	public List<User> findAll(String keyword);
//	public User get(Long id);
//	List<User> findByFirstName(String firstName);
}
