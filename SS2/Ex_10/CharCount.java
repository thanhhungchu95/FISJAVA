/**
 * Class CharCount: Enumerate char in input file
 *
 * @author Chu Thanh Hung
 */

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CharCount {

    private File inputFile;     // Input file

    private File outputFile;    // Output file

    private ArrayList<Count> list;      // List to store character

    public CharCount(File inputFile) {
        this.inputFile = inputFile;

        outputFile = null;

        list = new ArrayList<Count>();
    }

    public void loadData() {
        try {

            /* Create and open stream to load data from input file */
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile)));

            while (true) {
                int i = reader.read();

                if (i != -1) {
                    if (i >= 33 && i <= 126) {
                        if (indexOfCharacterInList((char) i) == -1) {
                            Count count = new Count((char) i, 1);

                            list.add(count);
                        } else {
                            increaseCount(indexOfCharacterInList((char) i));
                        }
                    }
                } else {
                    break;
                }
            }
            
            reader.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    /**
     * Print result to output file
     */
    public void printResult(File outputFile) {
        try {

            /* Create and open stream to print result to output file */
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));

            for (Count count : list) {
                String aCharCount = String.valueOf(count.getCharacter()) + " " + String.valueOf(count.getCount());

                printer.println(aCharCount);
            }

            printer.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    /**
     * If c is in list, return it's index
     * Else, return -1
     */
    private int indexOfCharacterInList(char c) {
        for (Count count : list) {
            if (count.getCharacter() == c) {
                return list.indexOf(count);
            }
        }

        return -1;
    }

    /**
     * Increase count of a character if it in list
     */
    private void increaseCount(int i) {
        Count newCount = new Count();
                
        newCount.setCharacter(list.get(i).getCharacter());

        newCount.setCount(list.get(i).getCount() + 1);

        list.set((i), newCount);
    }

    /* Main method */
    public static void main(String[] args) {
        CharCount c = new CharCount(new File("CharCount.input"));

        c.loadData();

        c.printResult(new File("CharCount.output"));
    }
}

/**
 * Class Count: store a character and number of it
 */
class Count {
    private char character;
    private int count;

    public Count() {
        character = ' ';
        count = 0;
    }

    public Count(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
