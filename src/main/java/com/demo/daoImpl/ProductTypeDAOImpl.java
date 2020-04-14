package com.demo.daoImpl;

import com.demo.daoIntrf.DAO;
import com.demo.dbUtils.ProductTypeBridge;
import com.demo.model.ProductType;

import java.util.List;

public class ProductTypeDAOImpl implements DAO<ProductType> {
    @Override
    public List<ProductType> getAll() {
        return ProductTypeBridge.getAllProductTypes();
    }

    @Override
    public ProductType get(String id) {
        return null;
    }

    @Override
    public void update(ProductType productType) {

    }

    @Override
    public void delete(ProductType productType) {

    }

    @Override
    public void save(ProductType productType) {

    }
}
