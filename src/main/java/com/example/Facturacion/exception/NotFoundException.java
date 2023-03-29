package com.example.Facturacion.exception;

public class NotFoundException extends Exception{

	//Excepción para el caso de que no se encuentre el objeto buscado
	public NotFoundException(String msg){
		super(msg);
	}
}
