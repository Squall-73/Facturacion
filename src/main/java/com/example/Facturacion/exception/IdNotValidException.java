package com.example.Facturacion.exception;

public class IdNotValidException extends Exception{

	//Excepción para el caso de que el ID brindado no sea válido
	public IdNotValidException(String msg){
		super(msg);
	}
}
