package com.lms.service;

import java.util.Map;
import java.util.Optional;

import com.lms.model.User;

public interface UserService {
	public Map<String, Object> saveUser(User user);
	public Optional<User> getUser(int id);
}
