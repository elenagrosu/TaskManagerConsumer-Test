package com.company;

import java.util.Queue;

class Consumer implements Runnable {

    private final Queue<Student> taskQueue;

    public Consumer(Queue<Student> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {

                if(ProductionManager.initialQueueSize>0) {
                    taskQueue.poll();
                    ProductionManager.initialQueueSize--;
                    System.out.println("Total nr: " + ProductionManager.initialQueueSize);
                    System.out.println("Consuming " + "\n\n");
                }

        }
    }
}