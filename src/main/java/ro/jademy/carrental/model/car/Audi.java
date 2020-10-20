package ro.jademy.carrental.model.car;

import ro.jademy.carrental.model.car.Car;

public class Audi extends Car {
    public Audi(String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, String engine, String basePrice) {
        this.make = "Audi";
        this.model = model;
        this.year = year;
        this.carType = carType;
        this.fuelType = fuelType;
        this.doorNumber = doorNumber;
        this.color= color;
        this.transmissionType = transmissionType;
        this.engine = engine;
        this.basePrice = basePrice;
    }
}
