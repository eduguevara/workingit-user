package com.workingit.workingitusers.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workingit.workingitusers.entity.UserType;
import com.workingit.workingitusers.service.IUserTypeService;

@RestController
@RequestMapping(value = "/api")
public class UserTypeController {

	@Autowired
	public IUserTypeService IUserType;
	

	@PostMapping(value = "/usertype")
	public ResponseEntity<?> create(@Valid @RequestBody UserType userType, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		IUserType.save(userType);
		return new ResponseEntity<>(userType, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/usertype")
	public ResponseEntity<?> delete (@Valid @RequestBody UserType userType, BindingResult result){
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		IUserType.delete(userType);
		return new ResponseEntity<>(userType, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usertype/{id}")
	public UserType findById (@PathVariable int id) {
		return IUserType.findById(id);
		
	}
}
