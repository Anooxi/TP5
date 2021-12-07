package control;

import logging.LPSBuilder;
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
    private final Logger logger = Logger.getLogger(Menu.class.getName());
    private final User user;
    private Shop shop = Shop.getInstance();
    private Scanner scanner;
    private boolean flag = true;

    public boolean getFlag(){return flag;}

    public Menu(User user){
        Handler fh = null;
        Handler fhGeneral = LogsFileHandler.getInstance();
        try {
            fh = new FileHandler("logs/menu_"+ user.getName() +".xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.addHandler(fhGeneral);
        logger.setLevel(Level.FINEST);
        this.user = user;
    }

    public void menu() throws Exception {
        this.scanner  = new Scanner(System.in);
        String string = "Enter a number :\n" +
                "1. displayProduct\n" +
                "2. fetchProduct\n" +
                "3. addProduct\n" +
                "4. deleteProduct\n" +
                "5. updateProduct\n" +
                "6. quit";
        System.out.println(string);;
        int i = scanner.nextInt();
        switch (i) {
            case 1 -> {
                displayProduct();
            }
            case 2 -> {
                fetchProduct();
            }
            case 3 -> {
                addProduct();
            }
            case 4 -> {
                deleteProduct();
            }
            case 5 -> {
                updateProduct();
            }
            case 6 -> {
                // Does nothing so it leaves
                this.flag = false;
            }
            default -> {
                System.out.println("Wrong number");
            }
        }
    }

    public void displayProductByCode(){
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.displayProductByCode")
                .who(this.user)
                .what("Displaying products");

        logger.info(lpsBuilder.build().toString());
    }

    private void displayProduct(){
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.displayProduct")
                .who(this.user)
                .what("Displaying products");
        logger.info(lpsBuilder.build().toString());

        shop.display();
    }

    public Product fetchProductByCode(int id) throws Exception{
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.fetchProductByCode")
                .who(this.user)
                .what("fetching product " + id);
        logger.info(lpsBuilder.build().toString());
        Product p;
        try {
            p = shop.fetchProduct(id);
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("fetch Product By Code " + id + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
            ex.printStackTrace();
            return null;
        }
        return p;
    }

    private void fetchProduct() throws Exception {
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.fetchProduct")
                .who(this.user)
                .what("fetching product");
        logger.info(lpsBuilder.build().toString());

        int i = -1;
        try {
            Utility.separator();
            System.out.println("Enter an id :");
            i = scanner.nextInt();
        } catch (Exception ex){
            lpsBuilder.when(new Date().toString()).what("fetch Product " + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
            ex.printStackTrace();
            return;
        }
        Product p = shop.fetchProduct(i);
        System.out.println(p);
    }

    public void addProductByCode(Product newProduct) throws Exception{
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.addProductByCode")
                .who(this.user)
                .what("adding product by code : " + newProduct);
        logger.info(lpsBuilder.build().toString());

        try {
            shop.addProduct(newProduct);
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("add Product By Code" + newProduct + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
        }
    }

    private void addProduct() throws Exception {
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.addProduct")
                .who(this.user)
                .what("adding product");
        logger.info(lpsBuilder.build().toString());

        String name = null;
        Double price = null;

        try  {
            Utility.separator();
            System.out.println("Enter a name :");
            name = scanner.next();
            System.out.println("Enter a price :");
            price = scanner.nextDouble();
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("add Product" + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
            ex.printStackTrace();
            return;
        }

        Product product = new Product(name,price,new Date());
        shop.addProduct(product);
        System.out.println("Product " + product + " added");
    }

    public void deleteProductByCode(int id) throws Exception {
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.deleteProductByCode")
                .who(this.user)
                .what("delete product by code : " + id);
        logger.info(lpsBuilder.build().toString());

        try {
            shop.deleteProduct(id);
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("delete Product" + id + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
        }

    }

    private void deleteProduct() throws Exception {
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.deleteProduct")
                .who(this.user)
                .what("delete product");
        logger.info(lpsBuilder.build().toString());

        int i = -1;
        try {
            Utility.separator();
            System.out.println("Enter an id :");
            i = scanner.nextInt();
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("delete Product" + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
            ex.printStackTrace();
            return;
        }
        Product p = shop.deleteProduct(i);
        System.out.println("Product deleted");
    }

    public void updateProductByCode(Product updatedProduct) throws Exception{
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.updateProductByCode")
                .who(this.user)
                .what("update product by code " + updatedProduct);
        logger.info(lpsBuilder.build().toString());

        shop.updateProduct(updatedProduct);

    }

    private void updateProduct() throws Exception {
        LPSBuilder lpsBuilder = new LPSBuilder()
                .when(new Date().toString())
                .where("menu.updateProduct")
                .who(this.user)
                .what("update product");
        logger.info(lpsBuilder.build().toString());

        int i = -1;
        String name = "";
        Double price = 0.0;
        try {
            Utility.separator();
            System.out.println("Enter the id of the product you want modified :");
            i = scanner.nextInt();
            System.out.println("Enter a name :");
            name = scanner.next();
            System.out.println("Enter a price :");
            price = scanner.nextDouble();
        } catch (Exception ex){
            lpsBuilder
                    .when(new Date().toString())
                    .what("update Product" + " error : " + ex);
            logger.severe(lpsBuilder.build().toString());
            ex.printStackTrace();
            return;
        }

        Product product = new Product(i,name,price,new Date());
        shop.updateProduct(product);
        System.out.println("Product " + product + " added");
    }
}
