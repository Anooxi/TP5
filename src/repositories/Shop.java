package repositories;

import logging.LogsFileHandler;
import models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.*;

public class Shop {
    private static final Logger logger = Logger.getLogger(Shop.class.getName());
    private ArrayList<Product> products;
    private static Shop instance = new Shop();

    private Shop() {
        Handler fh = null;
        Handler fhGeneral = LogsFileHandler.getInstance();
        try {
            fh = new FileHandler("logs/shop.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.addHandler(fhGeneral);
        logger.setLevel(Level.FINEST);
        logger.setUseParentHandlers(false);

        products = new ArrayList<>();

        logger.info("Shop created");
    }

    /**
     *
     * @return ArrayList of products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    public static Shop getInstance() {
        return instance;
    }

    /**
     * Displays all of the products
     */
    public void display(){
        for (Product p : products) {
            System.out.println(p);
        }
        logger.info("Shop displayed");
    }

    @Override
    public String toString() {
        return products.toString();
    }

    /**
     * @param newProduct new Product to be added
     * @throws Exception Throws an exception if the newProduct already exists
     */
    public void addProduct(Product newProduct) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == newProduct.getId())
                .findAny();
        if(product.isPresent()){
            Exception ex = new Exception("Product : " + newProduct + " already exists in the Shop");
            logger.log(Level.SEVERE, "addProduct Error", ex);
            throw ex;
        } else {
            this.products.add(newProduct);
            logger.info("Product added : " + newProduct);
        }
    }

    /**
     * @param deleteId id of the product to be deleted
     * @throws Exception throws an exception if the product does not exist
     */
    public Product deleteProduct(int deleteId) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == deleteId)
                .findAny();
        if(product.isEmpty()){
            Exception ex = new Exception("Product with id : " + deleteId + " does not exists in the Shop");
            logger.log(Level.SEVERE, "deleteProduct Error", ex);
            throw ex;
        } else {
            Product p = product.get();
            products.remove(p);
            logger.info("Product deleted : " + product.get());
            return p;
        }
    }

    /**
     * @param updatedProduct Product that need to be updated
     * @throws Exception throws exception if the product is not found
     */
    public void updateProduct(Product updatedProduct) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == updatedProduct.getId())
                .findAny();
        if(product.isEmpty()){
            Exception ex = new Exception("Product : " + updatedProduct + " does not exists in the Shop");
            logger.log(Level.SEVERE, "updateProduct Error", ex);
            throw ex;
        } else {
            // On peut juste modifier le Product dans l'ArrayList mais la sa peut créer des opportunités pour les logs
            deleteProduct(updatedProduct.getId());
            addProduct(updatedProduct);
            logger.info("Product updated : " + updatedProduct);
        }
    }

    /**
     * @param fetchId id of the product to be returned
     * @return the product found
     * @throws Exception throws an exception if the product can't be found
     */
    public Product fetchProduct(int fetchId) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == fetchId)
                .findAny();
        if(product.isPresent()){
            logger.info("Product fetched : " + product.get());
            return product.get();
        } else {
            Exception ex = new Exception("Cannot fetch product with id : " + fetchId);
            logger.log(Level.SEVERE, "updateProduct Error", ex);
            throw ex;
        }
    }
}
