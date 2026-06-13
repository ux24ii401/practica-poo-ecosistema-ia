package com.ia.modelos;

public class ModeloRegresion extends ModeloIA {
    // Atributo propio y exclusivo de esta subclase
    private double coeficienteRegularizacion;

    // Constructor
    public ModeloRegresion(String nombre, double tasaAprendizaje, double coeficienteRegularizacion) {
        super(nombre, tasaAprendizaje);
        this.coeficienteRegularizacion = coeficienteRegularizacion;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Específico] Coeficiente Regularización: " + this.coeficienteRegularizacion);
    }
}
