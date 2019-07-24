package com.company;

import java.util.Random;

public class Producer implements Runnable {
    private String name;

    Producer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
        if (ProductionManager.exit == 0 && ProductionManager.firstTime==0) {

            synchronized (ProductionManager.buffer) {

                try {
                    Random random = new Random();
                    int i = random.nextInt(20);
                    ProductionManager.semaphore1.release();
                    System.out.println("Objects number : " + ProductionManager.semaphore1.availablePermits() + " " + "\n\n");
                    System.out.println("Producting Objects number : ");

                    ProductionManager.buffer.add(new Student("Maria", "IT", 123));
                    Thread.sleep(200);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (ProductionManager.semaphore1.availablePermits() < ProductionManager.minimPermits ) {
                ProductionManager.firstTime=0;
            }
            if (ProductionManager.semaphore1.availablePermits() >= ProductionManager.maximumPermits){
                ProductionManager.firstTime=1; }

        }}
    }
}