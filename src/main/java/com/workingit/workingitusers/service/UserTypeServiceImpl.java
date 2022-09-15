package com.workingit.workingitusers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workingit.workingitusers.entity.UserType;
import com.workingit.workingitusers.repository.IUserTypeRepository;

@Service
public class UserTypeServiceImpl implements IUserTypeService{

	@Autowired
	private IUserTypeRepository userTypeRespository;
	
	@Override
	public UserType save(UserType userType) {
		return userTypeRespository.save(userType);
	}

	@Override
	public void delete(UserType userType) {
		userTypeRespository.delete(userType);
	}

	@Override
	public List<UserType> getAll() {
		return userTypeRespository.findAll();
	}

	@Override
	public UserType findById(int id) {
		return userTypeRespository.findById(id).orElse(null);
	}

}
