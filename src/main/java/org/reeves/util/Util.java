package org.reeves.util;

public class Util {
    /**
     * converts each word in a string to title case
     * @param str
     * @return
     */
    public static String toTitleCase(String str) {

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.isEmpty()) {
                continue;
            }

            String firstPart = word.substring(0, 1).toUpperCase();
            String rest = "";
            if (word.length() > 1) {
                rest = word.substring(1).toLowerCase();
            }
            if (!result.isEmpty()) {
                result.append(" ");
            }

            result.append(firstPart).append(rest);
        }
        return result.toString();
    }
}
