package ro.jademy.carrental.users;

import ro.jademy.carrental.car.Car;

import java.util.ArrayList;

public class Salesman extends Users{
    public ArrayList<Car> availableCars = new ArrayList<>();

    public Salesman(String firstName, String lastName, String userName, String passWord) {
        super(firstName, lastName, userName, passWord);
    }
}
