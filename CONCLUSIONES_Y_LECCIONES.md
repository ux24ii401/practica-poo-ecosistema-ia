Proyecto: Simulador Avanzado de Algoritmos de Inteligencia Artificial

Asignatura:Programación Orientada a Objetos

Evolución: Fase 2 a Fase 8 (Refactorización Estructural a Java 17)

Estado Final: Quality Gate de SonarQube: APROBADO (VERDE)

2. Resumen Ejecutivo
   El ciclo de desarrollo de este simulador de Inteligencia Artificial ha representado un proceso de evolución arquitectónica incremental. Iniciando en la Fase 2 con un núcleo básico enfocado en la Encapsulación Core (restringiendo accesos directos y protegiendo variables con setters validados), el sistema escaló hacia la especialización algorítmica mediante la Herencia en la Fase 3, derivando modelos específicos como Redes Neuronales y Árboles de Decisión.

Posteriormente, se rompió el acoplamiento rígido introduciendo Interfaces (Fase 4) y Clases Abstractas (Fase 5), garantizando que el pipeline operara de manera abstracta y genérica sin depender de implementaciones físicas. En las etapas finales (Fase 6 y Fase 7), los arreglos estáticos obsoletos se reemplazaron por el Framework de Colecciones (List y Map) y se instaló un sistema robusto de Control de Errores mediante excepciones personalizadas.

Finalmente, en la Fase 8, el ecosistema se migró completamente a Java 17, blindando la jerarquía con clases selladas e inmutabilidad extrema (records), logrando un software altamente mantenible, resiliente y auditado bajo estándares de calidad estricta.

3. Reporte de Calidad SonarQube
   Estado Inicial (El "Antes")
   Al ejecutar el primer análisis estático sobre el código de las fases previas, el sistema detectó múltiples inconformidades técnicas que afectaban la mantenibilidad del software.

Plaintext
Ruta: src/com/ia/modelos/ModeloIA.java
[Code Smell - Major]: Convert this class constructor access modifier to 'protected'. Abstract classes should not have public constructors.
[Code Smell - Minor]: Remove this unused import 'java.util.Scanner'.
[Code Smell - Major]: Rename package name 'com.ia.modelos.impl' to comply with snake_case/lowercase format.
A continuación se documenta el estado del tablero con las alertas encendidas:

Estado Corregido y Limpio (El "Después")
Luego de aplicar las refactorizaciones de Clean Code, remover los imports muertos, asegurar la visibilidad protegida de la superclase abstracta sellada y estandarizar la nomenclatura de paquetes, el análisis estático arrojó un estado limpio.

Bugs: 0

Vulnerabilities: 0

Code Smells: 0

Deuda Técnica: 0 min

A continuación se evidencia el cumplimiento del umbral de calidad empresarial:

4. Cuestionario de Evaluación de Lecciones Aprendidas
   Sobre la Modernización del Lenguaje
   ¿De qué manera la implementación de Java 17 records y sealed classes optimizó el pilar de encapsulación y el control de la jerarquía de herencia en comparación con el diseño tradicional de Java 8 de las primeras fases?

Respuesta: En Java 8 tradicional, la inmutabilidad y encapsulación de objetos transportadores de datos (como las configuraciones de prompts) requerían declarar atributos private final, generar explícitamente constructores robustos y sobreescribir manualmente métodos boilerplate como toString(), equals() y hashCode(), lo cual añadía verbosidad propensa a errores. Al implementar un record en Java 17, el compilador procesa estas características de manera nativa e inmutable por defecto. Por otro lado, el diseño tradicional de Java 8 no permitía restringir qué clases externas extendían de una clase abstracta a menos que se usara el modificador final (que bloqueaba toda la herencia). Las sealed classes de Java 17 resuelven esto al permitir un control granular y estricto mediante la cláusula permits, asegurando que únicamente los algoritmos autorizados del ecosistema (RedNeuronal, ArbolDecision, ModeloRegresion) puedan heredar de la superclase base, optimizando drásticamente la integridad de la arquitectura.

Sobre la Deuda Técnica
Al ejecutar el primer escaneo en SonarQube, ¿cuáles fueron los tres "code smells" o vulnerabilidades más críticos detectados en tu código y qué principios de diseño limpio aplicaste para corregirlos?

Respuesta: 1. Constructor público en una clase abstracta: SonarQube penalizó esto ya que una clase abstracta no puede ser instanciada con un new de forma directa, por lo que su constructor solo debe ser accesible para sus hijos. Se aplicó el principio de diseño limpio modificando el acceso a protected.
2. Uso de condicionales duros y redundantes para la selección de componentes: Se corrigió migrando el viejo mapeo hacia una expresión switch estructurada de Java 17 con flechas (->), reduciendo drásticamente la complejidad ciclomática del software.
3. Importaciones de librerías muertas o no utilizadas (Dead Code): Se eliminaron los paquetes innecesarios detectados por el analizador para respetar la regla de mantener un código fuente minimalista, limpio y fácil de leer.

Sobre el Flujo de Control y Resiliencia
¿Cómo interactúa el mecanismo de manejo de excepciones desarrollado en la Fase 7 con las métricas de confiabilidad analizadas por SonarQube? ¿Evitó esto la presencia de bloques vacíos (catch blocks) penalizados por la plataforma?

Respuesta: El mecanismo de excepciones desarrollado mediante la clase personalizada IAComponentException interactúa directamente con la métrica de Confiabilidad (Reliability) de SonarQube, ya que intercepta de forma controlada los comportamientos inesperados en lugar de permitir que la máquina virtual lance un fallo genérico que detenga la ejecución del hilo principal. Este diseño evitó estrictamente la presencia de bloques catch vacíos, una de las deudas técnicas más severas castigadas por las plataformas de análisis estático. Cada bloque catch de nuestra arquitectura implementa un tratamiento activo del fallo, registrando un reporte detallado del error en la consola y activando un flujo de contingencia que mantiene la resiliencia y operatividad de la aplicación.

Sobre la Flexibilidad de las Abstracciones
Explica cómo el uso combinado de colecciones dinámicas (List/Map) and abstracciones polimórficas te permitió integrar las nuevas características de Java 17 sin romper la arquitectura base que ya habías diseñado.

Respuesta: El uso combinado de abstracciones polimórficas actúa como un contrato o interfaz de desacoplamiento puro. Debido a que el pipeline central (la clase SimuladorIA) interactuaba directamente con referencias abstractas de ModeloIA (almacenadas dinámicamente dentro de un ArrayList) y referencias de la interfaz Tokenizador (indexadas en un HashMap), la implementación interna de los objetos físicos se volvió irrelevante para el orquestador principal. Gracias a este aislamiento de responsabilidades, pudimos transformar la clase base en una estructura sellada (sealed), agregar modificadores final en las subclases e inyectar un componente inmutable del tipo record para alimentar el procesamiento de texto, sin tener que reescribir, alterar o romper el flujo lógico de control y simulación que ya se encontraba validado.

Sobre el Impacto en la Ingeniería
Desde la perspectiva de un Ingeniero en Inteligencia Artificial, ¿por qué es crítico que un software que implementa pipelines de LLM o simuladores de algoritmos sea sometido a pruebas de análisis estático de código como SonarQube antes de ser desplegado en producción?

Respuesta: En la ingeniería de Inteligencia Artificial moderna, los pipelines encargados de procesar grandes volúmenes de texto o gestionar el ciclo de vida de modelos basados en Grandes Modelos de Lenguaje (LLM) operan de forma altamente dinámica y demandante en términos de cómputo. Un código con fallas de diseño sutiles, como fugas de memoria generadas por una mala gestión de referencias en colecciones o el desbordamiento de hilos debido a excepciones mal administradas, puede provocar la caída total del servicio en producción o generar un consumo de infraestructura sumamente costoso. Someter la solución a un escaneo automatizado con SonarQube asegura, antes del despliegue, que la tubería de software cumpla con una mantenibilidad óptima, erradique malas prácticas de concurrencia y garantice la resiliencia necesaria para absorber cambios continuos en los modelos de lenguaje del estado del arte de forma segura y eficiente.