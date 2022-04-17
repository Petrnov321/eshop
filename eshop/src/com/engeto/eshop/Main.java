package com.engeto.eshop;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        Item item = new Item();

        //item.loadItemById(5);
        //System.out.println(item);

        //item.deleteAllOutOfStockItems();
        //item.printDB();

       /*
        List<Item> items = item.loadAllAvailableItems();
        for (Item item1: items) {
            System.out.println(item1);
        }
        */

        //item.saveItem(item);
        //item.printDB();

        /*
        item.updatePrice(3, new BigDecimal("15.0"));
        item.loadItemById(3);
        System.out.println(item);
        */
    }
}
