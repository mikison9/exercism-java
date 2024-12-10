public class LogLevels {
    
    public static String message(String logLine) {
        String[] parts = logLine.split(": ");
        StringBuilder newStr = new StringBuilder();

        for (int x = 1; x < parts.length; x++) {
            newStr.append(parts[x].stripLeading().stripTrailing());
        }

        return newStr.toString();
    }

    public static String logLevel(String logLine) {
        StringBuilder level = new StringBuilder();

        boolean adding = false;
        for (char c : logLine.toCharArray()) {
            if (c == '[') {
                adding = true;
            } else if (adding && c == ']') {
              break;
            } else if (adding) {
                level.append(c);
            }
        }

        return level.toString().toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = LogLevels.message(logLine);
        String level = LogLevels.logLevel(logLine);

        return message + " (" + level + ")";
    }
}
