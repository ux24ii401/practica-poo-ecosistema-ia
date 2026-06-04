## Fase 2: Módulo de Encapsulación Core

### Aplicación de la Encapsulación
En la clase `ModeloIA` se aplicó el pilar de encapsulación mediante los siguientes mecanismos:
1. **Atributos Privados:** `nombre`, `precision`, `epocasEntrenadas` y `tasaAprendizaje` se declararon como `private`, impidiendo que el `SimuladorIA` u otras clases externas alteren sus valores de forma directa.
2. **Métodos de Solo Lectura:** Se omitieron los métodos *setter* para `precision` y `epocasEntrenadas`. El estado de estas variables solo cambia internamente a través del método controlado `entrenar()`.
3. **Validación en Setters:** El método `setTasaAprendizaje()` actúa como un filtro protector, validando mediante un condicional que el nuevo valor se encuentre estrictamente en el rango `(0.0, 1.0)` antes de asignarlo.

### Resultado de la Ejecución en Consola
```text
--- Probando Validación del Setter ---
ADVERTENCIA: La tasa -0.5 no es válida para RedNeuronal. Debe estar entre 0.0 y 1.0.
ADVERTENCIA: La tasa 1.5 no es válida para ArbolDecision. Debe estar entre 0.0 y 1.0.
