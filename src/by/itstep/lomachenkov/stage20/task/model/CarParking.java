package by.itstep.lomachenkov.stage20.task.model;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CarParking {
    private CopyOnWriteArrayList<Car> carPlaces;
    private int carsAmount;
    private int parkingTime;

    public CarParking(CopyOnWriteArrayList<Car> carPlaces, int carsLimit, int parkingTime) {
        this.carPlaces = carPlaces;
        this.carsAmount = carsLimit;
        this.parkingTime = parkingTime;
    }

    public void parking(Car car) {
        try {
            if (carsAmount++ < carPlaces.size()){
                carPlaces.add(car);
                TimeUnit.MILLISECONDS.sleep(parkingTime);
            }
        } catch (InterruptedException exception) {
            System.out.println(exception);
        }
    }


}
