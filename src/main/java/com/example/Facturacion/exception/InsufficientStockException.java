package com.example.Facturacion.exception;

public class InsufficientStockException extends Exception{


	//Excepción para el caso de que el stock del producto solicitado sea insuficiente
	public InsufficientStockException(String msg){
		super(msg);
	}
}
