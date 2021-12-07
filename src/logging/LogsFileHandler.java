package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class LogsFileHandler extends FileHandler {
    private static LogsFileHandler INSTANCE;

    static {
        try {
            INSTANCE = new LogsFileHandler();
            INSTANCE.setFormatter(new XMLFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LogsFileHandler() throws IOException, SecurityException {
        super("logs/logs.xml");
    }

    public static LogsFileHandler getInstance() {
        return INSTANCE;
    }
}
