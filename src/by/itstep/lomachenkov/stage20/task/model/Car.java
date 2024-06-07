package by.itstep.lomachenkov.stage20.task.model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private Thread thread;
    private String name;
    private int waitingTime;
    private CarParking carParking;
    private Lock lock;

    public Car(String name, int waitingTime, CarParking carParking, Lock lock) {
        thread = new Thread(this);
        this.name = name;
        this.waitingTime = waitingTime;
        thread.start();
        this.carParking = carParking;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            if (lock.tryLock()) {
                try {
                    carParking.parking(this);
                    break;
                } finally {
                    lock.unlock();
                }
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(waitingTime);
                } catch (InterruptedException exception) {
                    System.out.println(exception);
                }
            }
        }
    }
}
