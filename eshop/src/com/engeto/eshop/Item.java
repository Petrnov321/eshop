package com.engeto.eshop;

import com.mysql.cj.xdevapi.Result;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private Integer id;
    private String partNo;//číslo dílu
    private String serialNo;//sériové číslo
    private String name;//jméno
    private String description;//popis
    private Integer numberInStock;//množství na skladě
    private BigDecimal price;//cena


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


    @Override
    public String toString() {
        return "id:  " + id + " || partNo: " + partNo + " || serialNo: " + serialNo
                + " || name: " + name + " || description: " + description + " || numberInStock: " + numberInStock + " || price: " + price;
    }

}
