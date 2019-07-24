package com.company;

public class NotifyManager implements Runnable {
    @Override
    public void run() {
        while (Thread.currentThread().isInterrupted()) {
            if (ProductionManager.initialQueueSize <= ProductionManager.minimPermits) {


            }
        }
    }

}
