package com.ia.modelos;

// Añadimos "abstract" para que ya no se pueda instanciar directamente
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

    // Getters y Setters se quedan exactamente igual
    public String getNombre() { return this.nombre; }
    public double getPrecision() { return this.precision; }
    public void setPrecision(double precision) { this.precision = precision; }
    public int getEpocasEntrenadas() { return this.epocasEntrenadas; }
    public void setEpocasEntrenadas(int epocas) { this.epocasEntrenadas = epocas; }
    public double getTasaAprendizaje() { return this.tasaAprendizaje; }

    public void setTasaAprendizaje(double tasa) {
        if (tasa > 0.0 && tasa < 1.0) {
            this.tasaAprendizaje = tasa;
        } else {
            System.out.println("ADVERTENCIA: La tasa " + tasa + " no es valida para " + this.nombre + ". Se mantiene el valor anterior.");
        }
    }

    // EL CAMBIO CLAVE: El metodo ahora es abstracto y termina en punto y coma
    // Cada hijo estara obligado a darle su propio comportamiento
    public abstract void entrenar();

    public void mostrarMetricas() {
        System.out.println("Modelo: " + this.nombre +
                " | Epocas: " + this.epocasEntrenadas +
                " | Precision: " + this.precision + "%" +
                " | Tasa: " + this.tasaAprendizaje);
    }
}