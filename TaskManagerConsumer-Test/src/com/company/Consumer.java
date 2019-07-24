package com.company;

public class Consumer  implements Runnable {
    private String name;

    Consumer(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        while(true){
            if (ProductionManager.semaphore1.availablePermits() > 0) {

                synchronized (ProductionManager.buffer) {
            try {
                ProductionManager.semaphore1.acquire();
                System.out.println("Objects number : " + ProductionManager.semaphore1.availablePermits()+"\n\n");
                System.out.println("Consuming Objects number : ");
                ProductionManager.buffer.poll();
                Thread.sleep(200);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
            }
            if (ProductionManager.semaphore1.availablePermits() < ProductionManager.minimPermits ) {
                ProductionManager.firstTime=0;
            }
    }
}}
