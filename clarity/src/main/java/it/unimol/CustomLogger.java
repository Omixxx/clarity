package it.unimol;

import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger {

  private static CustomLogger customLogger;
  private static Logger logger;

  private CustomLogger() {
    logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    for (Handler handler : logger.getHandlers()) {
      handler.setFormatter(new SimpleFormatter() {
        private static final String format = "%4$s: %5$s [%1$tc]%n";

        @Override
        public synchronized String format(java.util.logging.LogRecord lr) {
          return String.format(format, new java.util.Date(lr.getMillis()),
              lr.getLevel().getLocalizedName(),
              lr.getMessage());
        }
      });
    }
  }

  public static CustomLogger getInstance() {
    if (logger == null)
      customLogger = new CustomLogger();
    return customLogger;
  }

  public Logger getLogger() {
    return logger;
  }
}
