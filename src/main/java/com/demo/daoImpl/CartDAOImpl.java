package com.demo.daoImpl;

import com.demo.daoIntrf.DAO;
import com.demo.dbUtils.CartBridge;
import com.demo.model.Product;

import java.util.List;

public class CartDAOImpl implements DAO<Product> {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product get(String id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {
        CartBridge.removeFromCart( product );
    }

    @Override
    public void save(Product product) {
        CartBridge.saveInCart( product );
    }
}
