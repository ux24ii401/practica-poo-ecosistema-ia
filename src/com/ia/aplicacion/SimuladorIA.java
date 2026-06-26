package com.ia.aplicacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ia.interfaces.Tokenizador;
import com.ia.modelos.ModeloIA;
import com.ia.modelos.RedNeuronal;
import com.ia.modelos.ArbolDecision;
import com.ia.modelos.ModeloRegresion;
// Importamos la excepcion personalizada
import com.ia.exceptions.IAComponentException;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR CON MANEJO DE EXCEPCIONES ===\n");

        // Inicializacion de colecciones basicas
        List<ModeloIA> inventarioModelos = new ArrayList<>();
        Map<String, Tokenizador> catalogoTokenizadores = new HashMap<>();

        catalogoTokenizadores.put("BASICO", new TokenizadorBasico());
        catalogoTokenizadores.put("HUGGING_FACE", new TokenizadorHuggingFace());

        // BLOQUE TRY: Aqui corre el flujo principal propenso a fallas
        try {
            System.out.println("--- Cargando Componentes Validos ---");
            inventarioModelos.add(new RedNeuronal("PerceptronMulticapa", 0.01, 8));
            inventarioModelos.add(new ArbolDecision("RandomForest", 0.05, 12));

            // PRUEBA DE ROBUSTEZ 1: Intentar buscar una clave inexistente en el catalogo
            System.out.println("--- Buscando Procesador en Catalogo ---");
            String claveBuscada = "OPEN_AI";
            Tokenizador tokenizadorElegido = catalogoTokenizadores.get(claveBuscada);

            // Si el mapa devuelve null, disparamos nuestra excepcion personalizada
            if (tokenizadorElegido == null) {
                throw new IAComponentException("Error: El componente de procesamiento solicitado [" + claveBuscada + "] no esta registrado.");
            }

            // Nota: El codigo de aqui abajo no se ejecutara si la linea de arriba lanza la excepcion
            System.out.println("Procesando texto con componente seleccionado...");

        } catch (IAComponentException e) {
            // CATCH: Captura el error de forma precisa y muestra un reporte elegante sin detener el programa
            System.out.println("\n[REPORTE DE FALLO CONTROLADO]");
            System.out.println("Detalle del error: " + e.getMessage());
            System.out.println("Accion: Saltando proceso afectado y continuando ejecucion de forma segura.\n");

        } finally {
            // FINALLY: Se ejecuta SI O SI, haya ocurrido un error o no
            System.out.println("--- Bloque Finally: Fase de auditoria y limpieza concluida con exito. ---");
        }

        // Demostracion de resiliencia: El programa continua vivo fuera del bloque try-catch
        System.out.println("\n--- Continuacion del Flujo del Sistema (Resiliencia) ---");
        System.out.println("El programa principal no se cerro de golpe y sigue operativo.");
        for (ModeloIA modelo : inventarioModelos) {
            modelo.entrenar();
            modelo.mostrarMetricas();
        }

        System.out.println("\n=== SIMULACION COMPLETADA TERMINADA ===");
    }
}