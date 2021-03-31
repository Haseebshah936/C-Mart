package com.C_Mart;

public class Accessories implements Menu{
    private String name;
    private String company;
    private int price;
    private int quantity = 1;
    private final int SHIPPINGFEE = 100;

    public Accessories() {
    }

    public Accessories(String name, String company, int price) {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public Accessories(String name, String company, int price, int quantity) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSHIPPINGFEE() {
        return SHIPPINGFEE;
    }

    @Override
    public int getTotalPrice() {
        return (getQuantity()*getPrice())+SHIPPINGFEE;
    }

    @Override
    public String toString() {
        return "---------Accessories---------" +
                "\nName => " + name +"\nCompany => " + company +
                "\nPrice=" + price +
                "\nQuantity=" + quantity +
                "\nSHIPPINGFEE=" + SHIPPINGFEE +
                "\nTotal Price => "+getTotalPrice();
    }
}
