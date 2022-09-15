package com.workingit.workingitusers.service;

import java.util.List;

import com.workingit.workingitusers.entity.UserType;

public interface IUserTypeService {

	public UserType save (UserType userType);
	public void delete (UserType userType);
	public List<UserType> getAll ();
	public UserType findById (int id);
}
