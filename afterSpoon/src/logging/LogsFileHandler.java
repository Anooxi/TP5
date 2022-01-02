package logging;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
public class LogsFileHandler extends FileHandler {
    public static FileHandler fileHandler;

    private static final Logger LOGGER = Logger.getLogger(LogsFileHandler.class.getName());

    private static LogsFileHandler INSTANCE;

    static {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("")
        .what("")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        try {
            INSTANCE = new LogsFileHandler();
            INSTANCE.setFormatter(new XMLFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LogsFileHandler() throws IOException, SecurityException {
        super("logs/logs.xml");
        try {
        fh = new FileHandler("logs.xml");
        } catch ( Exception e ){
        e.printStackTrace();
        }
        fh.setFormatter(new XMLFormatter());
        LOGGER.addHandler(fh);
        ;
    }

    public static LogsFileHandler getInstance() {
        LPSBuilder lpsBuilder = new LPSBuilder()
        .when(new Date().toString())
        .where("getInstance")
        .what("getInstance")
        .who("")
        );
        LOGGER.info(lpsBuilder.build().toString());
        return INSTANCE;
    }
}