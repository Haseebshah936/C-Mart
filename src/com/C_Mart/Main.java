package com.C_Mart;

import java.io.*;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Account account = new Account();
    private static Menu menu;
    private static Scanner scanner = new Scanner(System.in);
    private static int Choice;
    private static int condition = 0;
    private static ArrayList<String> orders;
    private static ArrayList<Menu> cart ;

    public static void main(String[] args) {
       do {
           try {
               Login();
           } catch (NoSuchElementException e) {
               System.out.println("----------Enter a Valid Number-----------");
               scanner.nextLine();
               continue;
           }
           catch (IndexOutOfBoundsException e) {
               System.out.println("----------Enter a valid product-----------");
               continue;
           }
           catch (Exception e) {
               System.out.println("----------Enter a Valid Option-----------");
               continue;
           }
           break;
       }while (true);

        do{
            condition = Interface();
            try {
            }
            catch (NoSuchElementException e) {
                System.out.println("----------Enter a Valid Number-----------");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("----------Enter a Valid Option-----------");
            }

        }while (condition == 0);
        writeAccount();
    }
    private static int Interface() {

        int inner_condition = 0; // Menu Loop Terminator
        System.out.println("---------Welcome To C Mart---------");
        System.out.println("Enter 1: To Check Menu \nEnter 2: To View Account Details\nEnter 3: To View Cart\nEnter 0: To Exit");
        System.out.print("Enter Choice: ");
        Choice = scanner.nextInt();
        if(Choice == 1){
            do {
                try {
                    inner_condition = Menu();
                }
                catch (NoSuchElementException e) {
                    System.out.println("----------Enter a Valid Number-----------");
                    scanner.nextLine();
                    continue;
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("----------Enter a valid product-----------");
                    continue;
                }
                catch (Exception e) {
                    System.out.println("----------Enter a Valid Option-----------");
                    continue;
                }
            }while (inner_condition == 0);
        }
        else if(Choice == 2){
            try {
                Account();
            }
            catch (NoSuchElementException e) {
                System.out.println("----------Enter a Valid Number-----------");
                scanner.nextLine();
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("----------Enter a valid product-----------");
            }
            catch (Exception e) {
                System.out.println("----------Enter a Valid Option-----------");
            }
        }
        else if(Choice == 3){
            if(account.getLogin() == null){ //Checker For Account Login
                try {
                    Login();
                }
                catch (NoSuchElementException e) {
                    System.out.println("----------Enter a Valid Number-----------");
                    scanner.nextLine();
                }
                catch (Exception e) {
                    System.out.println("----------Enter a Valid Option-----------");
                }
            }
            else{
                try {
                    Cart();
                }
                catch (NoSuchElementException e) {
                    System.out.println("----------Enter a Valid Number-----------");
                    scanner.nextLine();
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("----------Enter a valid product-----------");
                }
                catch (Exception e) {
                    System.out.println("----------Enter a Valid Option-----------");

                }
            }
        }
        else{
            return -1;
        }
        scanner.nextLine();
        return 0;
    }
    private static int Menu(){  // Displaying Products for Shopping or Adding to Cart
        int counter = 0;
        int productNo = 0;
        int quantity = 1;
        cart = account.getCart();
        orders = account.getOrders();
        System.out.println("---------Menu---------");
        System.out.println("Enter 1: For Desktop Computers \nEnter 2: For Laptop Computers\nEnter 3: For Accessories\nEnter 0: To Go Back");
        System.out.print("Enter Choice: ");
        Choice = scanner.nextInt();
        if(Choice == 1){
            ArrayList<Menu> desktop = new ArrayList<>();
            desktop.add(new Desktop("Intel","Core i3 10th gen",30000,8,5000,"RTX 1060 Ti",40000,"1TB",5000));
            desktop.add(new Desktop("Intel","Core i5 10th gen",40000,8,5000,"RTX 1060 Ti",40000,"1TB",5000));
            desktop.add(new Desktop("Intel","Core i7 10th gen",60000,8,5000,"RTX 1060 Ti",40000,"1TB",5000));
            desktop.add(new Desktop("Intel","Core i9 10th gen",100000,8,5000,"RTX 1060 Ti",40000,"1TB",5000));

            for (Menu m: desktop) {
                Desktop d = (Desktop) m;
                System.out.println("        "+(++counter)+"  "+d.getCompany()+" "+d.getModel()+" Price: "+d.getTotalPrice());
            }
            System.out.println("Enter 1: Shop Now \nEnter 2: Add To Cart\nEnter 3: Check Description\nEnter 0: To Go Back To Main");
            System.out.print("Enter Choice: ");
            Choice = scanner.nextInt();
            if(Choice == 1){    // For Shop Now
                if(account.getLogin() != null){ // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                    productNo = scanner.nextInt();
                    if(productNo == 0){

                    }
                    else{

                        Desktop order = (Desktop) desktop.get(productNo-1);
                        System.out.print("Enter Quantity: ");
                        quantity = scanner.nextInt();
                        order.setQuantity(quantity);
                        System.out.println(order);
                        orders.add(order.toString());
                        account.setOrders(orders);
                        System.out.println("----------Thanks For Buying From C_Mart---------");
                        writeAccount();
                    }
                }
                else{
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
                System.out.print("<----");
                scanner.nextLine();
            }
            else if(Choice == 2){   // For adding product to Cart
                if(account.getLogin() != null) {    // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                    productNo = scanner.nextInt();
                    if (productNo == 0) {

                    } else {
                        Desktop order = (Desktop) desktop.get(productNo - 1);
                        System.out.println(order);
                        cart.add(order);
                        account.setCart(cart);
                        writeAccount();
                    }
                }
                else{
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
            }
            else if(Choice == 3){
                System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                productNo = scanner.nextInt();
                if (productNo == 0) {

                } else {
                    Desktop order = (Desktop) desktop.get(productNo - 1);
                    System.out.println(order);
                }
            }
            System.out.print("<----");
            scanner.nextLine();
        }
        else if(Choice == 2){
            ArrayList<Menu> laptop = new ArrayList<>();
            laptop.add(new Laptop("Lenovo","v310 Idea Pad",45000,16,8,5000,"1TB",5000,1));
            laptop.add(new Laptop("Lenovo","v320 Idea Pad",60000,16,8,5000,"1TB",5000,1));
            laptop.add(new Laptop("Acer","Aspire",60000,16,8,5000,"1TB",5000,1));
            laptop.add(new Laptop("MSI","Work Station WS75",531000,17,16,10000,"1TB",5000,1));

            for (Menu m : laptop) {
                Laptop d = (Laptop) m;
                System.out.println("        "+(++counter)+" "+d.getCompany()+" "+d.getModel()+" Price: "+d.getTotalPrice());
            }
            System.out.println("Enter 1: Shop Now \nEnter 2: Add To Cart\nEnter 3: Check Description\nEnter 0: To Go Back To Menu");
            System.out.print("Enter Choice: ");
            Choice = scanner.nextInt();
            if(Choice == 1){    // For Shop Now
                if(account.getLogin() != null) {    // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                    productNo = scanner.nextInt();
                    if (productNo == 0) { // For Confirmation of Order and to Specify the product No.

                    } else {

                        Laptop order = (Laptop) laptop.get(productNo - 1);
                        System.out.print("Enter Quantity: ");
                        quantity = scanner.nextInt();
                        order.setQuantity(quantity);
                        System.out.println(order);
                        orders.add(order.toString());
                        account.setOrders(orders);
                        System.out.println("----------Thanks For Buying From C_Mart---------");
                        writeAccount();
                    }
                }
                else {
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
            }
            else if(Choice == 2){   // For adding product to Cart
                if(account.getLogin() != null) {    // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                    productNo = scanner.nextInt();
                    if (productNo == 0) {

                    } else {
                        Laptop order = (Laptop) laptop.get(productNo - 1);
                        System.out.println(order);
                        cart.add(order);
                        account.setCart(cart);
                        writeAccount();
                    }
                }
                else {
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
            }
            else if(Choice == 3){
                System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                productNo = scanner.nextInt();
                if (productNo == 0) {

                } else {
                    Laptop order = (Laptop) laptop.get(productNo - 1);
                    System.out.println(order);
                }
            }
            System.out.print("<----");
            scanner.nextLine();

        }
        else if(Choice == 3){
            ArrayList<Menu> accessories = new ArrayList<>();
            accessories.add(new Accessories("Desktop Casing","Cooler Master",20000));
            accessories.add(new Accessories("Ram 16 GB","Corsair",10000));
            accessories.add(new Accessories("Power Supply 650W","Cooler Master",5000));
            accessories.add(new Accessories("CPU Cooler water Based","Cooler Master",10000));
            accessories.add(new Accessories("Processor i7 7700k ","Intel",50000));
            accessories.add(new Accessories("Processor i5 10400f ","Intel",45000));
            accessories.add(new Accessories("Processor Ryzen 5 1600f","AMD",20000));

            for (Menu m : accessories) {
                Accessories d = (Accessories) m;
                System.out.println("        "+(++counter)+" "+d.getName()+" "+d.getCompany()+" Price: "+d.getPrice());
            }
            System.out.println("Enter 1: Shop Now \nEnter 2: Add To Cart\nEnter 3: Check Description\nEnter 0: To Go Back To Menu");
            System.out.print("Enter Choice: ");
            Choice = scanner.nextInt();
            if(Choice == 1){    // For Shop Know
                if(account.getLogin() != null) {    // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To GO Back: ");
                    productNo = scanner.nextInt();
                    if (productNo == 0) { // For Confirmation of Order and to Specify the product No.

                    } else {

                        Accessories order = (Accessories) accessories.get(productNo - 1);
                        System.out.print("Enter Quantity: ");
                        quantity = scanner.nextInt();
                        order.setQuantity(quantity);
                        System.out.println(order);
                        orders.add(order.toString());
                        account.setOrders(orders);
                        System.out.println("----------Thanks For Buying From C_Mart---------");
                        writeAccount();
                    }
                }
                else {
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
            }
            else if(Choice == 2){   // For adding product to Cart
                if(account.getLogin() != null) {    // Checker For Account Existence
                    System.out.print("Enter Product No OR Enter 0 To Go Back: ");
                    productNo = scanner.nextInt();
                    if (productNo == 0) {

                    } else {
                        Accessories order = (Accessories) accessories.get(productNo - 1);
                        System.out.println(order);
                        cart.add(order);
                        account.setCart(cart);
                        writeAccount();
                    }
                }
                else {
                    scanner.nextLine();
                    try {
                        Login();
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("----------Enter a Valid Number-----------");
                        scanner.nextLine();
                    }
                    catch (Exception e) {
                        System.out.println("----------Enter a Valid Option-----------");
                    }
                }
            }
            else if(Choice == 3){
                System.out.print("Enter Product No OR Enter 0 To Go Back: ");
                productNo = scanner.nextInt();
                if (productNo == 0) {

                } else {
                    Accessories order = (Accessories) accessories.get(productNo - 1);
                    System.out.println(order);
                }
            }
            System.out.print("<----");
            scanner.nextLine();
        }
        else {
            return -1;
        }
        return 0;
    }
    private static void Account() {
        if(account.getLogin() == null){ //Checker For Account Login
           try{
               Login();
           }
           catch (NoSuchElementException e) {
               System.out.println("----------Enter a Valid Number-----------");
               scanner.nextLine();
           }
           catch (Exception e) {
               System.out.println("----------Enter a Valid Option-----------");
           }
        }
        else{
            System.out.println(account);
            System.out.println("Enter 1: To View Confirmed Order\nEnter 2: To View Cart\nEnter 0: To Go Back");
            System.out.print("Enter Choice: ");
            Choice = scanner.nextInt();
            if(Choice == 1){
                for (String s : account.getOrders()) {
                    System.out.println(s);
                }
            }
            else if(Choice == 2){
                try {
                    Cart();
                }
                catch (NoSuchElementException e) {
                    System.out.println("----------Enter a Valid Number-----------");
                    scanner.nextLine();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("----------Enter a valid product-----------");
                }
                catch (Exception e) {
                    System.out.println("----------Enter a Valid Option-----------");

                }
            }
        }
    }
    private static void Cart() {
        cart = account.getCart();
        orders = account.getOrders();
        int counter = 0;
        int productNo = 0;
        int quantity = 1;
        for (Menu m : cart) {
            if (m instanceof Desktop) {
                Desktop d = (Desktop) m;
                System.out.println("        " + (++counter) + " " + d.getCompany() + " " + d.getModel() + " Price: " + d.getTotalPrice());
            } else if (m instanceof Laptop) {
                Laptop d = (Laptop) m;
                System.out.println("        " + (++counter) + " " + d.getCompany() + " " + d.getModel() + " Price: " + d.getTotalPrice());
            } else if (m instanceof Accessories) {
                Accessories d = (Accessories) m;
                System.out.println("        " + (++counter) + " " + d.getName() + d.getCompany() +" Price: "+ d.getPrice());
            }
        }
        System.out.println("Enter 1: Shop Now\nEnter 2: To Remove Item From Cart\nEnter 0: Back Now");
        System.out.print("Enter Choice: ");
        Choice = scanner.nextInt();
        if(Choice == 1) {
            System.out.print("Enter Product No OR Enter 0 To GO Back: ");
            productNo = scanner.nextInt();
            if (productNo == 0) {   // For Confirmation of Order and to Specify the product No.

            }
            else {  // After Confirmation of order adding order to confirmed order and removing from cart

                Menu m = cart.get(productNo-1);
                cart.remove(productNo-1);
                if(m instanceof Desktop){
                    Desktop order = (Desktop) m;
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    order.setQuantity(quantity);
                    System.out.println(order);
                    orders.add(order.toString());
                }
                else if(m instanceof Laptop){
                    Laptop order = (Laptop) m;
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    order.setQuantity(quantity);
                    System.out.println(order);
                    orders.add(order.toString());
                }
                else if(m instanceof Accessories){
                    Accessories order = (Accessories) m;
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    order.setQuantity(quantity);
                    System.out.println(order);
                    orders.add(order.toString());
                }
                account.setCart(cart);
                account.setOrders(orders);
                System.out.println("----------Thanks For Buying From C_Mart---------");
                writeAccount();
            }
        }
        else if(Choice == 2){
            System.out.print("Enter Product No OR Enter 0 To GO Back: ");
            productNo = scanner.nextInt();
            if (productNo == 0) {   // For Confirmation of Order and to Specify the product No.

            }
            else {  // After Confirmation of order adding order to confirmed order and removing from cart

                Menu m = cart.get(productNo - 1);
                cart.remove(productNo - 1);
                account.setCart(cart);
                writeAccount();
            }
        }
        System.out.print("<----");
        scanner.nextLine();
    }
    private static void Login() { // Check if account exists and give the account details or create a new account
        System.out.println("Enter 1: To Login\nEnter 2: To Sign Up\nEnter 0: To Skip");
        System.out.print("Enter Choice: ");
        Choice = scanner.nextInt();
        if(Choice == 1){
            scanner.nextLine();
            int choice = 0;
            String login;
            do {
                System.out.print("Enter Email: ");
                login = scanner.nextLine();
                if(login.matches("\\w+(@)[a-zA-Z]+(\\.)(com|COM)")){
                    break;
                }
                else{
                    System.out.println("!!!!Invalid Email Format!!!! ");
                }
            }while(true);

            String Login = login.toLowerCase().replace("com", "txt"); // replacing com with txt to check if the account exists or not
            Path p = Paths.get(Login.toLowerCase());
            if(Files.exists(p)){  //IF exists than check authenticity by comparing password and reading account object from class

                try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(p))){

                    //               if(objectInputStream.available() == 0){ // Checking if the file is empty or not
                    account = (Account) objectInputStream.readObject();

                    do{
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        if(password.equals(account.getPassword())){
                            break;
                        }
                        else {
                            System.out.println("!!!!Invalid Password!!!! ");
                            System.out.println("Enter 1 : SignUp\nEnter 0: To Re-Enter Password");
                            System.out.print("Enter Choice: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if(choice==1){  // Calling sign up to create a new account
                                Signup();
                                break;
                            }
                        }

                    }while (true);
                }
                catch (EOFException e){
                    System.out.println("Incomplete Sign Up Carefully Sign Up Again\n!!!--------Ignore The Message Below--------!!!");
                }
                catch (IOException | IllegalStateException | SecurityException | TypeNotPresentException | ClassNotFoundException i){
                    System.out.println(" In Login Method");
                }
                System.out.println("-----------Login Successful-----------");
            }
            else{   // Calling sign up to create a new account if account not exists
                System.out.println("!!!!!Account Not Exist!!!!!");
                System.out.println("Enter 1 : SignUp\nEnter 0: To Go Back");
                System.out.print("Enter Choice: ");
                choice = scanner.nextInt();
                System.out.print("--->");
                scanner.nextLine();
                if(choice==1){
                    Signup();
                }
                // Else GO Back
            }

        }
        else if(Choice == 2){
            Signup();
        }

    }
    private static void Signup(){   //Create a new Account
        String login;
        scanner.nextLine();
        do {
            System.out.print("Enter Email: ");
            login = scanner.nextLine();
            if(login.matches("\\w+(@)[a-zA-Z]+(\\.)(com|COM)")){
                break;
            }
            else if(login.matches("CreatoR")){
                System.out.println("-------------Made By Haseeb-------------");
            }
            else{
                System.out.println("!!!!Invalid Email Format!!!! ");
            }
        }while(true);

        String Login = login.toLowerCase().replace("com", "txt");  // replacing com with txt to create account
        Path path = Paths.get(Login.toLowerCase());

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {       // Creating new Object
            String password;
            System.out.print("Enter Password: ");
            do{
                password = scanner.nextLine();
                if(password.trim().equals("")){
                    System.out.print("Enter Password Again: ");
                    continue;
                }
                break;
            }while(true);
            System.out.print("Enter Address: ");
            String address;
            do{
                address = scanner.nextLine();
                if(address.trim().equals("")){
                    System.out.print("Enter Address Again: ");
                    continue;
                }
                break;
            }while (true);
            System.out.print("Enter Phone Number: ");
            String phoneNumber;
            do{
                phoneNumber = scanner.nextLine();
                if(phoneNumber.trim().equals("")){
                    System.out.print("Enter Phone Number Again: ");
                    continue;
                }
                break;
            }while(true);
            account = new Account(login,password,address,phoneNumber);
            objectOutputStream.writeObject(account);
        }
        catch (IOException | SecurityException f){
            System.err.println(f+" In Sign Up Method");
        }
        System.out.println("-----------Sign Up Successful-----------");
    }
    private static void writeAccount(){    //Write Account detail in File
        String Login =  account.getLogin().toLowerCase().replace("com", "txt");  // replacing com with txt to update account
        Path path = Paths.get(Login.toLowerCase());

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))){
            objectOutputStream.writeObject(account);
        }
        catch (IOException | SecurityException e) {
            System.out.println(e+" In Write File method");
        }
    }
}

