/**
 * Package HashKey: Generate index key and crypt MD5 key for word
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashKey {
    private static char[] charList = null;      // Character of each word
    private static byte[] byteList = null;      // Cast of charList

    // Convert word to upper case, generate small size of hash key
    private static void setCharList(String key) {
        charList = key.toUpperCase().toCharArray();
    }

    /*
     *  Cast character in charList to byte type
     */
    private static void setByteList() {
        byteList = new byte[charList.length];

        for (int i = 0; i < charList.length; i++) {
            byteList[i] = (byte) charList[i];
        }
    }

    /**
     * Set data for charList and byteList
     */
    private static void setElementList(String key) {
        setCharList(key);

        setByteList();
    }

    /**
     * Functional for generate index key for word
     */
    public static String generateIndexHashKey(String key) {
        setElementList(key);

        for (char c : charList) {
            if (c < 'A' || c > 'Z') return "100";
        }

        /*
         *  Calculate index key, index key = [0..99]
         */
        int indexKey = 0;

        for (int i = 0; i < byteList.length; i++) { 
            indexKey = indexKey * 26 + (int) byteList[i];
            indexKey %= 100;
        }

        return String.valueOf(indexKey);

    }

    /**
     * Functional for generate hash key for word
     */
    public static String generateHashKey(String key) {
        setElementList(key);

        try {
            // Using MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.reset();
            
            byte[] digested = md.digest(byteList);
            String result = "";

            for (int i = 0; i < digested.length; i++) {

                // Convert each of value from byte to hex
                String currentValue = Integer.toHexString(0xff & digested[i]);

                switch (currentValue.length()) {

                    /**
                     * If result = [0..f]
                     */
                    case 1: 
                        result = result + "0" + currentValue;
                        break;

                    case 2:
                        result += currentValue;
                        break;

                    default:
                        break;
                }
            }

            return result;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
