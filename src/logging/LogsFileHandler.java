package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LogsFileHandler extends FileHandler {
    private static LogsFileHandler INSTANCE;

    static {
        try {
            INSTANCE = new LogsFileHandler();
            INSTANCE.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LogsFileHandler() throws IOException, SecurityException {
        super("logs/logs.log");
    }

    public static LogsFileHandler getInstance() {
        return INSTANCE;
    }
}
