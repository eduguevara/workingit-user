package com.workingit.workingitusers.enums;

public enum EnumDocument {

	NIF("NIF"),
	PASSPORT("PASSPORT"),
	NIE("NIE");

	private String document;
	
	private EnumDocument(String valor) {
		this.document = valor;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	
}
