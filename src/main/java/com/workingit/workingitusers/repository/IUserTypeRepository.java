package com.workingit.workingitusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workingit.workingitusers.entity.UserType;

public interface IUserTypeRepository extends JpaRepository<UserType, Integer>{

}
