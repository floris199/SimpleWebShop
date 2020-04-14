package com.demo.daoImpl;

import com.demo.daoIntrf.DAO;
import com.demo.dbUtils.ProductBridge;
import com.demo.model.Product;

import java.util.List;

public class ProductDAOImpl implements DAO<Product> {

    @Override
    public List<Product> getAll() {
        return ProductBridge.getAllProducts();
    }

    @Override
    public Product get(String id) {
        return ProductBridge.getProduct( id );
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void save(Product product) {

    }
}
