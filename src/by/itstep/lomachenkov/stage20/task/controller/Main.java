package by.itstep.lomachenkov.stage20.task.controller;

import by.itstep.lomachenkov.stage20.task.model.Car;
import by.itstep.lomachenkov.stage20.task.model.CarParking;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Main {
    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
        LOGGER.setLevel(Level.DEBUG);
    }
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        CarParking carParking = new CarParking(3, LOGGER);
        Car car1 = new Car("car1", 2, carParking, semaphore, LOGGER);
        Car car2 = new Car("car2", 2, carParking, semaphore, LOGGER);
        Car car3 = new Car("car3", 2, carParking, semaphore, LOGGER);
        Car car4 = new Car("car4", 2, carParking, semaphore, LOGGER);
        Car car5 = new Car("car5", 2, carParking, semaphore, LOGGER);
        Car car6 = new Car("car6", 2, carParking, semaphore, LOGGER);
        Car car7 = new Car("car7", 3, carParking, semaphore, LOGGER);
        Car car8 = new Car("car8", 4, carParking, semaphore, LOGGER);
    }
}
