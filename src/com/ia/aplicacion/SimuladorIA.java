package com.ia.aplicacion;

import com.ia.interfaces.Tokenizador;
import com.ia.modelos.ModeloIA;
import com.ia.modelos.RedNeuronal;
import com.ia.modelos.ArbolDecision;
import com.ia.modelos.ModeloRegresion;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR CON CLASES ABSTRACTAS ===\n");

        // VALIDACION DE LA ABSTRACCION:
        // Si quitas las dos barras de la linea de abajo, veras que da un error rojo
        // porque Java prohibe crear instancias directas de una clase abstracta:
        // ModeloIA modeloPrueba = new ModeloIA("Generico", 0.1);

        // 1. Uso de Referencias Abstractas (Arreglo del padre abstracto)
        ModeloIA[] listaModelos = new ModeloIA[3];
        listaModelos[0] = new RedNeuronal("PerceptronMulticapa", 0.01, 6);
        listaModelos[1] = new ArbolDecision("RandomForest", 0.05, 10);
        listaModelos[2] = new ModeloRegresion("RegresionLogistica", 0.1, 0.002);

        // 2. Ejecutar entrenamiento dirigido por la clase abstracta
        System.out.println("--- Ejecutando Entrenamiento Desde Estructura Abstracta ---");
        for (ModeloIA modelo : listaModelos) {
            modelo.entrenar(); // Llama al metodo abstracto resuelto por cada hijo
            modelo.mostrarMetricas();
            System.out.println();
        }

        // 3. Procesamiento de texto usando la interfaz abstracta Tokenizador
        System.out.println("--- Pipeline de Tokenizacion ---");
        String texto = "el simulador procesar inteligencia";

        Tokenizador miTokenizador = new TokenizadorBasico();
        System.out.println("Salida de TokenizadorBasico:");
        String[] tokensB = miTokenizador.dividirTexto(texto);
        for (String t : tokensB) {
            System.out.println(" -> Token: [" + t + "]");
        }
        System.out.println();

        miTokenizador = new TokenizadorHuggingFace();
        System.out.println("Salida de TokenizadorHuggingFace:");
        String[] tokensH = miTokenizador.dividirTexto(texto);
        for (String t : tokensH) {
            System.out.println(" -> Token: [" + t + "]");
        }

        System.out.println("\n=== FIN DE LA SIMULACION ===");
    }
}