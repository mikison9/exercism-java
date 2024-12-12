class SqueakyClean {
    static char leetToChar(char ch) {
        return switch (ch) {
            case '0' -> 'o';
            case '4' -> 'a';
            case '3' -> 'e';
            case '1' -> 'l';
            case '7' -> 't';
            default -> ch;
        };
    }

    static String clean(String identifier) {
        StringBuilder cleaned = new StringBuilder();

        // convert spaces to underscores
        for (int i = 0; i < identifier.length(); i++) {
            if (identifier.charAt(i) == '-' && Character.isAlphabetic(identifier.charAt(i + 1))) {
                cleaned.append(Character.toUpperCase(identifier.charAt(i + 1)));
                // skip next character
                i++;
            } else if (identifier.charAt(i) == ' ') {
                cleaned.append('_');
            } else if (Character.isDigit(identifier.charAt(i))) {
                cleaned.append(leetToChar(identifier.charAt(i)));
            } else if (Character.isLetter(identifier.charAt(i))) {
                cleaned.append(identifier.charAt(i));
            }
        }

        return cleaned.toString();
    }
}
