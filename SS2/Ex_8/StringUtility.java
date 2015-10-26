/**
 * Final Class: String Utility
 *
 * @author Chu Thanh Hung
 */

import java.util.Scanner;

public final class StringUtility {

    /**
     * Input: abcdef
     * Output: fedcba
     */
    public static String reverse(String str) {
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }

        return result;
    }

    /**
     * Input: abc def
     * Output: Abc def
     */
    public static String upperCaseFirstOne(String str) {
        StringBuffer result = new StringBuffer(str);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (int j = i; j < str.length(); j++) {

                    char c = str.charAt(j);
                    
                    if (c >= 'A' && c <= 'Z') {
                        break;
                    } else if (c >= 'a' && c <= 'z') {
                        result.deleteCharAt(j);
                        result.insert(j, Character.toUpperCase(c));
                        break;
                    }
                }

                break;
            }
        }

        return result.toString();
    }

    /**
     * Input: abc def
     * Output: Abc Def
     */
    public static String upperCaseFirstAll(String str) {
        String result = "";
        str += " ";

        int start = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ' ') {
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(j) == ' ') {
                        
                        /** 
                         * Each sub string is a word
                         * 
                         * Call upperCaseFirstOne to change first
                         * character of each word
                         */
                        String tmp = str.substring(start, j);

                        result += upperCaseFirstOne(tmp);

                        // set start and i to begin of next word
                        start = j;
                        i = j;

                        break;
                    }
                }
            }
        }

        return result;        
    }

    /**
     * Input: Abc dEF
     * Output: AEF
     */
    public static String getUpperCaseString(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                result += c;
            }
        }

        return result;
    }

    /**
     * Input: BCD
     * Output: CDE (B -> C, C -> D, D -> E)
     */
    public static String shiftRightString(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 'a' && c < 'z' || c >= 'A' && c < 'Z') {
                result += (char) (((int) c) + 1);
            } else {
                result += c;
            }
        }

        return result;
    }

    /** 
     * Type a string from stdin
     */
    public static String typeString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your string: ");

        String result = scanner.nextLine();

        return result;
    }
}
