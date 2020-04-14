package com.demo.service;

import com.demo.daoImpl.CartDAOImpl;
import com.demo.model.Product;

public class CartService {

    public void saveItem( Product prod )
    {
        new CartDAOImpl().save( prod );
    }

    public void removeItem( Product prod )
    {
        new CartDAOImpl().delete( prod );
    }
}
