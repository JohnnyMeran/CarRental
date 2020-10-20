package ro.jademy.carrental.dao;

import ro.jademy.carrental.model.car.Car;

import java.util.List;

public interface CarDao extends EntityDao<Car> {
    List<Car> findAll();

    Car findById(int itemId);

    void create(Car item);

    void update(Car item);

    void remove(Car item);

    void remove(int itemId);
}
