package com.engeto.VecericiFilosofove;

public class Main {

    public static void main(String[] args) {

        int numberOfPhilosophersAndForks = 10;
        int full = 10000;

        Philosopher[] philosophers = new Philosopher[numberOfPhilosophersAndForks];
        Fork[] forks = new Fork[numberOfPhilosophersAndForks];

        try {
            for (int i = 0; i < numberOfPhilosophersAndForks; i++) {
                forks[i] = new Fork(i + 1);
            }
            for (int i = 0; i < numberOfPhilosophersAndForks; i++) {
                philosophers[i] = new Philosopher(i + 1, full, forks[i], forks[(i + 1) % numberOfPhilosophersAndForks]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for ( Philosopher filozof : philosophers ) {
            filozof.start();
        }
    }
}
