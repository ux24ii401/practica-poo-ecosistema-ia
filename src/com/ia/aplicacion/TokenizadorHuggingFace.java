package com.ia.aplicacion;

import com.ia.interfaces.Tokenizador;

public class TokenizadorHuggingFace implements Tokenizador {
    @Override
    public String[] dividirTexto(String parrafo) {
        // Simulamos un algoritmo avanzado (BPE) agregando guiones decorativos
        // para notar visualmente la división en subpalabras
        String textoModificado = parrafo
                .replace("inteligencia", "intel-igencia")
                .replace("procesar", "pro-cesar")
                .replace("simulador", "simul-ador");

        return textoModificado.split(" ");
    }
}
