package ro.jademy.carrental.data;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.car.Dacia;
import ro.jademy.carrental.car.make.Audi;
import ro.jademy.carrental.users.Administrator;
import ro.jademy.carrental.users.Customer;
import ro.jademy.carrental.users.Salesman;
import ro.jademy.carrental.users.Users;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Users> users = new ArrayList<>();
    public static ArrayList<Car> carList = new ArrayList<>();

    public static ArrayList<Car> carList() {
        carList.add(new Dacia("Logan", 2016, "sedan", "Diesel", 4, "Red", "Manual", "1.0", "250"));
        carList.add(new Dacia("Logan", 2012, "sedan", "Diesel", 4, "Red", "Manual", "0.8", "50"));
        carList.add(new Dacia("Sandero", 2018, "4x4", "Diesel", 4, "Red", "Manual", "1.4", "350"));
        carList.add(new Audi("A4", 2019, "sedan", "Gasoline", 4, "Red", "Manual", "3.0", "850"));
        carList.add(new Audi("A4", 2014, "sedan", "Diesel", 4, "Red", "Manual", "2.4", "450"));
        carList.add(new Audi("A1", 2020, "coupe'", "Diesel", 4, "Red", "Manual", "1.6", "250"));
        return carList;
    }

    public static ArrayList<Users> userList() {
        users.add(new Administrator("Johnny", "Meran", "John", "1234"));
        users.add(new Salesman("Alexandru", "Patro", "Alex", "1234"));
        users.add(new Salesman("George", "Respa", "Geo", "1234"));
        users.add(new Customer("Florin", "Carata", "Flo", "1234"));
        return users;
    }

    public static void carListMixer(ArrayList<Users> userList, ArrayList<Car> carList) {
        while (carList.size() > 0) {
            for (Users user : userList) {
                if (user instanceof Salesman) {
                    ((Salesman) user).availableCars.add(carList.remove(0));
                }
            }
        }
    }
}