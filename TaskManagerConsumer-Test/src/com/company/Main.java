package com.company;

import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {
        ProductionManager.semaphore1=new Semaphore(ProductionManager.initialQueueSize);

        /*Generate initial Queue state*/
        for (int i = 0; i <ProductionManager.initialQueueSize; i++) {
            ProductionManager.buffer.add(new Student("Ion","FCIM",i));
        }
        for(int i=1;i<ProductionManager.produserThreadNr;i++) {
            Thread producer1 = new Thread(new Producer("Producer"+i));
            producer1.start();
        }
        for(int i=1;i<ProductionManager.consumerThreadNr;i++) {
            Thread consumer1 = new Thread(new Consumer("Consumer1"));
            consumer1.start();
            try {
                consumer1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
