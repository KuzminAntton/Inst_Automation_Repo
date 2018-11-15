package logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MainLogger {
    final static Logger log = LogManager.getLogger(MainLogger.class);

    public static Logger getLogger() {
        return log;
    }
}
