package com.company;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import static com.company.ProductionManager.initialQueueSize;

public class Main {

    private static Random random = new Random();


    public static void main(String[] args) {

        ProductionManager.semaphore1=new Semaphore(initialQueueSize);

        /*Configuration task executed by threads*/
        Thread settings = new Thread(new ModifyProgramParameters());
        settings.start();
        try {
            settings.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread settings1 = new Thread(new NotifyManager());
        settings1.start();

        /*Create a listner for exit(1)*/
        Thread scaner1 = new Thread(new QuitFromButton());
        scaner1.start();

        /*Generate initial Queue state*/
        for (int i = 0; i <initialQueueSize; i++) {
            ProductionManager.taskQueue.add(new Student("Ion","FCIM",i));
        }

        ExecutorService serviceConsumers = Executors.newFixedThreadPool(ProductionManager.consumerThreadNr);
        ExecutorService serviceProducers = Executors.newFixedThreadPool(ProductionManager.produserThreadNr);


        for(int i=1;i<ProductionManager.produserThreadNr;i++) {
            Future consumerThread = serviceConsumers.submit(new Consumer(ProductionManager.taskQueue));
        }

        for(int i=1;i<ProductionManager.consumerThreadNr;i++) {
            Future producerThread = serviceConsumers.submit(new Producer(ProductionManager.taskQueue, initialQueueSize));

        }
        System.out.println("Done");

    }
}
