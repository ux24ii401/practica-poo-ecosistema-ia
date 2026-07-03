package com.ia.aplicacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ia.interfaces.Tokenizador;
import com.ia.interfaces.PromptInput;
import com.ia.modelos.ModeloIA;
import com.ia.modelos.impl.RedNeuronal;
import com.ia.modelos.impl.ArbolDecision;
import com.ia.modelos.impl.ModeloRegresion;
import com.ia.exceptions.IAComponentException;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR MODERNIZADO A JAVA 17 ===\n");

        List<ModeloIA> inventarioModelos = new ArrayList<>();
        Map<String, Tokenizador> catalogoTokenizadores = new HashMap<>();

        catalogoTokenizadores.put("BASICO", new TokenizadorBasico());
        catalogoTokenizadores.put("HUGGING_FACE", new TokenizadorHuggingFace());

        // Implementacion de un Record de Java 17 para encapsular la entrada
        PromptInput entradaPipeline = new PromptInput("Actua como un experto en IA", "el simulador procesar inteligencia");

        try {
            System.out.println("--- Cargando Modelos en la Jerarquia Controlada (Sealed) ---");
            inventarioModelos.add(new RedNeuronal("PerceptronMulticapa", 0.01, 8));
            inventarioModelos.add(new ArbolDecision("RandomForest", 0.05, 12));

            // EXPRESION SWITCH DE JAVA 17: Mas limpia, segura y retorna el valor directamente
            String tipoTokenizadorSeleccionado = "HUGGING_FACE";
            System.out.println("--- Seleccionando Tokenizador mediante Switch Expression ---");

            Tokenizador tokenizadorElegido = switch (tipoTokenizadorSeleccionado) {
                case "BASICO" -> catalogoTokenizadores.get("BASICO");
                case "HUGGING_FACE" -> catalogoTokenizadores.get("HUGGING_FACE");
                default -> throw new IAComponentException("Error: Seleccion invalida de tokenizador.");
            };

            if (tokenizadorElegido == null) {
                throw new IAComponentException("Error: El componente de procesamiento no se encuentra registrado.");
            }

            System.out.println("Procesando consulta del Record:");
            String[] tokens = tokenizadorElegido.dividirTexto(entradaPipeline.userQuery());
            for (String t : tokens) {
                System.out.println(" -> Token: [" + t + "]");
            }

        } catch (IAComponentException e) {
            System.out.println("\n[REPORTE DE FALLO CONTROLADO]");
            System.out.println("Detalle del error: " + e.getMessage() + "\n");
        } finally {
            System.out.println("--- Bloque Finally: Auditoria del sistema concluida con exito. ---");
        }

        System.out.println("\n=== SIMULACION COMPLETA TERMINADA ===");
    }
}