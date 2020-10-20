package ro.jademy.carrental.model.users;

import ro.jademy.carrental.model.car.Car;

import java.util.ArrayList;

public class Employee extends User {
    private int employeeId;
    private int companyId;
    public ArrayList<Car> availableCars = new ArrayList<>();

    public Employee(int id, int employeeId, int companyId,String firstName, String lastName, String userName, String passWord) {
        this.userId = id;
        this.employeeId = employeeId;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Employee(String firstName, String lastName, String userName, String passWord, int companyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.companyId = companyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", companyId=" + companyId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
