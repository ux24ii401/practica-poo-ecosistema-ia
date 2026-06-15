package com.ia.modelos;

import com.ia.interfaces.Entrenable;

public class ArbolDecision extends ModeloIA implements Entrenable {
    private int profundidadMaxima;

    public ArbolDecision(String nombre, double tasaAprendizaje, int profundidadMaxima) {
        super(nombre, tasaAprendizaje);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Específico] Profundidad Máxima: " + this.profundidadMaxima);
    }

    @Override
    public void ajustarPesos(double tasaAprendizaje) {
        // Un árbol ajusta de forma más conservadora
        double precisionActual = getPrecision();
        System.out.println("🌳 [ArbolDecision] Podando ramas con tasa " + tasaAprendizaje + ". Precisión previa: " + precisionActual + "%");
    }
}
