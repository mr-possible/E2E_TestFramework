package Utility;

import java.util.logging.Logger;

public class Add_Log {
    private static Logger Log = Logger.getLogger(Logger.class.getName());

    public static void info(String message) {
        Log.info(message + " .");
    }

    public static void warn(String message) {
        Log.warning(message + " .");
    }
}
