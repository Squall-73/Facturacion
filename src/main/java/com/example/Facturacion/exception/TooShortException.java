package com.example.Facturacion.exception;

public class TooShortException extends Exception{

	//Excepción para el caso de que la longitud del texto ingresada sea muy corta
	public TooShortException(String msg){
		super(msg);
	}
}
