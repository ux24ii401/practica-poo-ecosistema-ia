package com.ia.modelos;

// Importamos la excepcion personalizada
import com.ia.exceptions.IAComponentException;

public abstract class ModeloIA {
    private String nombre;
    private double precision;
    private int epocasEntrenadas;
    private double tasaAprendizaje;

    public ModeloIA(String nombre, double tasaAprendizaje) {
        this.nombre = nombre;
        this.epocasEntrenadas = 0;
        this.precision = 50.0;
        setTasaAprendizaje(tasaAprendizaje);
    }

    public String getNombre() { return this.nombre; }
    public double getPrecision() { return this.precision; }
    public void setPrecision(double precision) { this.precision = precision; }
    public int getEpocasEntrenadas() { return this.epocasEntrenadas; }
    public void setEpocasEntrenadas(int epocas) { this.epocasEntrenadas = epocas; }
    public double getTasaAprendizaje() { return this.tasaAprendizaje; }

    // REFACTORIZACION CON THROW:
    public void setTasaAprendizaje(double tasa) {
        if (tasa > 0.0 && tasa < 1.0) {
            this.tasaAprendizaje = tasa;
        } else {
            // Lanzamos explicitamente el error en lugar de imprimir texto suelto
            throw new IAComponentException("Error: La tasa de aprendizaje " + tasa + " esta fuera del rango permitido (0.0 - 1.0).");
        }
    }

    public abstract void entrenar();

    public void mostrarMetricas() {
        System.out.println("Modelo: " + this.nombre +
                " | Epocas: " + this.epocasEntrenadas +
                " | Precision: " + this.precision + "%" +
                " | Tasa: " + this.tasaAprendizaje);
    }
}