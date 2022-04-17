package com.engeto.eshop;

import com.mysql.cj.xdevapi.Result;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Item implements GoodsMethods {

    private Integer id;
    private String partNo;//číslo dílu
    private String serialNo;//sériové číslo
    private String name;//jméno
    private String description;//popis
    private Integer numberInStock;//množství na skladě
    private BigDecimal price;//cena

    private ResultSet result;
    private Statement statement;
    private Connection con;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //metoda načte item podle id
    @Override
    public Item loadItemById(Integer id) throws SQLException{
        String idToString = String.valueOf(id);
        String query = "SELECT * FROM item WHERE id = " + id +  ";";
        initDB(query);
        result.next();

        id = result.getInt("id");
        this.id = id;
        partNo = result.getString("partNo");
        serialNo = result.getString("serialNo");
        name = result.getString("name");
        description = result.getString("description");
        numberInStock = result.getInt("numberInStock");
        price = result.getBigDecimal("price");
        closeDB();
        return this;
    }

    //vymaže všechny itemy co nejsou na skladě
    @Override
    public void deleteAllOutOfStockItems() throws SQLException{
        initDB("DELETE FROM item WHERE numberInStock < 1");
        closeDB();
    }

    //metoda načte všechny itemy které jsou na skladě
    @Override
    public List<Item> loadAllAvailableItems() throws SQLException{
        List<Item> items = new ArrayList<>();
        initDB("SELECT * FROM item WHERE numberInStock > 0");
        while (result.next()){
            Item item = new Item();
            item.setId(result.getInt("id"));
            item.setPartNo(result.getString("partNo"));
            item.setSerialNo(result.getString("serialNo"));
            item.setName(result.getString("name"));
            item.setDescription(result.getString("description"));
            item.setNumberInStock(result.getInt("numberInStock"));
            item.setPrice(result.getBigDecimal("price"));
            items.add(item);
        }
        closeDB();
        return items;
    }

    //uložení itemu
    @Override
    public void saveItem(Item item) throws SQLException {
        initDB("INSERT INTO item (partNo, serialNo, name, description, numberInStock, price) VALUES ('" + item.getPartNo() + "', '" + item.getSerialNo() + "', '" + item.getName() + "', '"
                + item.getDescription() + "', '" + item.getNumberInStock() + "', '" + item.getPrice() + "');" );
        closeDB();
    }

    //aktualizuje cenu itemu
    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) throws SQLException{
        initDB("UPDATE item SET price = " + newPrice + " WHERE id = " + id + ";");
        closeDB();
    }

    public void printDB() throws SQLException {
        initDB("SELECT * FROM item;");

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

    public void initDB(String sqlQuery) throws SQLException {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "root", "toor");
            statement = con.createStatement();
            statement.execute(sqlQuery);
            result = statement.getResultSet();
    }

    public void closeDB() throws SQLException {
        con.close();
        statement.close();
       // result.close();
    }

    @Override
    public String toString() {
        return "id:  " + id + " || partNo: " + partNo + " || serialNo: " + serialNo
                + " || name: " + name + " || description: " + description + " || numberInStock: " + numberInStock + " || price: " + price;
    }

}
