package com.ia.modelos;

import com.ia.interfaces.Entrenable;
public sealed abstract class ModeloIA permits RedNeuronal, ArbolDecision, ModeloRegresion {

    public class ArbolDecision extends ModeloIA implements Entrenable {
        private int profundidadMaxima;

        public ArbolDecision(String nombre, double tasaAprendizaje, int profundidadMaxima) {
            super(nombre, tasaAprendizaje);
            this.profundidadMaxima = profundidadMaxima;
        }

        @Override
        public void mostrarMetricas() {
            super.mostrarMetricas();
            System.out.println("   └─ [Especifico] Profundidad Maxima: " + this.profundidadMaxima);
        }

        // Implementacion obligatoria del metodo abstracto del padre
        @Override
        public void entrenar() {
            setEpocasEntrenadas(getEpocasEntrenadas() + 1);
            // Los arboles suben su precision dependiendo de su profundidad maxima
            double aumento = 2.0 + (this.profundidadMaxima * 0.2);
            double nuevaPrecision = getPrecision() + aumento;
            if (nuevaPrecision > 100.0) nuevaPrecision = 100.0;
            setPrecision(nuevaPrecision);
        }

        @Override
        public void ajustarPesos(double tasaAprendizaje) {
            System.out.println("[ArbolDecision] Podando ramas con tasa " + tasaAprendizaje + ". Precision previa: " + getPrecision() + "%");
        }
    }
}