package com.example.chatserver.controller;

import com.example.chatserver.pojo.LoginRequest;
import com.example.chatserver.pojo.User;
import com.example.chatserver.pojo.UserX;
import com.example.chatserver.repository.UsersRepository;
import com.example.chatserver.resources.UsersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class AppController {
	private List<User> validUsers = new ArrayList<>();
	@Autowired
	private UsersRepository usersRepository;
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public User userLogin(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
		System.out.println(usersRepository.findAll());

		Optional<User> userx =usersRepository.findAll().stream().filter(u -> u.getUserName().equalsIgnoreCase(loginRequest.getName())).findFirst();


//		Optional<User> userx = getValidUsers()
//				.stream()
//				.filter(u -> u.getUserName().equalsIgnoreCase(loginRequest.getName()))
//				.findFirst();
//
////		Optional<UserX> user = getValidUsers()
////								.stream()
////								.filter(u -> u.getUserName().equalsIgnoreCase(loginRequest.getName()))
////								.findFirst();
//
//		if (userx.isPresent()) {
//			return userx.get();
//		} else {
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			return null;
//		}

		if(userx.isPresent())
		{
			return userx.get();
		} else
		{
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}

	}
	

	public List<User> listUsers() {
		return usersRepository.findAll();
	}
	
	private List<User> getValidUsers() {
		return usersRepository.findAll();

	}


}
