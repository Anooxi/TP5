package models;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class Product {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());

    private static int globalId = 0;

    private final int id;

    private String name;

    private Double price;

    private Date expiration;

    public Product(String name, Double price, Date expiration) {
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.id = globalId++;
    }

    public Product(int id, String name, Double price, Date expiration) {
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.id = id;
    }

    @Override
    public String toString() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("toString")
        .what("toString")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return ((((((((("Produit : [" + "id = ") + id) + ", nom = '") + name) + '\'') + ", prix = ") + price) + ", expiration = ") + expiration) + ']';
    }

    public int getId() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getId")
        .what("getId")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return id;
    }

    public String getName() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getName")
        .what("getName")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return name;
    }

    public void setName(String name) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setName")
        .what("setName")
        .who("" + name.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.name = name;
    }

    public Double getPrice() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getPrice")
        .what("getPrice")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return price;
    }

    public void setPrice(Double price) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setPrice")
        .what("setPrice")
        .who("" + price.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.price = price;
    }

    public Date getExpiration() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getExpiration")
        .what("getExpiration")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return expiration;
    }

    public void setExpiration(Date expiration) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setExpiration")
        .what("setExpiration")
        .who("" + expiration.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.expiration = expiration;
    }
}