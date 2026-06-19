package com.ia.aplicacion;

// Importamos el framework de colecciones de Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Importamos las interfaces y modelos de tus otros paquetes
import com.ia.interfaces.Tokenizador;
import com.ia.modelos.ModeloIA;
import com.ia.modelos.RedNeuronal;
import com.ia.modelos.ArbolDecision;
import com.ia.modelos.ModeloRegresion;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR CON JAVA COLLECTIONS FRAMEWORK ===\n");

        // 1. Administracion Dinamica de Modelos (List)
        List<ModeloIA> inventarioModelos = new ArrayList<>();

        // Agregamos los modelos dinamicamente sin preocuparnos por un tamaño fijo
        inventarioModelos.add(new RedNeuronal("PerceptronMulticapa", 0.01, 8));
        inventarioModelos.add(new ArbolDecision("RandomForest", 0.05, 12));
        inventarioModelos.add(new ModeloRegresion("RegresionLogistica", 0.1, 0.005));

        // Recorremos la lista para entrenar y mostrar metricas
        System.out.println("--- Entrenando Modelos en la Lista Dinamica ---");
        for (ModeloIA modelo : inventarioModelos) {
            modelo.entrenar();
            modelo.mostrarMetricas();
            System.out.println();
        }

        // 2. Catalogo Indexado de Procesadores (Map)
        Map<String, Tokenizador> catalogoTokenizadores = new HashMap<>();

        // Registramos los componentes con una clave unica
        catalogoTokenizadores.put("BASICO", new TokenizadorBasico());
        catalogoTokenizadores.put("HUGGING_FACE", new TokenizadorHuggingFace());

        System.out.println("--- Recuperacion de Tokenizador desde Catalogo Indexado ---");
        String textoPrueba = "el simulador procesar inteligencia";

        // Recuperamos directamente del mapa usando la clave, sin usar condicionales if/else
        Tokenizador tokenizadorElegido = catalogoTokenizadores.get("HUGGING_FACE");

        if (tokenizadorElegido != null) {
            System.out.println("Salida del procesador recuperado [HUGGING_FACE]:");
            String[] tokens = tokenizadorElegido.dividirTexto(textoPrueba);
            for (String t : tokens) {
                System.out.println(" -> Token: [" + t + "]");
            }
        }
        System.out.println();

        // 3. Operaciones Avanzadas (Regla de negocio: Filtrado por umbral de precision)
        double umbralPrecision = 55.0;
        System.out.println("--- Filtrado Avanzado: Modelos con Precision > " + umbralPrecision + "% ---");

        for (ModeloIA modelo : inventarioModelos) {
            if (modelo.getPrecision() > umbralPrecision) {
                System.out.println(" -> " + modelo.getNombre() + " supero el umbral. Precision: " + modelo.getPrecision() + "%");
            }
        }

        System.out.println("\n=== SIMULACION COMPLETA TERMINADA ===");
    }
}