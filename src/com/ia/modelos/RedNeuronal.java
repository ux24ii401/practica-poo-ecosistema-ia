package com.ia.modelos;

import com.ia.interfaces.Entrenable;

public class RedNeuronal extends ModeloIA implements Entrenable {
    private int capasOcultas;

    public RedNeuronal(String nombre, double tasaAprendizaje, int capasOcultas) {
        super(nombre, tasaAprendizaje);
        this.capasOcultas = capasOcultas;
    }

    @Override
    public void mostrarMetricas() {
        super.mostrarMetricas();
        System.out.println("   └─ [Especifico] Capas Ocultas: " + this.capasOcultas);
    }

    // Implementacion obligatoria del metodo abstracto del padre
    @Override
    public void entrenar() {
        setEpocasEntrenadas(getEpocasEntrenadas() + 1);
        // Las redes neuronales entrenan rapido si tienen muchas capas ocultas
        double aumento = 4.0 + (this.capasOcultas * 0.5);
        double nuevaPrecision = getPrecision() + aumento;
        if (nuevaPrecision > 100.0) nuevaPrecision = 100.0;
        setPrecision(nuevaPrecision);
    }

    @Override
    public void ajustarPesos(double tasaAprendizaje) {
        System.out.println("[RedNeuronal] Optimizando pesos con tasa " + tasaAprendizaje + ". Precision previa: " + getPrecision() + "%");
    }
}