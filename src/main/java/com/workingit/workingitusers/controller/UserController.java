package com.workingit.workingitusers.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.workingit.workingitusers.entity.User;
import com.workingit.workingitusers.entity.UserType;
import com.workingit.workingitusers.service.IUserService;
import com.workingit.workingitusers.service.IUserTypeService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IUserTypeService iUserTypeService;

	@GetMapping(value = "/getAll")
	@ResponseBody
	public ResponseEntity<?> getAll() {
		List<User> users = userService.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<>("No hay usuarios", HttpStatus.OK);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
		String fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss").format(LocalDateTime.now());
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		List<UserType> userType = new ArrayList<>(1);
		int idUser = user.getUserTypes().get(0).getId();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		
		UserType userT = iUserTypeService.findById(idUser);
		userType.add(userT);
		user.setUserTypes(userType);
		try {
			user.setRegistration(formato.parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setDateBirth(user.getDateBirth());
		userService.saveUSer(user);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	public Map<String, UserType> isUserTypeId (int id) {
		String message = "";
		UserType userType = null;
		Map <String, UserType> result = new HashMap<String, UserType>(1);
		if (0 != id) {
			userType = iUserTypeService.findById(id);
			if (userType != null) {
				message = "Existe el user type con id: '" + id + "'";
//				result.put(message, userType);
			} else {
				userType = null;
				message = "El user type con id: '" + id + "' no existe";
//				result.put(message, userType);
			}
		} else {
			message = "El User Type ID no puede ser cero";
//			result.put(message, userType);
		}
		return result;		
	}

	@GetMapping(value = "/user/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);

	}

	@GetMapping("/test")
	public String Test() {
		return "PruebaTest";
	}

	@PostMapping("/test")
	public ResponseEntity<?> postTest(@RequestBody String prueba) {
		return new ResponseEntity<>("PruebaTest 2" + prueba, HttpStatus.OK);
	}

	@PutMapping(value = "/user")
	public ResponseEntity<?> delete(@Valid @RequestBody User user) {
		userService.delete(user);
		return null;
	}

}
