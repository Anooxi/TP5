import control.Menu;
import logging.LogsFileHandler;
import models.Product;
import models.User;
import repositories.Shop;
import utilities.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = LogsFileHandler.getInstance();
        try {
            FileHandler mainFileHandler = new FileHandler("logs/main.xml");
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(mainFileHandler);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        LOGGER.setLevel(Level.FINEST);
        LOGGER.info("Initializing shop...");
        // Initialisation
        Shop shop = Shop.getInstance();
        //
        LOGGER.fine("Adding dummy products loop : ");
        for (int i = 0; i < 5; i++) {
            final Product product = new Product(Utility.generateRandomString(5),
                    Utility.generateRandomPrice(100), new Date());
            LOGGER.fine("[Lap " + i + "] Adding product " + product + ".");
            shop.addProduct(product);
        }
        LOGGER.fine("Adding products loop ended.");

        LOGGER.info("Creating Menu");
        Menu menu = new Menu(new User("Test",18,"test@email.com","salut"));
        while (menu.getFlag()){
            menu.menu();
        }
        LOGGER.info("End of Program");
    }


}
