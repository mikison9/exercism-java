public class LogLine {
    String logLine;
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        StringBuilder lvl = new StringBuilder();

        boolean adding = false;
        for (char c : this.logLine.toCharArray()) {
            if (c == '[') {
                adding = true;
            } else if (c == ']') {
                break;
            } else if (adding) {
                lvl.append(c);
            }
        }

        return LogLevel.fromString(lvl.toString());
    }

    public String getOutputForShortLog() {
        String[] split = this.logLine.split(": ");
        LogLevel level = this.getLogLevel();

        return level.level + ":" + split[1];

    }
}
