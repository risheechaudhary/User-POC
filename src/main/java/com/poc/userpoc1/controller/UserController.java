package com.poc.userpoc1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userpoc1.entity.User;
import com.poc.userpoc1.exception.UserNotFoundException;
import com.poc.userpoc1.repository.UserRepository;
import com.poc.userpoc1.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component
@Validated
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("")
	public User newUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/get-all-users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/get-user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/update-user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userRepository.findById(id)
				.map(User ->{
					user.setFirstName(user.getFirstName());
					user.setLastName(user.getLastName());
					user.setDob(user.getDob());
					user.setPass(user.getPass());
					user.setJoiningdate(user.getJoiningdate());
					user.setPincode(user.getPincode());
					return userRepository.save(user);
				}).orElseThrow(()->new UserNotFoundException(id));
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable Long id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return "user with id: "+id+" is succesfully deleted";
	}
//	@PostMapping("/users/{}")
//	public String doSearchUser(@ModelAttribute("UserSearchData") User formData, Model model) {
//		User u = userRepository.get(formData.getId());
//		model.addAttribute("User",u);
//		return "User";
//		
//	}
	@GetMapping("/search")
	public ResponseEntity<List<User>> searchUsers(@RequestParam("query") String query){
		
		return ResponseEntity.ok(userService.searchUsers(query));
	}
	
	@GetMapping("/{field}")
	public List<User> getUserwithSort(@PathVariable String field){
		
		List<User> allUsers = userService.findUserWithSorting(field);
		return allUsers;
	}
	
	@GetMapping
	public Iterable<User> findAll() {
		return userService.findAll();
	}
	
}
