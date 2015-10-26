/**
 * Class Dictionary
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary;

import java.util.Scanner;

import ex9.dictionary.word.lookup.LookupWord;
import ex9.dictionary.word.edit.EditWord;
import ex9.dictionary.word.add.AddWord;
import ex9.dictionary.word.Word;

public class Dictionary {

    /* Show main menu of application */
    public void showMenu() {
        System.out.println();
        System.out.println("===== DICTIONARY =====");
        System.out.println("1. Add word");
        System.out.println("2. Lookup word");
        System.out.println("3. Edit word");
        System.out.println("4. Exit");

        executeFunctional();
    }

    /* Execute functional depend on user's choice */
    private void executeFunctional() {
        System.out.print("Type your choice: ");
        int choice = getChoice() - 48;
        
        switch (choice) {
            case 1:
                addWordFunctional();
                break;

            case 2:
                lookupWordFunctional();
                break;

            case 3:
                editWordFunctional();
                break;

            case 4:
                exitFunctional();
                break;

            default:
                showMenu();
                break;
        }
    }

    // User type their choice
    private int getChoice() {
        Scanner scanner = new Scanner(System.in);
        return (int) scanner.next().charAt(0);
    }

    /**
     * Functional for add a word to database
     */
    private void addWordFunctional() {
        Word w = new Word();

        // Type key and value want add
        w.typeWord();

        AddWord.add(w);

        showMenu();
    }

    /**
     * Functional for find a word in database
     */
    private void lookupWordFunctional() {
        Word w = new Word();

        // Type key need lookup
        w.typeKey();

        String result[] = LookupWord.lookup(w.getKey());

        if (result == null || result.length == 0) {
            System.out.println(w.getKey() + " was not found");
        } else {
            System.out.print("The mean of \'" + w.getKey() + "\' is: ");

            if (result.length == 1) {
                System.out.println(result[0]);
            } else {
                System.out.println();
                
                for (int i = 0; i < result.length; i++) {
                
                    System.out.println("   " + (i + 1) + ". " + result[i]);
                }
            }
        }

        // Wait user press enter
        (new Scanner(System.in)).nextLine();

        // After user press enter, show main menu
        showMenu();
    }

    /**
     * Function for edit a word in database
     */
    private void editWordFunctional() {
        Word w = new Word();

        // Type key and value want add
        w.typeWord();

        EditWord.edit(w);

        showMenu();

    }

    /**
     * Function for exit program
     */
    private void exitFunctional() {
        System.out.print("Are you want to exit? (Y/N)");
        int choice = getChoice();

        // 89 is 'Y' in ASCII
        if (choice == 89) {
            System.exit(0);
        } else {
            showMenu();
        }
    }
}
