/**
 * Class LookupWord: use to find a word in database
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary.word.lookup;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import ex9.dictionary.hash.HashKey;

public final class LookupWord {

    private static String indexKey = null;      // Store index key of word

    private static String lookupKey = null;     // Store MD5 crypt key of word

    /* 
     * Main lookup function
     * Return array of mean if found
     * Else, return null
     */
    public static String[] lookup(String key) {

        ArrayList<String> meanList = new ArrayList<String>();

        try {
            String tkey = isWordInDatabase(key);
            
            /* 
             * If word is in index file    
             * Open file word.dat in data folder 
             * and find all of it mean
             */
            if (tkey != null) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream("data/word.dat")));
                
                while (true) {
                    String str = reader.readLine();
                    if (str == null) break;

                    String dataGroup[] = str.split("\\s");
                    if (dataGroup[0].equals(lookupKey)) {

                        // 35 because before mean of word include:
                        // 1. 32 character of MD5 crypt key
                        // 2. 2 'space' character
                        // 3. 1 '=' chracter
                        meanList.add(str.substring(35, str.length()));
                    }
                }
            }


            String result[] = new String[meanList.size()];

            for (int i = 0; i < meanList.size(); i++) {
                result[i] = meanList.get(i);
            }

            return result;
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }

        return null;

    }

    private static void setHash(String key) {
        setIndex(key);

        setLookupKey(key);
    }

    private static void setIndex(String key) {
        indexKey = HashKey.generateIndexHashKey(key);
    }

    private static void setLookupKey(String key) {
        lookupKey = HashKey.generateHashKey(key);
    }

    /*
     * Return index key if found
     * Else, return null
     */
    public static String isWordInDatabase(String key) {
        setHash(key.toUpperCase());

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream("data/index.dat")));

            while (true) {
                String str = reader.readLine();
                if (str == null) break;

                String keyGroup[] = str.split("\\s");
                
                // keyGroup[0] is index key, keyGroup[1] is MD5 crypt key
                if (keyGroup[0].equals(indexKey) && keyGroup[1].equals(lookupKey)) {
                    return keyGroup[0];
                }
            }
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }

        return null;
    }
}
