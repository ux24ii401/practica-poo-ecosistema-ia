package com.ia.aplicacion;

import com.ia.interfaces.Entrenable;
import com.ia.interfaces.Tokenizador;
import com.ia.modelos.RedNeuronal;
import com.ia.modelos.ArbolDecision;
import com.ia.modelos.ModeloRegresion;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== PIPELINE DE SIMULACION POLIMORFICA ===\n");

        // 1. Coleccion Generica de tipo Entrenable
        Entrenable[] listaModelos = new Entrenable[3];
        listaModelos[0] = new RedNeuronal("PerceptronMulticapa", 0.01, 5);
        listaModelos[1] = new ArbolDecision("RandomForest", 0.05, 15);
        listaModelos[2] = new ModeloRegresion("RegresionLogistica", 0.1, 0.001);

        // 2. Lazo Polimorfico
        System.out.println("--- Ejecutando Optimizacion Polimorfica ---");
        for (Entrenable modelo : listaModelos) {
            modelo.ajustarPesos(0.02);
        }
        System.out.println();

        // 3. Intercambio en Tiempo de Ejecucion (Inyeccion Polimorfica)
        System.out.println("--- Probando Tuberia de Procesamiento de Texto (Tokenizadores) ---");
        String textoPrueba = "el simulador procesar inteligencia";

        // Usamos el basico primero
        Tokenizador miTokenizador = new TokenizadorBasico();
        System.out.println("Salida de TokenizadorBasico:");
        String[] tokensBasicos = miTokenizador.dividirTexto(textoPrueba);
        for (String t : tokensBasicos) {
            System.out.println(" -> Token: [" + t + "]");
        }
        System.out.println();

        // Intercambiamos dinamicamente la referencia por el avanzado
        miTokenizador = new TokenizadorHuggingFace();
        System.out.println("Salida de TokenizadorHuggingFace (Subpalabras):");
        String[] tokensAvanzados = miTokenizador.dividirTexto(textoPrueba);
        for (String t : tokensAvanzados) {
            System.out.println(" -> Token: [" + t + "]");
        }

        System.out.println("\n=== PIPELINE FINALIZADO CON EXITO ===");
    }
}