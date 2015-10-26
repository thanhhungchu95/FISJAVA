/**
 * Class EditWord: use to add a mean of existing word
 *
 * @author Chu Thanh Hung
 */

package ex9.dictionary.word.edit;

import ex9.dictionary.word.add.AddWord;
import ex9.dictionary.word.lookup.LookupWord;
import ex9.dictionary.word.Word;
import ex9.dictionary.hash.HashKey;

public class EditWord {

    public static void edit(Word w) {

        /*
         * If word is not exist in database, use add function
         * Else, call addMean method of class AddWord 
         */
        if (LookupWord.isWordInDatabase(w.getKey()) == null) {
            System.out.println(w.getKey() 
                               + " is not exists. Please try add word");
        } else {
            AddWord.addMean(w);
        }

    }
}
