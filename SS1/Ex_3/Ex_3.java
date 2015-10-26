/**
 * Class Ex_3
 *
 * @author Chu Thanh Hung
 *
 */

/*
 * ArrayList for store data
 * Other for read input file and writer output file
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_3 {
    
    private String[] wordArray;     // Data for count method
    private ArrayList<WordCount> list;   // List result
    
    private File inputFile;         // Input file
    private File outputFile;        // Output file
    
    /*
     * Constructor method
     */
    public Ex_3(File inputFile) {
        wordArray = null;
        list = new ArrayList<WordCount>();
        
        this.inputFile = inputFile;
        outputFile = null;
    }
    
    public static void main(String[] args) {
        
        /* Create instance */
        Ex_3 ex_3 = new Ex_3(new File("Ex_3.input"));
        
        /* Call startProgram method */
        ex_3.startProgram();
        
        /* Print result to output file */
        ex_3.printResult(new File("Ex_3.output"));
    }
    
    public void startProgram() {
        loadData();
        
        countWord();
    }
    
    /* cut special character */
    private String cutPunct(String str) {
        char punct[] = {'!', '?', '.', ','};
        for (char c : punct) {
            if (str.charAt(str.length() - 1) == c) {
                str = str.substring(0, str.length() - 1);
            }
        }
        
        return str;
    }
    
    /* Load data to wordArray */
    private void loadData() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile)));
            
            ArrayList<String> listWord = new ArrayList<String>();
            
            while (true) {
                String aLine = reader.readLine();
                if (aLine == null) break;
                
                String aLineArray[] = aLine.split("\\s");
                
                for (int i = 0; i < aLineArray.length; i++) {
                    listWord.add(cutPunct(aLineArray[i].toLowerCase()));
                } 
            }
            
            wordArray = new String[listWord.size()];
                
            for (int i = 0; i < wordArray.length; i++) {
                wordArray[i] = listWord.get(i);
            }
            
            reader.close();
            
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    /* Print method to writer output file */
    public void printResult(File outputFile) {
        try {
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));
            
            for (WordCount wC : list) {
                printer.println(wC.getWord() + " " + wC.getCount());
            }
            
            printer.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    /* method countWord */
    private void countWord() {
        for (String str : wordArray) {
            boolean checkIsExist = false;
            
            /* if word exist in list, increase it count by 1 */
            for (WordCount wC : list) {
                if (wC.getWord().equals(str)) {
                    int index = list.indexOf(wC);
                    WordCount wCNew = new WordCount();
                    wCNew.setWord(wC.getWord());
                    wCNew.setCount(wC.getCount() + 1);
                    list.set(index, wCNew);
                    checkIsExist = true;
                }
            }
            
            /* if word not exist in list, add it to list */
            if (checkIsExist == false) list.add(new WordCount(str, 1));
        }
        
        /* sort list */
        sortList();
    }
    
    /* sort method */
    private void sortList() {
        WordCount wList[] = new WordCount[list.size()];	// store data
        
        /* copy data from list to array */
        for (int i = 0; i < wList.length; i++) {
            wList[i] = list.get(i);
        }
        
        /* sort array */
        for (int i = 0; i < wList.length - 1; i++) {
            for (int j = i + 1; j < wList.length; j++) {
            	
                /* sort by count, descending 
                 * if count equal, sort by word, ascending
                 */
                
                int countI = wList[i].getCount();
                int countJ = wList[j].getCount();
                String wordI = wList[i].getWord();
                String wordJ = wList[j].getWord();
                
                if ((countI < countJ) 
                    || ((countI == countJ) 
                    && (wordI.compareTo(wordJ) > 0))) {
                    
                    WordCount wCTemp = wList[i];
                    wList[i] = wList[j];
                    wList[j] = wCTemp;
                }
            }
        }
        
        /* copy array back to list */
        for (int i = 0; i < wList.length; i++) {
            list.set(i, wList[i]);
        }
    }
}

/* class for object wordCount */
class WordCount {
    private String word;	// store word
    private int count;		// store count
    
    /* default constructor */
    public WordCount() {
        this("", 0);
    }
    
    /* main constructor */
    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    /* get method for word */
    public String getWord() {
        return word;
    }
    
    /* get method for count */
    public int getCount() {
        return count;
    }
    
    /* set method for word */
    public void setWord(String word) {
        this.word = word;
    }
    
    /* set method for count */
    public void setCount(int count) {
        this.count = count;
    }
}
