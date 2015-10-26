/**
 * Class Ex_1
 *
 * @author Chu Thanh Hung
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_1 {
    private int n;              // Size of array
    private int array[];        // Array of Integer
    private File inputFile;     // Input file
    private File outputFile;    // Output file

    /* Constructor method */
    public Ex_1(File inputFile) {
        n = 0;
        array = null;
        this.inputFile = inputFile;
        outputFile = null;
    }

    public static void main(String[] args) {
        
        // Create instance 
        Ex_1 ex_1 = new Ex_1(new File("Ex_1.input"));
        
        // Start program
        ex_1.startProgram();

        /* call method printResult */
        ex_1.printResult(new File("Ex_1.output"));
    }

    public void startProgram() {
        // Load data from input file to array
        loadData();

        sortData();
    }
    
    private void loadData() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile)));

            this.n = Integer.parseInt(reader.readLine());

            // Create array with n empty elements
            array = new int[n];

            String numberArray[] = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(numberArray[i]);
            }

            reader.close();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    /* Print result to output file */
    public void printResult(File outputFile) {
        try {
            /* Create and open printer for write to output file */
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));

            /* Print max and min number */
            printer.println(array[n - 1] + " " + array[0]);

            /* Print array by ascending */
            for (int i = 0; i < n; i++) {
                printer.print(array[i] + " ");
            }

            /* Print separate line */
            printer.println();

            /* Print array by descending */
            for (int i = n - 1; i >= 0; i--) {
                printer.print(array[i] + " ");
            }

            // Close stream
            printer.close();

        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    /* sort increase (a to z) */
    private void sortData() {
        
        /* array has 1 or litter not need sort */
        if (array.length <= 1) return;
        
        /* selection sort */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
            
            	/* if element i > element j then swap */
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
