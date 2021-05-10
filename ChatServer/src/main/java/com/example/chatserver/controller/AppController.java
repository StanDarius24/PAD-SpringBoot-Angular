package com.example.chatserver.controller;




import com.example.chatserver.pojo.LoginRequest;
import com.example.chatserver.pojo.User;
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
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public User userLogin(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
		Optional<User> user = getValidUsers()
								.stream()
								.filter(u -> u.getUserName().equalsIgnoreCase(loginRequest.getName()))
								.findFirst();
		
		if (user.isPresent()) {
			return user.get();
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<User> listUsers() {
		return getValidUsers();
	}
	
	private List<User> getValidUsers() {
		if (!validUsers.isEmpty()) {
			return validUsers;
		} else {
			validUsers.add(new User(1, "admin"));
			validUsers.add(new User(2, "qwerty"));
			validUsers.add(new User(3, "Marry"));
			validUsers.add(new User(4, "Pippin"));
			validUsers.add(new User(5, "Gollum"));
			validUsers.add(new User(6, "Gandalf"));
			validUsers.add(new User(7, "Aragorn"));
			validUsers.add(new User(8, "Boromir"));
			validUsers.add(new User(9, "Legolas"));
			validUsers.add(new User(10, "Gimli"));
			return validUsers;
		}
	}

}
