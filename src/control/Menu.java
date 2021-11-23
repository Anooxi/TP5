package control;

import logging.LogsFileHandler;
import models.Product;
import models.User;
import repositories.Shop;
import utilities.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private static final Logger logger = Logger.getLogger(Menu.class.getName());
    private final User user;
    private Shop shop = Shop.getInstance();

    public Menu(User user){
        Handler fh = null;
        Handler fhGeneral = LogsFileHandler.getInstance();
        try {
            fh = new FileHandler("logs/menu.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.addHandler(fhGeneral);
        logger.setLevel(Level.FINEST);
        logger.setUseParentHandlers(false);

        this.user = user;

        logger.log(Level.INFO,"Menu created",this);
    }

    public void menu() throws Exception {
        String string = "Enter a number :\n" +
                "1. displayProduct\n" +
                "2. fetchProduct\n" +
                "3. addProduct\n" +
                "4. deleteProduct\n" +
                "5. updateProduct\n" +
                "6. quit";
        System.out.println(string);
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1 -> {
                displayProduct();
                menu();
            }
            case 2 -> {
                fetchProduct();
                menu();
            }
            case 3 -> {
                addProduct();
                menu();
            }
            case 4 -> {
                deleteProduct();
                menu();
            }
            case 5 -> {
                updateProduct();
                menu();
            }
            case 6 -> {
                // Does nothing so it leaves
            }
            default -> {
                System.out.println("Wrong number");
                menu();
            }
        }
    }

    private void displayProduct(){
        logger.info("Displaying products");
        shop.display();
    }

    private void fetchProduct() throws Exception {
        logger.info("Fetching a product");

        int i = -1;
        try (Scanner sc = new Scanner(System.in)) {
            Utility.separator();
            System.out.println("Enter an id :");
            i = sc.nextInt();
        } catch (Exception ex){
            logger.log(Level.SEVERE, "fetchProduct Error : ", ex);
            ex.printStackTrace();
            return;
        }
        Product p = shop.fetchProduct(i);
        System.out.println(p);

        logger.info("Fetch ended with : id = " + i + ", product = " + p);
    }

    private void addProduct() throws Exception {
        logger.info("Adding a product");

        String name = null;
        Double price = null;

        try (Scanner sc = new Scanner(System.in)) {
            Utility.separator();
            System.out.println("Enter a name :");
            name = sc.next();
            System.out.println("Enter a price :");
            price = sc.nextDouble();
        } catch (Exception ex){
            logger.log(Level.SEVERE, "addProduct Error : ", ex);
            ex.printStackTrace();
            return;
        }

        Product product = new Product(name,price,new Date());
        shop.addProduct(product);
        System.out.println("Product " + product + " added");

        logger.info("Product adding ended with : " + product);
    }

    private void deleteProduct() throws Exception {
        logger.info("Deleting a product");

        int i = -1;
        try (Scanner sc = new Scanner(System.in)){
            Utility.separator();
            System.out.println("Enter an id :");
            i = sc.nextInt();
        } catch (Exception ex){
            logger.log(Level.SEVERE, "deleteProduct Error : ", ex);
            ex.printStackTrace();
            return;
        }
        Product p = shop.deleteProduct(i);
        System.out.print("Product deleted");

        logger.info("Product deleting ended with : id = " + i + ", product = " + p);
    }

    private void updateProduct() throws Exception {
        logger.info("Updating a product");

        int i = -1;
        String name = "";
        Double price = 0.0;
        try (Scanner sc = new Scanner(System.in)) {
            Utility.separator();
            System.out.println("Enter the id of the product you want modified :");
            i = sc.nextInt();
            System.out.println("Enter a name :");
            name = sc.next();
            System.out.println("Enter a price :");
            price = sc.nextDouble();
        } catch (Exception ex){
            logger.log(Level.SEVERE, "updateProduct Error : ", ex);
            ex.printStackTrace();
            return;
        }

        Product product = new Product(i,name,price,new Date());
        shop.updateProduct(product);
        System.out.println("Product " + product + " added");

        logger.info("Product updated ended with : " + product);
    }
}
