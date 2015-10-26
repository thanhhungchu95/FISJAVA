/**
 * Package Word: manage a word
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary.word;

import java.util.Scanner;

public class Word {
    private String key;         // Key of word. For example: lion, house, help ...
    private String value;       // Value of word, mean of word, ...

    /**
     * Default constructor
     */
    public Word() {
        this("", "");
    }

    /** 
     * Constructor with two arguments
     */
    public Word(String key, String value) {
        setKey(key);
        setValue(value);
    }

    /**
     * Setter for key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Setter for value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Getter for key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Getter for value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Functional for type key of word
     */
    public void typeKey() {
        System.out.print("Key: ");

        Scanner input = new Scanner(System.in);
        
        setKey(input.nextLine());
    }

    /**
     * Functional for type value of word
     */
    private void typeValue() {
        System.out.print("Value: ");

        Scanner input = new Scanner(System.in);

        setValue(input.nextLine());
    }

    /**
     * Functional for type word
     */
    public void typeWord() {
        typeKey();

        typeValue();
    }
}
