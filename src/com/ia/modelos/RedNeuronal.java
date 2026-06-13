package com.ia.modelos;

// Ponemos "extends ModeloIA" para indicar que RedNeuronal hereda de ModeloIA
public class RedNeuronal extends ModeloIA {
    // Atributo propio y exclusivo de esta subclase
    private int capasOcultas;

    // Constructor
    public RedNeuronal(String nombre, double tasaAprendizaje, int capasOcultas) {
        // "super" pasa el nombre y la tasa al constructor del padre (ModeloIA)
        super(nombre, tasaAprendizaje);
        this.capasOcultas = capasOcultas;
    }

    // Sobreescribimos el método para agregarle el dato propio
    @Override
    public void mostrarMetricas() {
        // Llama al método del padre para imprimir los datos comunes
        super.mostrarMetricas();
        // Imprime el dato específico de la Red Neuronal
        System.out.println("   └─ [Específico] Capas Ocultas: " + this.capasOcultas);
    }
}
