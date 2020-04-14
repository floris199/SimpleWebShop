package com.demo.dbUtils;

import com.demo.model.ProductType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeBridge {

    private static String productTypesCsvFile = "src/main/resources/productTypes.csv";
    private static String line = "";
    private static String cvsSplitBy = ",";

    public static List<ProductType> getAllProductTypes() {
        try (BufferedReader br = new BufferedReader(new FileReader(productTypesCsvFile))) {
            List<ProductType> allProductTypes =  new ArrayList<>();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] productTypeTokens = line.split(cvsSplitBy);

                allProductTypes.add( new ProductType(productTypeTokens[0], productTypeTokens[1]) );
            }

            return allProductTypes;

        } catch (IOException e) {
            e.printStackTrace();

            return new ArrayList<>();
        }

    }
}
