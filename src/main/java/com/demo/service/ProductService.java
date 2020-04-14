package com.demo.service;

import com.demo.daoImpl.ProductDAOImpl;
import com.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List getAvailableProducts(String type){

        List<Product> products = new ArrayList<>();

        for( Product p : new ProductDAOImpl().getAll() )
        {
            if( p.getCategory().equals( type ) )
            {
                products.add(p);
            }
        }

        return products;
    }

    public Product getProduct(String id)
    {
        return new ProductDAOImpl().get(id);
    }
}
