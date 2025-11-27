package org.demo1;

import java.util.concurrent.Semaphore;

public class Mesa {

    private int numFilosofos;
    private Semaphore[] palillos;
    private Semaphore maxComiendo;

    public Mesa(int numFilosofos, int maxComiendoSimultaneos) {
        this.numFilosofos = numFilosofos;

        // Un semáforo por palillo (1 permiso cada uno)
        palillos = new Semaphore[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            palillos[i] = new Semaphore(1, true); // fair = true para evitar inanición
        }

        // Semáforo global: máximo X filósofos comiendo a la vez
        maxComiendo = new Semaphore(maxComiendoSimultaneos, true);
    }

    // El filósofo id intenta coger sus palillos
    public void tomarPalillos(int id) throws InterruptedException {
        int izq = id;
        int der = (id + 1) % numFilosofos;

        // Limitar número máximo de filósofos comiendo
        maxComiendo.acquire();

        // Evitar interbloqueo: el filósofo 0 coge en orden inverso
        if (id == 0) {
            palillos[der].acquire();
            palillos[izq].acquire();
        } else {
            palillos[izq].acquire();
            palillos[der].acquire();
        }

        System.out.println("Filosofo " + id + " ha tomado los palillos " + izq + " y " + der);
    }

    // El filósofo id suelta sus palillos
    public void dejarPalillos(int id) {
        int izq = id;
        int der = (id + 1) % numFilosofos;

        palillos[izq].release();
        palillos[der].release();

        System.out.println(
                "Filosofo " + id + " ha terminado de comer, palillos libres " + izq + ", " + der
        );

        // Deja de estar comiendo y se libera un hueco
        maxComiendo.release();
    }
}

