package com.ia.aplicacion;

import com.ia.interfaces.Tokenizador;

// Implementa la interfaz Tokenizador
public class TokenizadorBasico implements Tokenizador {
    @Override
    public String[] dividirTexto(String parrafo) {
        // Divide el texto simplemente separándolo por espacios en blanco
        return parrafo.split(" ");
    }
}