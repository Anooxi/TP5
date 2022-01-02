import control.Menu;
import logging.LogsFileHandler;
import models.Product;
import models.User;
import repositories.Shop;
import utilities.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Main {
    //private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        //FileHandler fileHandler = LogsFileHandler.getInstance();
        //FileHandler mainFileHandler = new FileHandler("logs/main.xml");
        //LOGGER.addHandler(fileHandler);
        //LOGGER.addHandler(mainFileHandler);
        //LOGGER.setUseParentHandlers(false);
        //LOGGER.setLevel(Level.FINEST);
        //LOGGER.info("Initializing shop...");
        // Initialisation
        Shop shop = new Shop();
        //
        //LOGGER.fine("Adding dummy products loop : ");
        for (int i = 0; i < 5; i++) {
            final Product product = new Product(Utility.generateRandomString(5),
                    Utility.generateRandomPrice(100), new Date());
            //LOGGER.fine("[Lap " + i + "] Adding product " + product + ".");
            shop.addProduct(product);
        }
        //LOGGER.fine("Adding products loop ended.");

        //LOGGER.info("Adding dummy users");
        User windowShopper = new User("windowShopper",20,"windowShopper@desgenetez.fr","salut");
        User productAdder = new User("productAdder",25,"productAdder@desgenetez.fr","salut");
        User basicUser = new User("basicUser",26,"basicUser@desgenetez.fr","salut");
        User richUser = new User("richUser",15,"richUser@reiter.fr","salut");
        User basicUser2 = new User("basicUser2",28,"basicUser2@reiter.fr","salut");
        //LOGGER.info("Dummy users added.");
        Menu menuU1 = new Menu(windowShopper,shop);
        Menu menuU2 = new Menu(productAdder,shop);
        Menu menuU3 = new Menu(richUser,shop);
        Menu menuU4 = new Menu(basicUser,shop);
        Menu menuU5 = new Menu(basicUser2,shop);

        // Product adder
        menuU2.displayProductByCode();
        menuU2.addProductByCode(new Product("U1-1",30.2,new Date())); // 5
        menuU2.addProductByCode(new Product("U1-2",200.5,new Date())); // 6
        menuU2.addProductByCode(new Product("U1-3",10.0,new Date())); // 7
        menuU2.addProductByCode(new Product("U1-4",88.9,new Date())); // 8
        menuU2.addProductByCode(new Product("U1-5",22.9,new Date())); // 9
        menuU2.addProductByCode(new Product("U1-6",10000.1,new Date())); // 10
        menuU2.addProductByCode(new Product("U1-7",21694.5,new Date())); // 11
        menuU2.displayProductByCode();

        //Window shopper
        menuU1.displayProductByCode();
        menuU1.fetchProductByCode(3);
        menuU1.fetchProductByCode(2);
        menuU1.fetchProductByCode(1);
        menuU1.displayProductByCode();
        menuU1.fetchProductByCode(5);
        menuU1.fetchProductByCode(3);
        menuU1.fetchProductByCode(4);
        menuU1.displayProductByCode();

        //Rich user
        menuU3.displayProductByCode();
        menuU3.fetchProductByCode(11);
        menuU3.fetchProductByCode(10);
        menuU3.fetchProductByCode(6);
        menuU3.fetchProductByCode(11);
        menuU3.fetchProductByCode(10);

        //Basic user 1
        menuU4.displayProductByCode();
        menuU4.fetchProductByCode(3);
        menuU4.addProductByCode(new Product("BU-1",10.2,new Date()));
        menuU4.displayProductByCode();
        menuU4.fetchProductByCode(10);

        //Basic user 2
        menuU5.displayProductByCode();
        menuU5.fetchProductByCode(3);
        menuU5.deleteProductByCode(6);
        menuU5.displayProductByCode();
        menuU5.fetchProductByCode(10);



        //LOGGER.info("Creating Menu");
        Menu menu = new Menu(new User("Test",18,"test@email.com","salut"),shop);
        while (menu.getFlag()){
            menu.menu();
        }
        //LOGGER.info("End of Program");
    }


}
