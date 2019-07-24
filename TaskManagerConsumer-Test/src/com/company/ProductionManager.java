package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProductionManager {
    static Queue<Student> buffer = new LinkedList<Student>();
    static Semaphore semaphore1;
    public static Random random = new Random();

    /*Initialization of default values*/
    public static int firstTime=1;
    static int produserThreadNr=3;
    static int consumerThreadNr=2;
    static int maximumPermits=100;
    static int minimPermits=80;
    static int initialQueueSize=200;

    static int exit=0;

}
