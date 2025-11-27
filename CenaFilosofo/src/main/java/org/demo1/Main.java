package org.demo1;

public class Main {

    public static void main(String[] args) {

        int numFilosofos = 5;
        int maxComiendoALaVez = 2;

        // Crear la mesa con 5 filósofos y máximo 2 comiendo a la vez
        Mesa mesa = new Mesa(numFilosofos, maxComiendoALaVez);

        Thread[] filosofos = new Thread[numFilosofos];// Array para los hilos de filósofos

        for (int i = 0; i < numFilosofos; i++) {// Crear e iniciar cada filósofo
            filosofos[i] = new Thread(new Filosofo(i, mesa));
            filosofos[i].start();
        }
    }
}
