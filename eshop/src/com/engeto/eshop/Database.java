package com.engeto.eshop;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database implements GoodsMethods {

    private ResultSet result;
    private Statement statement;
    private Connection con;
    private Item i = new Item();


    //metoda načte item podle id
    @Override
    public Item loadItemById(Integer id) throws SQLException {
        String query = "SELECT * FROM item WHERE id = " + id +  ";";
        executeQuery(query);
        result.next();

        i = new Item();
        i.setId(result.getInt("id"));
        i.setPartNo(result.getString("partNo"));
        i.setSerialNo(result.getString("serialNo"));
        i.setName(result.getString("name"));
        i.setDescription(result.getString("description"));
        i.setNumberInStock(result.getInt("numberInStock"));
        i.setPrice(result.getBigDecimal("price"));
        closeDB();
        return i;
    }

    //vymaže všechny itemy co nejsou na skladě
    @Override
    public void deleteAllOutOfStockItems() throws SQLException {
        executeQuery("DELETE FROM item WHERE numberInStock < 1");
        closeDB();
    }

    //metoda načte všechny itemy které jsou na skladě
    @Override
    public List<Item> loadAllAvailableItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        executeQuery("SELECT * FROM item WHERE numberInStock > 0");
        while (result.next()){
            i = new Item();
            i.setId(result.getInt("id"));
            i.setPartNo(result.getString("partNo"));
            i.setSerialNo(result.getString("serialNo"));
            i.setName(result.getString("name"));
            i.setDescription(result.getString("description"));
            i.setNumberInStock(result.getInt("numberInStock"));
            i.setPrice(result.getBigDecimal("price"));
            items.add(i);
        }
        closeDB();
        return items;
    }

    //uložení itemu
    @Override
    public void saveItem(Item item) throws SQLException {
        executeQuery("INSERT INTO item (partNo, serialNo, name, description, numberInStock, price) VALUES ('" + item.getPartNo() + "', '" + item.getSerialNo() + "', '" + item.getName() + "', '"
                + item.getDescription() + "', '" + item.getNumberInStock() + "', '" + item.getPrice() + "');" );
        closeDB();
    }

    //aktualizuje cenu itemu
    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) throws SQLException {
        executeQuery("UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";");
        closeDB();
    }


    public void printDB() throws SQLException {
        executeQuery("SELECT * FROM item;");

        while (result.next()){
            System.out.println(
                    result.getInt("id") + " || "
                            + result.getString("partNo") + " || "
                            + result.getString("serialNo") + " || "
                            + result.getString("name") + "||"
                            + result.getString("description") + " || "
                            + result.getInt("numberInStock") + " || "
                            + result.getBigDecimal("price")
            );
        }

    }

    private void executeQuery(String sqlQuery) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "root", "toor");
        statement = con.createStatement();
        statement.execute(sqlQuery);
        result = statement.getResultSet();
    }

    private void closeDB() throws SQLException {
        con.close();
        statement.close();
        // result.close();
    }

}
