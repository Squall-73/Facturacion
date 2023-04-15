package com.example.Facturacion.exception;

public class WrongCodeException extends Exception{

	//Excepción para el caso de que el código inesado no sea válido
	public WrongCodeException(String msg){
		super(msg);
	}
}
