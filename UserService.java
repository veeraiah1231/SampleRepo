package ola.com.booking.service;

import ola.com.booking.model.User;

public interface UserService {

	public void saveUser(User user);
	public int validateUser(String username, String password);
}
