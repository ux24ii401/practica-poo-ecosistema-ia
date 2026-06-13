package com.ia.aplicacion;

// Importamos los modelos específicos
import com.ia.modelos.RedNeuronal;
import com.ia.modelos.ArbolDecision;
import com.ia.modelos.ModeloRegresion;

public class SimuladorIA {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SIMULADOR CON HERENCIA ===");
        System.out.println();

        // 1. Instanciar un objeto concreto de cada subclase con sus propios parámetros
        RedNeuronal nn = new RedNeuronal("PerceptronMulticapa", 0.01, 5);
        ArbolDecision dt = new ArbolDecision("RandomForest", 0.05, 15);
        ModeloRegresion lr = new ModeloRegresion("RegresionLogistica", 0.1, 0.001);

        System.out.println("--- Estado Inicial de los Modelos Especializados ---");
        nn.mostrarMetricas();
        dt.mostrarMetricas();
        lr.mostrarMetricas();
        System.out.println();

        // 2. Ejecutar el método entrenar() heredado del padre en cada uno
        System.out.println("--- Entrenando Modelos (Uso de métodos heredados) ---");
        nn.entrenar();
        dt.entrenar();
        lr.entrenar();

        // 3. Mostrar métricas para comprobar que imprime lo común + lo específico
        nn.mostrarMetricas();
        dt.mostrarMetricas();
        lr.mostrarMetricas();

        System.out.println();
        System.out.println("=== SIMULACIÓN FASE 3 COMPLETADA ===");
    }
}
