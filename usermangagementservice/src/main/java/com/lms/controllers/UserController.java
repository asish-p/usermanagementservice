package com.lms.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.User;
import com.lms.service.UserService;

@RestController("/api/v1.0/lms/company")
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> saveUser(@RequestBody User user) {
		LOGGER.info("UserController :: saveUser Starts");
		LOGGER.info("User: " + user.getName());
		Map<String, Object> returnMap = new HashMap<>();
		userService.saveUser(user);
		LOGGER.info("UserController :: saveUser Ends");
		return returnMap;
	}

	@GetMapping("/getUser/{id}")
	@ResponseBody
	public Optional<User> getUser(@PathVariable int id) {
		LOGGER.info("UserController :: saveUser");
		return userService.getUser(id);
	}
}
