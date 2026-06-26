package com.ia.exceptions;

// Hereda de RuntimeException para manejar errores de logica de negocio
public class IAComponentException extends RuntimeException {
    public IAComponentException(String mensaje) {
        super(mensaje);
    }
}