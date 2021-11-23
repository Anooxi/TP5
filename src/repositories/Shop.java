package repositories;

import models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.*;

// Singleton
public class Shop {
    private static final Logger logger = Logger.getLogger(Shop.class.getName());
    private ArrayList<Product> products;
    private static Shop instance = new Shop();

    private Shop() {
        Handler fh = null;
        try {
            fh = new FileHandler("logs/shop.log");
            fh.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        logger.setLevel(Level.FINEST);
        logger.setUseParentHandlers(false);
        products = new ArrayList<>();
        logger.info("Shop created");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public static Shop getInstance() {
        return instance;
    }

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

    public void addProduct(Product newProduct) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == newProduct.getId())
                .findAny();
        if(product.isPresent()){
            logger.severe("addProduct Error");
            throw new Exception("Product : " + newProduct + " already exists in the Shop");
        } else {
            this.products.add(newProduct);
            logger.info("Product added : " + newProduct);
        }
    }

    public void deleteProduct(int deleteId) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == deleteId)
                .findAny();
        if(product.isEmpty()){
            Exception ex = new Exception("Product with id : " + deleteId + " does not exists in the Shop");
            logger.log(Level.SEVERE, "deleteProduct Error", ex);
            throw ex;
        } else {
            products.remove(product.get());
            logger.info("Product deleted : " + product.get());
        }
    }

    public void updateProduct(Product updatedProduct) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == updatedProduct.getId())
                .findAny();
        if(product.isEmpty()){
            logger.severe("updateProduct Error");
            throw new Exception("Product : " + updatedProduct + " does not exists in the Shop");
        } else {
            // On peut juste modifier le Product dans l'ArrayList mais la sa peut créer des opportunités pour les logs
            deleteProduct(updatedProduct.getId());
            addProduct(updatedProduct);
            logger.info("Product updated : " + updatedProduct);
        }
    }

    public Product fetchProduct(int fetchId) throws Exception {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == fetchId)
                .findAny();
        if(product.isPresent()){
            logger.info("Product fetched : " + product.get());
            return product.get();
        } else {
            logger.severe("fetchProduct Error");
            throw new Exception("Cannot fetch product with id : " + fetchId);
        }
    }
}
