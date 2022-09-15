package com.workingit.workingitusers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Es obligatorio indicar una descripción")
	@Column(name = "description")
	private String description;
	
//	@ManyToMany(mappedBy = "userTypes", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
//	private List<User> user = new ArrayList<User>();

}
