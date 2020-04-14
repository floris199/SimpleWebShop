package com.demo.daoIntrf;

import com.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public List<T> getAll();
    public T get(String id);
    public void update(T t);
    public void delete(T t);
    public void save(T t);
}
