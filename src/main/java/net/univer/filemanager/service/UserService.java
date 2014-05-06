package net.univer.filemanager.service;

import java.util.List;

import net.univer.filemanager.domain.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();
	
	public User getUser(String username);
	
	public User getUser(Integer userid);
}
