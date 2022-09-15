package com.workingit.workingitusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workingit.workingitusers.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
