package com.ia.modelos;

import com.ia.interfaces.Entrenable;

// Añadimos "implements Entrenable"
public class RedNeuronal extends ModeloIA implements Entrenable {
    private int capasOcultas;

    public RedNeuronal(String nombre, double tasaAprendizaje, int capasOcultas) {
        super(nombre, tasaAprendizaje);
        this.capasOcultas = capasOcultas;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Específico] Capas Ocultas: " + this.capasOcultas);
    }

    // Método polimórfico obligatorio por la interfaz
    @Override
    public void ajustarPesos(double tasaAprendizaje) {
        // Una red neuronal sube su precisión de forma agresiva según la tasa
        double nuevoAumento = tasaAprendizaje * 150.0;
        double precisionActual = getPrecision();
        System.out.println("⚡ [RedNeuronal] Optimizando pesos con tasa " + tasaAprendizaje + ". Precisión previa: " + precisionActual + "%");
    }
}
