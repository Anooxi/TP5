package models;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class User {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(User.class.getName());

    private static int globalId = 0;

    private final int id;

    private String name;

    private int age;

    private String email;

    private String password;// TODO : crypt password


    public User(String newName, int newAge, String newEmail, String newPassword) {
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
        this.name = newName;
        this.age = newAge;
        this.email = newEmail;
        this.password = newPassword;
        this.id = globalId++;
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
        return (((((((("User{" + "name='") + name) + '\'') + ", age=") + age) + ", email='") + email) + '\'') + '}';
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

    public int getAge() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getAge")
        .what("getAge")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return age;
    }

    public void setAge(int age) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setAge")
        .what("setAge")
        .who("" + age.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.age = age;
    }

    public String getEmail() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getEmail")
        .what("getEmail")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return email;
    }

    public void setEmail(String email) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setEmail")
        .what("setEmail")
        .who("" + email.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.email = email;
    }

    public String getPassword() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getPassword")
        .what("getPassword")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return password;
    }

    public void setPassword(String password) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("setPassword")
        .what("setPassword")
        .who("" + password.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        this.password = password;
    }
}