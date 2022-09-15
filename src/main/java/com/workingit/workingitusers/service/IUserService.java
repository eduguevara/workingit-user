package com.workingit.workingitusers.service;

import java.util.List;

import com.workingit.workingitusers.entity.User;

public interface IUserService {
	
	public User saveUSer (User user);
	public User findById (int id);
	public List<User> findAll ();
	public void delete (User user);

}
