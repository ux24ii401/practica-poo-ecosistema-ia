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
        System.out.println("   └─ [Especifico] Coeficiente Regularizacion: " + this.coeficienteRegularizacion);
    }

    // Implementacion obligatoria del metodo abstracto del padre
    @Override
    public void entrenar() {
        setEpocasEntrenadas(getEpocasEntrenadas() + 1);
        // Una regresion lineal aumenta de forma mas estandar y fija
        double nuevaPrecision = getPrecision() + 3.5;
        if (nuevaPrecision > 100.0) nuevaPrecision = 100.0;
        setPrecision(nuevaPrecision);
    }

    @Override
    public void ajustarPesos(double tasaAprendizaje) {
        System.out.println("[ModeloRegresion] Ajustando gradiente con tasa " + tasaAprendizaje + ". Precision previa: " + getPrecision() + "%");
    }
}
