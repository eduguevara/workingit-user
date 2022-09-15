package com.workingit.workingitusers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workingit.workingitusers.entity.User;
import com.workingit.workingitusers.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User saveUSer(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}


	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
