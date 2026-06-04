package com.ia.aplicacion;

// Importamos la clase que está en el otro paquete para poder usarla
import com.ia.modelos.ModeloIA;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL SIMULADOR DE IA ===");
        System.out.println();

        // 1 Crear los dos objetos de IA
        ModeloIA modelo1 = new ModeloIA("RedNeuronal", 0.01);
        ModeloIA modelo2 = new ModeloIA("ArbolDecision", 0.05);

        // Mostrar cómo inician
        System.out.println("--- Estado Inicial ---");
        modelo1.mostrarMetricas();
        modelo2.mostrarMetricas();
        System.out.println();

        // 2 Intentar meter un valor inválido para demostrar que el Setter protege el objeto
        System.out.println("--- Probando Validación del Setter ---");
        modelo1.setTasaAprendizaje(-0.5); // Esto va a fallar y mandará advertencia
        modelo2.setTasaAprendizaje(1.5);  // Esto también va a fallar
        System.out.println();

        // 3 Entrenar los modelos paso a paso para ver cómo cambian sus datos de forma segura
        System.out.println("--- Iniciando Entrenamiento ---");

        System.out.println("Entrenamiento 1:");
        modelo1.entrenar();
        modelo2.entrenar();
        modelo1.mostrarMetricas();
        modelo2.mostrarMetricas();
        System.out.println();

        System.out.println("Entrenamiento 2:");
        modelo1.entrenar();
        modelo2.entrenar();
        modelo1.mostrarMetricas();
        modelo2.mostrarMetricas();
        System.out.println();

        System.out.println("Entrenamiento 3:");
        modelo1.entrenar();
        modelo2.entrenar();
        modelo1.mostrarMetricas();
        modelo2.mostrarMetricas();
        System.out.println();

        System.out.println("=== SIMULACIÓN TERMINADA ===");
    }
}
