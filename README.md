La Cena de los Filósofos

🧠🍽️ Descripción del Proyecto

Este proyecto aborda el clásico problema de La Cena de los Filósofos, un ejercicio fundamental en el estudio de la concurrencia y la sincronización en sistemas distribuidos.
En él, cinco filósofos deben compartir recursos limitados (los palillos) mientras alternan entre pensar, tener hambre y comer.

La solución implementada se basa en mecanismos de sincronización que permiten garantizar un funcionamiento correcto, evitando conflictos y manteniendo la fluidez del sistema en todo momento.

📚 Objetivo del Proyecto

El propósito principal es diseñar un sistema que permita a los filósofos:

Alternar correctamente entre sus diferentes estados.

Compartir recursos de forma ordenada.

Evitar situaciones problemáticas como interbloqueos (deadlocks) o inanición (starvation).

Respetar una restricción adicional: como máximo dos filósofos pueden estar comiendo al mismo tiempo.

El enfoque favorece un comportamiento seguro, equilibrado y justo entre los filósofos, manteniendo una dinámica constante sin bloqueos.

🏗️ Estructura del Proyecto

El proyecto se divide en tres componentes principales:

🧩 Filosofo

Representa a cada uno de los cinco filósofos como una entidad independiente que actúa de forma concurrente.
Cada filósofo piensa, siente hambre, intenta comer y libera los recursos tras hacerlo.

🍽️ Mesa

Es el elemento central que gestiona los recursos compartidos.
Controla los palillos disponibles y decide cuándo un filósofo puede utilizarlos.
Además, incorpora un mecanismo que limita la cantidad máxima de filósofos comiendo simultáneamente.

🚀 Main

Es el punto de inicio del programa.
En él se inicializa la mesa, se crean los filósofos y se ponen en marcha sus ciclos de actividad.

🔒 Gestión de Concurrencia

El sistema implementa varias medidas para garantizar un comportamiento correcto:

✔️ Evitar Interbloqueos

Se adopta una estrategia que garantiza que los filósofos nunca queden permanentemente bloqueados esperando recursos.
Esto se consigue mediante:

Una coordinación específica en el orden con el que se toman los palillos.

La limitación de acceso a la zona de “comer”.

✔️ Evitar Inanición

Para impedir que un filósofo quede eternamente esperando mientras otros comen repetidamente, se incorpora un sistema basado en equidad.
Esto asegura que todos los filósofos tengan oportunidad de acceder a los recursos cuando les corresponde.

✔️ Control de Acceso

El sistema permite que solo dos filósofos coman al mismo tiempo, lo que reduce la competitividad por los palillos y mejora la estabilidad del conjunto.

🔍 Ciclo de Vida de los Filósofos

Cada filósofo pasa repetidamente por las siguientes fases:

Pensar 🧘‍♂️

El filósofo reflexiona tranquilamente sin usar recursos.

Hambriento 😋

Decide que quiere comer e informa de su intención.

Intento de comer 🥢

Solicita acceso a los palillos correspondientes.

Comer 🍽️

Consume su comida durante un tiempo y luego libera los recursos.

Terminar y volver a pensar 🔄

Libera los palillos y comienza de nuevo el ciclo.

Este comportamiento genera una salida dinámica donde se reflejan en tiempo real los estados de cada filósofo.

📷 Ejemplo de Salida del Programa

La salida puede variar debido a la naturaleza concurrente del sistema, pero típicamente incluye líneas como:

Filosofo 3 está pensando

Filosofo 1 está hambriento

Filosofo 1 está comiendo

Filosofo 1 ha terminado de comer, palillos libres: ...

Con esto se obtiene una representación clara del funcionamiento y del orden en que cada filósofo avanza en su ciclo.

🧩 Aprendizaje y Reflexión

Este proyecto permite comprender en profundidad:

Cómo interactúan los hilos en un programa concurrente.

Cómo gestionar recursos compartidos de manera segura.

La importancia de evitar condiciones inseguras en sistemas distribuidos.

El papel fundamental de los mecanismos de sincronización en problemas clásicos.
