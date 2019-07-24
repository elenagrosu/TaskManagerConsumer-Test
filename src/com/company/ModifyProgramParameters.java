package com.company;

import java.util.Scanner;

/**
 * ModifyProgramParameters class is used to configure program if it's needed
 * */
public class ModifyProgramParameters implements Runnable {
    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to configure data [Y/N] :");
        String answer = scanner.next();
        System.out.println(answer);

        if(answer.equals("Y") || answer.equals("y") || answer.equals("Yes") || answer.equals("yes")){
            System.out.println("---------------Configure---------------- ");
            System.out.println("Initial number of Objects in Queue :");
            ProductionManager.initialQueueSize=scanner.nextInt();
            System.out.println("Maximum size :");
            ProductionManager.maximumPermits=scanner.nextInt();
            System.out.println("Minium size");
            ProductionManager.minimPermits=scanner.nextInt();
            System.out.println("Producer nr of threads :");
            ProductionManager.produserThreadNr=scanner.nextInt();
            System.out.println("Consumer nr of threads :");
            ProductionManager.consumerThreadNr=scanner.nextInt();
        }
    }
}
