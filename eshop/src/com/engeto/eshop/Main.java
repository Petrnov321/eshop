package com.engeto.eshop;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here


        Database db = new Database();

        /*
        Item firstLoadedItem = db.loadItemById(1);
        Item secondLoadedItem = db.loadItemById(2);
        System.out.println(firstLoadedItem);
        System.out.println(secondLoadedItem);
        */


        //System.out.println(db.loadItemById(5));

        /*
        db.printDB();
        System.out.println();
        db.deleteAllOutOfStockItems();
        db.printDB();
        */

        /*
        List<Item> items = db.loadAllAvailableItems();
        for (Item item1: items) {
            System.out.println(item1);
        }
        */

        /*
        Item item = db.loadItemById(5);
        db.saveItem(item);
        db.printDB();
        */

        //db.updatePrice(3, new BigDecimal("15.0"));
        //System.out.println(db.loadItemById(3));

    }
}
