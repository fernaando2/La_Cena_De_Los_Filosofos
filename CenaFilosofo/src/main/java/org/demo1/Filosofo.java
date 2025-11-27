package org.demo1;

public class Filosofo implements Runnable {

    private int id;
    private Mesa mesa;

    public Filosofo(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " está pensando");
        Thread.sleep((long) (Math.random() * 2000 + 1000)); // 1-3 segundos
    }

    private void comer() throws InterruptedException {
        System.out.println("Filosofo " + id + " está comiendo");
        Thread.sleep((long) (Math.random() * 2000 + 1000)); // 1-3 segundos
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 1. Pensar
                pensar();

                // 2. Intenta comer
                System.out.println("Filosofo " + id + " está intentando comer");

                // 3. Coger palillos (mesa gestiona semáforos)
                mesa.tomarPalillos(id);

                // 4. Comer
                comer();

                // 5. Soltar palillos
                mesa.dejarPalillos(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

