package com.ia.interfaces;

public interface Entrenable {
    // Método que todos los modelos que se puedan entrenar deben tener
    void ajustarPesos(double tasaAprendizaje);
}