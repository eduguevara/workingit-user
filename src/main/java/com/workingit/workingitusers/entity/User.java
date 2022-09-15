package com.workingit.workingitusers.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//Para los Getters and Setters
@Data
//Con esta etiqueta generamos lo constructores con Args y sin Args
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name is obligatory")
	@Size(min = 4, max = 12, message = "tamano debe de estar entre 4-12")
	private String name;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "date_birth")
	private Date dateBirth;
	private Date registration;
	
	 @ManyToMany
	 @JoinTable(name = "users_user_type", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_type_id"))
	 List<UserType> userTypes = new ArrayList<UserType>();
	
	 public void addUserType(UserType userType){
	        if(this.userTypes == null){
	            this.userTypes = new ArrayList<UserType>();
	        }
	        
	        this.userTypes.add(userType);
	    }

}
