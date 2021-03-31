package com.C_Mart;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String login;
    private String password;
    private String address;
    private String phoneNo;
    private ArrayList<Menu> cart = new ArrayList<>();
    private ArrayList<String> orders = new ArrayList<>();

    public Account() {
    }

    public Account(String login, String password, String address, String phoneNo) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Account(String login, String password, String address, String phoneNo, ArrayList<Menu> cart, ArrayList<String> orders) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.phoneNo = phoneNo;
        this.cart = cart;
        this.orders = orders;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ArrayList<Menu> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Menu> cart) {
        this.cart = cart;
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<String> orders) {
        this.orders = orders;
    }
        
    @Override
    public String toString() {
        return "---------Account---------" +
                "\nLogin => " + login +
                "\nPassword => " + password +
                "\nAddress => " + address +
                "\nPhoneNo => " + phoneNo +
                "\nCart => " + cart.size() +
                "\nConfirmed Orders => " + orders.size();
    }
}
