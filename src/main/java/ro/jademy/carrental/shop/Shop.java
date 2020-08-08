package ro.jademy.carrental.shop;

import ro.jademy.carrental.car.Car;
import ro.jademy.carrental.data.Data;
import ro.jademy.carrental.users.Salesman;
import ro.jademy.carrental.users.Users;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    // Q: what fields and methods should this class contain?
    protected ArrayList<Users> userList = new ArrayList<>();
    protected Scanner userInput = new Scanner(System.in);
    protected static boolean exit;
    protected static boolean logout;

    public Shop(ArrayList<Users> userList) {
        this.userList.addAll(userList);//TODO this.userList = userList;
    }

    public boolean start() {
        exit = false;
        logout = false;
        if (login(userInput.next(), userInput.next())) {
            while (!showMenu()) {
            }
        }
        return exit;
    }

    private boolean login(String username, String password) {
        // TODO: implement a basic user login
        for (Users user : userList) {
            if (user.getUserName().equals(username)) {
                if (user.getPassWord().equals(password)) {
                    System.out.println("Login Successful");
                    return true;
                }
            }
        }
        System.out.println("Username or Password wrong, please retry");
        return false;
    }

    private void exit() {
        exit = true;
    }

    private void logout() {
        logout = true;
    }

    private boolean showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Check income");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        switch (userInput.nextInt()) {
            case 1:
                listAllCar();
                break;
            case 2:
                listAvailableCar();
                break;
            case 3: //list rented cars
            case 4: //check income
            case 5:
                logout();
                break;
            case 6:
                logout();
                exit();
                break;
        }
        return logout;
    }

    private void listAllCar() {
        for (Car car : this.carList) {
            System.out.println(car.toString());
        }
    }

    private void listAvailableCar() {
        for (Users user : userList) {
            if (user instanceof Salesman) {
                System.out.println(user.getFirstName());
                for (int i = 0; i < ((Salesman) user).availableCars.size(); i++) {
                    System.out.println(((Salesman) user).availableCars.get(i).toString());
                }
            }
        }
    }

    private void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

    }

    private void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        // Q: what should be the return type of this method?
    }
}
