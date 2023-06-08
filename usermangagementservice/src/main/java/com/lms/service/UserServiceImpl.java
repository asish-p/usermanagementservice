package com.lms.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.lms.model.User;
import com.lms.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private static final String MESSAGE_KEY = "message";
	private static final String USER_NAME_EMPTY = "Please enter a valid user name.";
	private static final String INVALID_EMAIL_MESSAGE = "Please enter a valid Email.";
	private static final String INVALID_PASSWORD_MESSAGE = "Please choose an alphanumeric password having 8 characters.";
	private static final String USER_CREATION_MESSAGE = "Your account created sucessfully.";

	@Override
	public Map<String, Object> saveUser(User user) {
		user.setId(1);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (StringUtils.isEmpty(user.getName())) {
			returnMap.put(MESSAGE_KEY, USER_NAME_EMPTY);
			return returnMap;
		}
		if (!isValidEmail(user.getEmailId())) {
			returnMap.put(MESSAGE_KEY, INVALID_EMAIL_MESSAGE);
			return returnMap;
		}
		if (!isValidPassword(user.getPassword())) {
			returnMap.put(MESSAGE_KEY, INVALID_PASSWORD_MESSAGE);
			return returnMap;
		}
		userRepository.save(user);
		returnMap.put(MESSAGE_KEY, USER_CREATION_MESSAGE);
		return returnMap;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidPassword(String password) {

		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);

		return m.matches();
	}

	@Override
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
}
