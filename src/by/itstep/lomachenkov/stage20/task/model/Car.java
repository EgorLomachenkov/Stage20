package by.itstep.lomachenkov.stage20.task.model;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private Thread thread;
    private String name;
    private int waitingTime;
    private CarParking carParking;
    private Semaphore semaphore;
    private Logger logger;

    public Car(String name, int waitingTime, CarParking carParking, Semaphore semaphore, Logger logger) {
        thread = new Thread(this);
        this.name = name;
        this.waitingTime = waitingTime;
        thread.start();
        this.carParking = carParking;
        this.semaphore = semaphore;
        this.logger = logger;
    }

    @Override
    public void run() {
        int flag = 0;
        while (true) {
            if (semaphore.tryAcquire() && flag < 2) {
                try {
                    logger.info(this + " just parked here...");
                    carParking.parking();
                    break;
                } finally {
                    logger.info(this + " just leave the parking...");
                    semaphore.release();
                }
            } else {
                try {
                    if (++flag == 2) {
                        logger.info(this + " can't wait so long, leaves for another parking...");
                        semaphore.release();
                        break;
                    }
                    logger.info(this + " waiting for a place...");
                    TimeUnit.SECONDS.sleep(waitingTime);
                } catch (InterruptedException exception) {
                    logger.error(exception);
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
