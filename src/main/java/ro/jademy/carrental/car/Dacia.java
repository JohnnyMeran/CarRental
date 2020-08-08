package ro.jademy.carrental.car;

public class Dacia extends Car {
    public Dacia(String model, Integer year, String carType, String fuelType, Integer doorNumber, String color, String transmissionType, String engine, String basePrice) {
        this.make = "Dacia";
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
