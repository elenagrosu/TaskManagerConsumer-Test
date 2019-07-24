package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductionManager {
    static Queue<Student> taskQueue = new LinkedList<Student>();
    static Semaphore semaphore1;

    /*Initialization of default values*/
    static int produserThreadNr=3;
    static int consumerThreadNr=20;
    static int maximumPermits=100;
    static int minimPermits=80;
    static int initialQueueSize=120;
    static Lock lock = new ReentrantLock();
    static int first;



    static int exit=0;

}
