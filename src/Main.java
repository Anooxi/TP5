import models.Product;
import repositories.Shop;
import utilities.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            FileHandler fileHandler = new FileHandler("logs/logs.log");
            fileHandler.setFormatter(new SimpleFormatter());
            FileHandler mainFileHandler = new FileHandler("logs/main.xml");
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(mainFileHandler);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        LOGGER.setLevel(Level.FINEST);
        LOGGER.info("Initializing shop...");
        // Initialisation
        Shop shop = Shop.getInstance();
        LOGGER.fine("Adding products loop : ");
        for (int i = 0; i < 5; i++) {
            final Product product = new Product(Utility.generateRandomString(5),
                    Utility.generateRandomPrice(100), new Date());
            LOGGER.fine("[Lap " + i + "] Adding product " + product + ".");
            shop.addProduct(product);
        }
        LOGGER.fine("Adding products loop ended.");
        shop.display();
        Utility.separator();
        // Ajout de produit
        LOGGER.fine("Testing product adding");
        LOGGER.log(Level.FINE, "[Before] Product list size : " + shop.getProducts().size());
        shop.addProduct(
                new Product(
                        "New Product",
                        Utility.generateRandomPrice(100),
                        new Date()
                )
        );
        LOGGER.log(Level.FINE, "[After] Product list size : " + shop.getProducts().size());
        shop.display();
        Utility.separator();
        // Suppression de produit
        shop.deleteProduct(3);
        shop.display();
        Utility.separator();
        //Update de produit
        shop.updateProduct(
                new Product(
                        4,
                        "Updated Product",
                        Utility.generateRandomPrice(),
                        new Date()
                )
        );
        shop.display();
        Utility.separator();
        // Fetch de produit
        System.out.println(shop.fetchProduct(4));
        Utility.separator();
        // Erreur
        LOGGER.log(Level.FINE, "Try deleting an unknown product...");
        LOGGER.log(Level.FINE, "[Before] Product list size : " + shop.getProducts().size());
        shop.deleteProduct(10);
        LOGGER.log(Level.FINE, "[After] Product list size : " + shop.getProducts().size());

        LOGGER.info("Shop is now closed.");
    }

}
