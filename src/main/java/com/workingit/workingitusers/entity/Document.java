package com.workingit.workingitusers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.workingit.workingitusers.enums.EnumDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "identity_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@Column(name = "description")
	private EnumDocument type;
	@Column(name = "number")
	private String number;

}
