package ro.jademy.carrental.dao;

import ro.jademy.carrental.model.car.Car;

import java.util.List;

public class DBCarDao implements CarDao {

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public int findId(Car car){return -1;}

    @Override
    public Car findById(int itemId) {
        return null;
    }

    @Override
    public void create(Car item) {

    }

    @Override
    public void update(Car item) {

    }

    @Override
    public void remove(Car item) {

    }

    @Override
    public void remove(int itemId) {

    }
}
