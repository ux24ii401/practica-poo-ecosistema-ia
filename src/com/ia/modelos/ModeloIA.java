package com.ia.modelos;

public class ModeloIA {
    // 1 Atributos Privados (Nadie fuera de esta clase puede tocarlos directamente)
    private String nombre;
    private double precision;
    private int epocasEntrenadas;
    private double tasaAprendizaje;

    // 2 Constructor: Configura el objeto cuando nace
    public ModeloIA(String nombre, double tasaAprendizaje) {
        this.nombre = nombre;
        this.epocasEntrenadas = 0;   // Inicia en 0 como pide el ejercicio
        this.precision = 50.0;       // Inicia en valor base de 50.0%

        // Usamos el setter aquí abajo para que valide la tasa desde el principio
        setTasaAprendizaje(tasaAprendizaje);
    }

    // 3 Getters (Permiten a otras clases LEER los datos)
    public String getNombre() {
        return this.nombre;
    }

    public double getPrecision() {
        return this.precision;
    }

    public int getEpocasEntrenadas() {
        return this.epocasEntrenadas;
    }

    public double getTasaAprendizaje() {
        return this.tasaAprendizaje;
    }

    // 4 Setter con Validación (El único Setter permitido para proteger la IA)
    public void setTasaAprendizaje(double tasa) {
        // Regla: la tasa debe ser mayor a 0.0 y menor a 1.0
        if (tasa > 0.0 && tasa < 1.0) {
            this.tasaAprendizaje = tasa;
        } else {
            System.out.println("ADVERTENCIA: La tasa " + tasa + " no es válida para " + this.nombre + ". Debe estar entre 0.0 y 1.0.");
        }
    }

    // 5 Métodos de Operación Públicos
    public void entrenar() {
        // Aumenta una época
        this.epocasEntrenadas = this.epocasEntrenadas + 1;

        // Simula que la precisión sube un 5.5% en cada entrenamiento
        this.precision = this.precision + 5.5;

        // Validación: No puede pasar del 100%
        if (this.precision > 100.0) {
            this.precision = 100.0;
        }
    }

    public void mostrarMetricas() {
        System.out.println("Modelo: " + this.nombre +
                " | Épocas: " + this.epocasEntrenadas +
                " | Precisión: " + this.precision + "%" +
                " | Tasa: " + this.tasaAprendizaje);
    }
}