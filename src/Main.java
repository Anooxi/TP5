import models.Product;
import repositories.Shop;
import utilities.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            FileHandler fileHandler = new FileHandler("logs/main.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
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
        LOGGER.log(Level.FINE, "Product list size : ");
        shop.addProduct(
                new Product(
                        "New Product",
                        Utility.generateRandomPrice(100),
                        new Date()
                )
        );
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
        shop.deleteProduct(10);

        LOGGER.info("Shop is now closed.");
    }

}
