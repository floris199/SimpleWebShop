package com.demo.dbUtils;

import com.demo.model.Product;

import java.io.*;

public class CartBridge {

    private static String auditSaveCartFile = "src/main/resources/itemsSavedInCart.txt";
    private static String auditRemoveCartFile = "src/main/resources/itemsRemovedFromCart.txt";

    public static void saveInCart( Product prod )
    {
        writeToFile ("Product with name: " + prod.getName() + " was added to cart!", auditSaveCartFile);
    }

    public static void removeFromCart( Product prod )
    {
        writeToFile ("Product with name: " + prod.getName() + " was removed from the cart!", auditRemoveCartFile);
    }

    private static void writeToFile ( String text, String fileName )
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if( !checkEmptiness( fileName ) ) {
                writer.newLine();
            }
            writer.append(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkEmptiness ( String fileName )
    {
        File file = new File(fileName);

        if (file.length() == 0) {
            return true;
        }
        return false;
    }
}
