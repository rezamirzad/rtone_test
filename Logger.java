public class Logger {
  private static Level level = Level.INFO;

  public static void debug(String message) {
    if (level.ordinal() <= Level.DEBUG.ordinal()) {
      log(Level.DEBUG, message);
    }
  }

  public static void info(String message) {
    if (level.ordinal() <= Level.INFO.ordinal()) {
      log(Level.INFO, message);
    }
  }

  public static void warn(String message) {
    if (level.ordinal() <= Level.WARN.ordinal()) {
      log(Level.WARN, message);
    }
  }

  public static void error(String message) {
    if (level.ordinal() <= Level.ERROR.ordinal()) {
      log(Level.ERROR, message);
    }
  }

  public static void setLevel(Level level) {
    Logger.level = level;
  }

  public static Level getLevel() {
    return level;
  }

  private static void log(Level level, String message) {
    System.out.println(level + " - " + message);
  }

  public enum Level {
    DEBUG,
    INFO,
    WARN,
    ERROR,
  }
}
