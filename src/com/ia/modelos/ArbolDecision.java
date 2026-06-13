package com.ia.modelos;

public class ArbolDecision extends ModeloIA {
    // Atributo propio y exclusivo de esta subclase
    private int profundidadMaxima;

    // Constructor
    public ArbolDecision(String nombre, double tasaAprendizaje, int profundidadMaxima) {
        super(nombre, tasaAprendizaje);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Específico] Profundidad Máxima: " + this.profundidadMaxima);
    }
}
