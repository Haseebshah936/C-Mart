package com.C_Mart;

public class Desktop extends Computer {
    private int ram;
    private int ramPrice;
    private String gpu;
    private int gpuPrice;
    private String memory;
    private int memoryPrice;
    private int quantity = 1;
    private final int SHIPPINGFEE=1000;

    public Desktop(String company, String model, int price) {
        super(company, model, price);
    }

    public Desktop() {
        super("", "", 0);
    }

    public Desktop(String company, String model, int price, int ram, int ramPrice, String gpu, int gpuPrice, String memory, int memoryPrice) {
        super(company, model, price);
        this.ram = ram;
        this.ramPrice = ramPrice;
        this.gpu = gpu;
        this.gpuPrice = gpuPrice;
        this.memory = memory;
        this.memoryPrice = memoryPrice;
    }

    public Desktop(String company, String model, int price, int ram, int ramPrice, String gpu, int gpuPrice, String memory, int memoryPrice, int quantity) {
        super(company, model, price);
        this.ram = ram;
        this.ramPrice = ramPrice;
        this.gpu = gpu;
        this.gpuPrice = gpuPrice;
        this.memory = memory;
        this.memoryPrice = memoryPrice;
        this.quantity = quantity;
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

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getGpuPrice() {
        return gpuPrice;
    }

    public void setGpuPrice(int gpuPrice) {
        this.gpuPrice = gpuPrice;
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
        return (getQuantity()*(getMemoryPrice()+getPrice()+getGpuPrice()))+SHIPPINGFEE;
    }

    @Override
    public String toString() {
        return "---------Desktop---------" +
                "\nCompany => "+super.getCompany()+"\nModel => "+super.getModel()
                +"\nPrice => " +super.getPrice()+
                " Ram => " + ram +" GB Price: "+ ramPrice +
                " \nGPU => " + gpu +" GPU Price=" + gpuPrice +
                "\nMemory => " + memory + " MemoryPrice=" + memoryPrice +
                " \nQuantity => " + quantity +
                " \nSHIPPINGFEE=" + SHIPPINGFEE +
                "\nTotal Price => "+getTotalPrice();
    }
}
