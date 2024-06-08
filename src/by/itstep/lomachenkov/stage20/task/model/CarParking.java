package by.itstep.lomachenkov.stage20.task.model;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class CarParking {
    private int parkingTime;
    private Logger logger;

    public CarParking(int parkingTime, Logger logger) {
        this.parkingTime = parkingTime;
        this.logger = logger;
    }

    public void parking() {
        try {
            TimeUnit.SECONDS.sleep(parkingTime);
        } catch (InterruptedException exception) {
            logger.error(exception);
        }
    }


}
