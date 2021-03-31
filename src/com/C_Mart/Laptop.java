package com.C_Mart;

public class Laptop extends Computer{
    private int screenSize;
    private int ram;
    private int ramPrice;
    private String memory;
    private int memoryPrice;
    private int quantity = 1;
    private final int SHIPPINGFEE = 500;

    public Laptop(String company, String model, int price) {
        super(company, model, price);
    }

    public Laptop(String company, String model, int price, int screenSize, int ram, int ramPrice, String memory, int memoryPrice) {
        super(company, model, price);
        this.screenSize = screenSize;
        this.ram = ram;
        this.ramPrice = ramPrice;
        this.memory = memory;
        this.memoryPrice = memoryPrice;
    }

    public Laptop(String company, String model, int price, int screenSize, int ram, int ramPrice, String memory, int memoryPrice, int quantity) {
        super(company, model, price);
        this.screenSize = screenSize;
        this.ram = ram;
        this.ramPrice = ramPrice;
        this.memory = memory;
        this.memoryPrice = memoryPrice;
        this.quantity = quantity;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRamPrice() {
        return ramPrice;
    }

    public void setRamPrice(int ramPrice) {
        this.ramPrice = ramPrice;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(int memoryPrice) {
        this.memoryPrice = memoryPrice;
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
        return (getQuantity()*(getPrice()+getRamPrice()+getMemoryPrice()))+SHIPPINGFEE;
    }

    @Override
    public String toString() {
        return "---------Laptop---------" +
                "\nCompany => "+super.getCompany()+"\nModel => "+super.getModel()+" Screen Size => "+getScreenSize()
                +"\nPrice => " +super.getPrice()+
                " Ram => " + ram +" GB Price: "+ ramPrice +
                "\nMemory => " + memory + " MemoryPrice=" + memoryPrice +
                " \nQuantity => " + quantity +
                " \nSHIPPINGFEE=" + SHIPPINGFEE +
                "\nTotal Price => "+getTotalPrice();
    }
}
