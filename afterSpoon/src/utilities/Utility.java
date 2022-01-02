package utilities;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class Utility {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    public static void separator() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("separator")
        .what("separator")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        System.out.println("<---><---><--->");
    }

    public static String generateRandomString(int len) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("generateRandomString")
        .what("generateRandomString")
        .who("" + len.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));

        return sb.toString();
    }

    public static double generateRandomPrice(int precision) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("generateRandomPrice")
        .what("generateRandomPrice")
        .who("" + precision.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        double random = Math.random() * 10000;
        long round = Math.round(random);
        return ((double) (round)) / precision;
    }

    public static double generateRandomPrice() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("generateRandomPrice")
        .what("generateRandomPrice")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return generateRandomPrice(100);
    }

    public static String getMethodName(final int depth) {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getMethodName")
        .what("getMethodName")
        .who("" + depth.toString())
        );
        LOGGER.info(lpsBuilder.build().toString());
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[(ste.length - 1) - depth].getMethodName();
    }
}