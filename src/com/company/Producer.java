package com.company;

import java.util.Queue;

class Producer implements Runnable {

    private final Queue<Student> taskQueue;
    private final int maxCapacity;

    public Producer(Queue<Student> sharedQueue, int size) {
        this.taskQueue = sharedQueue;
        this.maxCapacity = size;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                produce();
                Thread.sleep(500);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private void produce() throws InterruptedException {

        synchronized (taskQueue) {
                if (ProductionManager.initialQueueSize <= ProductionManager.minimPermits) {
                    System.out.println("Total nr: " + ProductionManager.initialQueueSize);

                    taskQueue.add(new Student("Elena", "ti", 30));
                    ProductionManager.initialQueueSize++;
                    System.out.println("Producing " + "\n\n");
                }

        }
    }
}