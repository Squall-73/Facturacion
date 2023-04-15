package com.example.Facturacion.exception;

public class MinException extends Exception{

	//Excepción para el caso de que el valor ingresado sea menor al mínimo para dicha clase
	public MinException(String msg){
		super(msg);
	}
}
