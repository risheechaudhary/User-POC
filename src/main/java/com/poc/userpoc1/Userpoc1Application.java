package com.poc.userpoc1;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import com.poc.userpoc1.entity.User;
import com.poc.userpoc1.repository.UserRepository;

@SpringBootApplication
public class Userpoc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Userpoc1Application.class, args);
//		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		
//		System.out.println("Sorting-------------");
//		userRepository.findAll(Sort.by("firstname").and(Sort.by("lastname").and(Sort.by("pincode")))).forEach(System.out::println);
//	}
//	private static List<User> getUsersList(){
//		List<User> userList = new ArrayList<>();
//		userList.add(new User(30,"kk","scion","dsvsdcsdc",LocalDate.of(1999, Month.DECEMBER, 10),LocalDate.of(2022, Month.APRIL, 23),245435));
//		return null;
	}
}
