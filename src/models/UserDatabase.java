package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.UserDoesNotExistException;
import exceptions.UserExistsException;

public class UserDatabase {

	private static List<User> users = new ArrayList<User>();
	
	public static synchronized boolean addUser(String name, Position pos) throws UserExistsException {
		User u = new User(name, pos);
		if (users.contains(u)) {
			throw new UserExistsException();
		}
		return users.add(u);
	}
	
	public static synchronized User getUser(String name) throws UserDoesNotExistException {
		User search = new User(name, null);
		for (User u : users) {
			if (u.equals(search)) {
				return u;
			}
		}
		throw new UserDoesNotExistException();
	}
	
	public static synchronized boolean removeUser(String name) {
		return users.remove(new User(name, null));
	}
	
}
