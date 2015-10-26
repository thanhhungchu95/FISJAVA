/**
 * Class Ex_2
 *
 * @author Chu Thanh Hung
 *
 */

/* All import for read input file and writer result to output file */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_2 {
    
    private int countAdd;	            // count add operator
    private int countSubtract;          // count subtract operator
    private int countMultiple;	        // count multiple operator
    private int countDivide;		    // count divide operator

    private int n;                      // size of array
    private int[] array;                // array data
    private int[] using;                // array for mark if element is use
    private int m;                      // expected result
    
    private File inputFile;             // Input file
    private File outputFile;            // Output file

    /*
     * Constructor method
     */
    public Ex_2(File inputFile) {
        countAdd = 0;
        countSubtract = 0;
        countMultiple = 0;
        countDivide = 0;
        
        n = 0;
        array = null;
        using = null;
        m = 0;
        
        this.inputFile = inputFile;
        outputFile = null;
    }

    public static void main(String[] args) {
        
        /* Create instance */
        Ex_2 ex_2 = new Ex_2(new File("Ex_2.input"));
        
        /* Run startProgram method */
        ex_2.startProgram();
        
        /* Print result to output file */
        ex_2.printResult(new File("Ex_2.output"));
    }

    public void startProgram() {
        loadData();
        
        find(0);
    }
    
    public void printResult(File outputFile) {
        try {
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));
            
            /* Print counts */
            printer.println(this.countAdd);
            printer.println(this.countSubtract);
            printer.println(this.countMultiple);
            printer.println(this.countDivide);
            
            /* Close stream */
            printer.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    private void loadData() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile)));
            
            /* Read size of array */
            n = Integer.parseInt(reader.readLine());
            
            /* Init size for array[] and using[] */
            array = new int[n];
            using = new int[n];
            
            /* Read data for array */
            String numberArray[] = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(numberArray[i]);
                using[i] = 0;
            }
            
            /* Read expected result */
            m = Integer.parseInt(reader.readLine());
            
            reader.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    private void findAdd() {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (using[i] == 1) result += array[i];
        }

        if (result == m) this.countAdd++;
    }

    private void findSubtract() {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (using[i] == 1) result -= array[i];
        }

        if (result == m) this.countSubtract++;
    }

    private void findMultiple() {
        int result = 1;
        
        for (int i = 0; i < array.length; i++) {
            if (using[i] == 1) result *= array[i];
        }
        
        if (result == m) this.countMultiple++;

    }

    private void findDivide() {
        int result = 1;

        for (int i = 0; i < array.length; i++) {
            if (using[i] == 1) result /= array[i]; 
        }

        if (result == m) this.countDivide++;   
    }
    
    /** 
     * find method to mark the elements is use 
     * @param i index of method  
     */
    private void find(int i) {
        
        /* 
         * try each elements of use[] array with 
         * two value (1, 0) (or (true, false)) 
         */
        for (int j = 0; j < 2; j++) {
            using[i] = j;
            
            /* 
             * if n elements is mark, call count method, 
             * if not call factorial 
             */             
            if (i == array.length - 1) {
                findAdd();
                
                findSubtract();
                
                findMultiple();
                
                findDivide();
            } else {
            	find(i + 1);
            }
        }
    }
}

