package com.example.Facturacion.exception;

public class NullException extends Exception{

	//Excepción para el caso de que no se ingresen valores para un campo no nulo
	public NullException(String msg){
		super(msg);
	}
}
