package ro.jademy.carrental.dao;

import java.util.List;

public interface EntityDao <T> {

    List<T> findAll();

    int findId(T item);

    T findById(int itemId);

    void create(T item);

    void update(T item);

    void remove(T item);

    void remove(int itemId);
}
