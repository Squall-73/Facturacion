package com.example.Facturacion.exception;

public class AlreadyExistsException extends Exception{

	//Excepción para el caso de que el objeto ya exista en la base de datos
	public AlreadyExistsException(String msg){
		super(msg);
	}
}
