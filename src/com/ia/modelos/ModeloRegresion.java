package com.ia.modelos;

import com.ia.interfaces.Entrenable;

public class ModeloRegresion extends ModeloIA implements Entrenable {
    private double coeficienteRegularizacion;

    public ModeloRegresion(String nombre, double tasaAprendizaje, double coeficienteRegularizacion) {
        super(nombre, tasaAprendizaje);
        this.coeficienteRegularizacion = coeficienteRegularizacion;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Específico] Coeficiente Regularización: " + this.coeficienteRegularizacion);
    }

    @Override
    public void ajustarPesos(double tasaAprendizaje) {
        // Una regresión calcula su gradiente
        double precisionActual = getPrecision();
        System.out.println("📈 [ModeloRegresion] Ajustando gradiente con tasa " + tasaAprendizaje + ". Precisión previa: " + precisionActual + "%");
    }
}
