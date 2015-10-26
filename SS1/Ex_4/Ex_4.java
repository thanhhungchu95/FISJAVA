/**
 * Class Ex_4
 *
 * @author Chu Thanh Hung
 *
 */

/* Import for read and write file */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_4 {
    
    /* Type of count */
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    private int n;      // Number of row
    private int m;      // Number of column

    private char[][] table;     // Table of character
    private String word;        // Word need find in table

    private int countHor;       // Count by horizontal
    private int countVer;       // Count by vertical
    private int countDia;       // Count by diagonal

    private File inputFile;     // Input file
    private File outputFile;    // Output file

    /* Constructor method */
    public Ex_4(File inputFile) {
        n = 0; 
        m = 0;
        table = null;
        word = "";
        this.inputFile = inputFile;
        outputFile = null;
    }

    public static void main(String[] args) {

        // Create instance
        Ex_4 ex_4 = new Ex_4(new File("Ex_4.input"));

        // Run startProgram method
        ex_4.startProgram();

        // Print result to file
        ex_4.printResult(new File("Ex_4.output"));
    }

    public void startProgram() {
        loadData();

        count();
    }

    private void count() {
        this.countHor = countByType(Ex_4.HORIZONTAL);
        this.countVer = countByType(Ex_4.VERTICAL);
        this.countDia = countByType(Ex_4.DIAGONAL);
    }

    private void loadData() {
        try {
            // Open Stream to read input file
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile)));
        
            /* Read row and column from input file */
            String size[] = reader.readLine().split(" ");
            n = Integer.parseInt(size[0]);
            m = Integer.parseInt(size[1]);
        
            table = new char[n][m];	// matrix of character
        
            /* read data to matrix */
            for (int i = 0; i < n; i++) {
                table[i] = reader.readLine().toCharArray();
            }
        
            /* read string need find */
            word = reader.readLine();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }


    public void printResult(File outputFile) {
        try {
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));

            /* find string and count by horizontal then print result */
            printer.println(countHor);
        
            /* find string and count by vertical then print result */
            printer.println(countVer);
        
            /* find string and count by diagonal then print result */
            printer.println(countDia);

            printer.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    /* method countWord */
    public int countByType(int type) {
        String strArray[] = null; // initialize a String array = null
        
        switch (type) {
        
        /* get data by horizontal */
        case HORIZONTAL:
            strArray = getHorizontalStringArray(); 
            break;
            
        /* get data by vertical */
        case VERTICAL: 
            strArray = getVerticalStringArray(); 
            break;
                           
        /* get data by diagonal */
        case DIAGONAL: 
            strArray = getDiagonalStringArray(); 
            break;
                           
        /* if orther type, not get data */
        default: 
            break;
        }
        
        int count = 0;  // Count word in String Array

        for (int i = 0; i < strArray.length; i++) {
            
            int r = strArray[i].length() - word.length();
            
            if (r >= 0) {
                for (int j = 0; j < r + 1; j++) {
                    /* find word normal */
                    if (strArray[i]
                            .substring(j, j + word.length())
                            .equals(word)) count++;
                    
                    /* find word reverse */
                    if (strArray[i]
                            .substring(j, j + word.length())
                            .equals(reverse(word))) count++;
                }
            }
            
            /* 
             * if length of string array element litter than length of 
             * string to find, not need find 
             */
        }
        
        return count;
    }
    
    /* get data method by horizontal, a string is a row */
    public String[] getHorizontalStringArray() {
        int row = table.length;		// row of table
        String strArray[] = new String[row];	// array for store data

        for (int i = 0; i < row; i++) {
            strArray[i] = new String(table[i]);
        }
        
        return strArray;
    }
    
    /* get data method by vertical, a string is a column */
    public String[] getVerticalStringArray(char[][] table) {
        
        int row = table.length;		        // row of table
        int column = table[0].length;	        // column of table
        String strArray[] = new String[column]; // array for store data
        
        for (int i = 0; i < column; i++) {
            
            strArray[i] = new String();
            
            for (int j = 0; j < row; j++) {
                
                if (table[j][i] != ' ') {
                    strArray[i] += table[j][i];
                }
            }
        }
        
        return strArray;
    }

    /* get data method by vertical, with no argument */
    private String[] getVerticalStringArray() {
        return getVerticalStringArray(this.table);
    }
    
    /* get data thod by diagonal, a string is a diagonal line */
    public String[] getDiagonalStringArray() {
        int row = table.length;		// row of original table
        int column = table[0].length;	// column of original table
        
        /* Half of size of array for store data */
        int halfSize = column + row - 1; 
        
        /* New table for store data */
        char newTable[][] = new char[row][halfSize];
        
        /* Up left to down right */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < halfSize; j++) {
                int origCol = j - row + i + 1;
                if (origCol < 0 || origCol >= column) {
                    newTable[i][j] = ' ';
                } else {
                    newTable[i][j] = table[i][origCol];
                }
            }
        }
        
        String ULDRStringArray[] = getVerticalStringArray(newTable); 
        
        /* Up right to down left */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < halfSize; j++) {
                int origCol = j - i;
                if (origCol < 0 || origCol >= column) {
                    newTable[i][j] = ' ';
                } else {
                    newTable[i][j] = table[i][origCol];
                }
            }
        }
        
        String URDLStringArray[] = getVerticalStringArray(newTable);
        
        /* String array for store data from new table */
        String strArray[] = new String[halfSize * 2];
        
        /* merge two array into one array */
        for (int i = 0; i < halfSize; i++) {
            strArray[i] = new String(ULDRStringArray[i]);
            strArray[i + halfSize] = new String(URDLStringArray[i]);
        }
        
        return strArray;
    }
    
    /* method for reverse a string */	
    private static String reverse(String str) {
        char s[] = str.toCharArray();
        String result = "";
        
        for (int i = s.length - 1; i >= 0; i--) {
            result += s[i];
        }
        
        return result;
    }
}
