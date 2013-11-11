package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.GroupDoesNotExistException;
import exceptions.GroupExistsException;

public class GroupDatabase {
	
	private static List<Group> groups = new ArrayList<Group>();
	
	public static synchronized Group getGroup(String name) throws GroupDoesNotExistException {
		Group search = new Group(name);
		for (Group g : groups) {
			if (g.equals(search)) {
				return g;
			}
		}
		throw new GroupDoesNotExistException();
	}
	
	public static synchronized boolean addGroup(String name) throws GroupExistsException {
		Group g = new Group(name);
		if (groups.contains(g)) {
			throw new GroupExistsException();
		}
		return groups.add(g);
	}
	
	public static synchronized boolean removeGroup(String name) {
		return groups.remove(new Group(name));
	}

}
