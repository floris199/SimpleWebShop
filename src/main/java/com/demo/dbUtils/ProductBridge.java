package com.demo.dbUtils;

import com.demo.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductBridge {

    private static String productsCsvFile = "src/main/resources/products.csv";
    private static String line = "";
    private static String cvsSplitBy = ",";

    public static List<Product> getAllProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(productsCsvFile))) {
            List<Product> allProducts =  new ArrayList<>();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] productTokens = line.split(cvsSplitBy);

                allProducts.add( new Product(productTokens[0], productTokens[1], productTokens[2], productTokens[3]));
            }

            return allProducts;

        } catch (IOException e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public static Product getProduct(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(productsCsvFile))) {
            List<Product> allProducts =  new ArrayList<>();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] productTokens = line.split(cvsSplitBy);

                if( id.equals(productTokens[0])){
                    return new Product(productTokens[0], productTokens[1], productTokens[2], productTokens[3]);
                }
            }

            return null;

        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}
