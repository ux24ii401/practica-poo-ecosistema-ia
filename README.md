Fase 2: Módulo de Encapsulación Core
Aplicación de la Encapsulación
En la clase ModeloIA se aplicó el pilar de encapsulación mediante los siguientes mecanismos:

Atributos Privados: nombre, precision, epocasEntrenadas y tasaAprendizaje se declararon como private, impidiendo que el SimuladorIA u otras clases externas alteren sus valores de forma directa.

Métodos de Solo Lectura: Se omitieron los métodos setter para precision y epocasEntrenadas. El estado de estas variables solo cambia internamente a través del método controlado entrenar().

Validación en Setters: El método setTasaAprendizaje() actúa como un filtro protector, validando mediante un condicional que el nuevo valor se encuentre estrictamente en el rango (0.0, 1.0) antes de asignarlo.

Resultado de la Ejecución en Consola (Fase 2)
=== INICIO DEL SIMULADOR DE IA ===

--- Estado Inicial ---
 Modelo: RedNeuronal | Épocas: 0 | Precisión: 50.0% | Tasa: 0.01
Modelo: ArbolDecision | Épocas: 0 | Precisión: 50.0% | Tasa: 0.05

--- Probando Validación del Setter ---
ADVERTENCIA: La tasa -0.5 no es válida para RedNeuronal. Debe estar entre 0.0 y 1.0.
ADVERTENCIA: La tasa 1.5 no es válida para ArbolDecision. Debe estar entre 0.0 y 1.0.

Fase 3: Módulo de Herencia y Especialización
Aplicación de la Herencia
En esta fase se implementó la reutilización de código mediante el pilar de la Herencia:

Clases Especializadas: Se crearon las subclases RedNeuronal, ArbolDecision y ModeloRegresion que extienden (extends) de la clase base ModeloIA. Gracias a esto, heredaron automáticamente los atributos privados y métodos como entrenar().

Uso de super en Constructores: Se utilizó la instrucción super(nombre, tasaAprendizaje) en los constructores de los hijos para delegar la inicialización de las propiedades básicas a la superclase.

Uso de super en Métodos: Se sobreescribió el método mostrarMetricas(), utilizando super.mostrarMetricas() para imprimir primero los datos generales del modelo y luego añadir un System.out.println con el atributo único de cada subclase.

Resultado de la Ejecución en Consola (Fase 3)
=== INICIANDO SIMULADOR CON HERENCIA ===

--- Estado Inicial de los Modelos Especializados ---
 Modelo: PerceptronMulticapa | Épocas: 0 | Precisión: 50.0% | Tasa: 0.01
└─ [Específico] Capas Ocultas: 5
 Modelo: RandomForest | Épocas: 0 | Precisión: 50.0% | Tasa: 0.05
└─ [Específico] Profundidad Máxima: 15
Modelo: RegresionLogistica | Épocas: 0 | Precisión: 50.0% | Tasa: 0.1
└─ [Específico] Coeficiente Regularización: 0.001

--- Entrenando Modelos (Uso de métodos heredados) ---
Modelo: PerceptronMulticapa | Épocas: 1 | Precisión: 55.5% | Tasa: 0.01
└─ [Específico] Capas Ocultas: 5
Modelo: RandomForest | Épocas: 1 | Precisión: 55.5% | Tasa: 0.05
└─ [Específico] Profundidad Máxima: 15
Modelo: RegresionLogistica | Épocas: 1 | Precisión: 55.5% | Tasa: 0.1
└─ [Específico] Coeficiente Regularización: 0.001

=== SIMULACIÓN FASE 3 COMPLETADA ===

Resultado de la Ejecución en Consola (Fase 4)

=== PIPELINE DE SIMULACION POLIMORFICA ===

--- Ejecutando Optimizacion Polimorfica ---
[RedNeuronal] Optimizando pesos con tasa 0.02. Precision previa: 50.0%
[ArbolDecision] Podando ramas con tasa 0.02. Precision previa: 50.0%
[ModeloRegresion] Ajustando gradiente con tasa 0.02. Precision previa: 50.0%

--- Probando Tuberia de Procesamiento de Texto (Tokenizadores) ---
Salida de TokenizadorBasico:
-> Token: [el]
-> Token: [simulador]
-> Token: [procesar]
-> Token: [inteligencia]

Salida de TokenizadorHuggingFace (Subpalabras):
-> Token: [el]
-> Token: [simul-ador]
-> Token: [pro-cesar]
-> Token: [intel-igencia]

=== PIPELINE FINALIZADO CON EXITO ===

Resultado de la Ejecución en Consola (Fase 5)
=== SIMULADOR CON CLASES ABSTRACTAS ===

--- Ejecutando Entrenamiento Desde Estructura Abstracta ---
Modelo: PerceptronMulticapa | Epocas: 1 | Precision: 57.0% | Tasa: 0.01
└─ [Especifico] Capas Ocultas: 6

Modelo: RandomForest | Epocas: 1 | Precision: 54.0% | Tasa: 0.05
└─ [Especifico] Profundidad Maxima: 10

Modelo: RegresionLogistica | Epocas: 1 | Precision: 53.5% | Tasa: 0.1
└─ [Especifico] Coeficiente Regularizacion: 0.002

--- Pipeline de Tokenizacion ---
Salida de TokenizadorBasico:
-> Token: [el]
-> Token: [simulador]
-> Token: [procesar]
-> Token: [inteligencia]

Salida de TokenizadorHuggingFace:
-> Token: [el]
-> Token: [simul-ador]
-> Token: [pro-cesar]
-> Token: [intel-igencia]

=== FIN DE LA SIMULACION ===

Fase 6: Módulo de Gestión de Colecciones Dinámicas
Ventajas del Framework de Colecciones
La refactorización de arreglos estáticos a estructuras de Java Collections Framework aporta mejoras clave en la arquitectura:

Escalabilidad de Modelos (List): El uso de ArrayList elimina la restricción de definir un tamaño rígido inicial. Permite que el ecosistema añada o elimine modelos de inteligencia artificial de forma dinámica en tiempo de ejecución, optimizando el uso de la memoria.

Mantenibilidad y Desacoplamiento (Map): Centralizar los procesadores de texto en un HashMap (catálogo) permite indexar componentes mediante claves semánticas de texto. Esto evita el uso de condicionales duros (if/else anidados) y facilita la inyección o intercambio de estrategias de tokenización de manera limpia.

Flexibilidad de Operaciones: Las colecciones facilitan tareas de ordenamiento, filtrado y búsqueda estructurada (como el algoritmo de umbral de precisión aplicado), aumentando la legibilidad del código fuente.

Resultado de la Ejecución en Consola (Fase 6)
=== SIMULADOR CON JAVA COLLECTIONS FRAMEWORK ===

--- Entrenando Modelos en la Lista Dinamica ---
Modelo: PerceptronMulticapa | Epocas: 1 | Precision: 58.0% | Tasa: 0.01
└─ [Especifico] Capas Ocultas: 8

Modelo: RandomForest | Epocas: 1 | Precision: 54.4% | Tasa: 0.05
└─ [Especifico] Profundidad Maxima: 12

Modelo: RegresionLogistica | Epocas: 1 | Precision: 53.5% | Tasa: 0.1
└─ [Especifico] Coeficiente Regularizacion: 0.005

--- Recuperacion de Tokenizador desde Catalogo Indexado ---
Salida del procesador recuperado [HUGGING_FACE]:
-> Token: [el]
-> Token: [simul-ador]
-> Token: [pro-cesar]
-> Token: [intel-igencia]

--- Filtrado Avanzado: Modelos con Precision > 55.0% ---
-> PerceptronMulticapa supero el umbral. Precision: 58.0%

=== SIMULACION COMPLETA TERMINADA ===

Resultado de la Ejecución en Consola (Fase 7)
=== SIMULADOR CON MANEJO DE EXCEPCIONES ===

--- Cargando Componentes Validos ---
--- Buscando Procesador en Catalogo ---

[REPORTE DE FALLO CONTROLADO]
Detalle del error: Error: El componente de procesamiento solicitado [OPEN_AI] no esta registrado.
Accion: Saltando proceso afectado y continuando ejecucion de forma segura.

--- Bloque Finally: Fase de auditoria y limpieza concluida con exito. ---

--- Continuacion del Flujo del Sistema (Resiliencia) ---
El programa principal no se cerro de golpe y sigue operativo.
Modelo: PerceptronMulticapa | Epocas: 1 | Precision: 58.0% | Tasa: 0.01
└─ [Especifico] Capas Ocultas: 8
Modelo: RandomForest | Epocas: 1 | Precision: 54.4% | Tasa: 0.05
└─ [Especifico] Profundidad Maxima: 12

=== SIMULACION COMPLETA TERMINADA ===