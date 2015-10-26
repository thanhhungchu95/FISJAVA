/**
 * Class AddWord: use to add a word to database
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary.word.add;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import ex9.dictionary.hash.HashKey;
import ex9.dictionary.word.lookup.LookupWord;
import ex9.dictionary.word.Word;

public final class AddWord {

    // Type for method addLine
    private static final int INDEX_TYPE = 0;
    private static final int MEAN_TYPE = 1;

    private static RandomAccessFile raf;
    
    public static void add(Word w) {

        /* 
         * If word is exists, use edit function 
         * Else, add index and mean to database
         */
        if (LookupWord.isWordInDatabase(w.getKey()) != null) {
            System.out.println(w.getKey() 
                               + " is exists. Please try edit word");
        } else {
            addIndex(w);

            addMean(w);
        }

    }

    /**
     * Add Index Functional
     */
    private static void addIndex(Word word) {
        addLine(word, "data/index.dat", INDEX_TYPE);
    }

    /**
     * Add Mean Functional
     */
    public static void addMean(Word word) {
        addLine(word, "data/word.dat", MEAN_TYPE);
    }

    /**
     * Add Line Functional: use to add a String to end of file in path
     */
    private static void addLine(Word word, String path, int type) {
        setStream(path);
        
        try {
            // Seek to end of file
            raf.seek(raf.length());

            String tmp = null;

            // Set tmp variable depend on type
            switch (type) {
                case INDEX_TYPE:
                    tmp = HashKey.generateIndexHashKey(word.getKey()) 
                        + " " + HashKey.generateHashKey(word.getKey());
                    break;

                case MEAN_TYPE:
                    tmp = HashKey.generateHashKey(word.getKey()) + " = " 
                            + word.getValue();
                    break;

            }

            // Write tmp variable to file
            raf.writeBytes(tmp + "\n\r");
                    
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    /* Using RandomAccessFile to read and write file */
    private static void setStream(String path) {
        try {

            raf = new RandomAccessFile(new File(path), "rw");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
