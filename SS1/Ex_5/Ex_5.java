/**
 * Class Ex_5
 *
 * @author Chu Thanh Hung
 *
 */

import java.util.ArrayList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex_5 {

    private int table[][];      // Input table
    private int n;              // Number of row
    private int m;              // Number of column

    /* List position which store position paths */
    private ArrayList<Position> posList;

    /* Queue to store list position which can walk */
    private Queue<Position> queue;

    /* Input file which has table path */
    private File inputFile;

    /* Output to print result */
    private File outputFile;

    /*
     * Constructor method
     * Initializing instance variables
     */
    public Ex_5(File inputFile) {
        table = null;
        n = 0;
        m = 0;

        posList = new ArrayList<Position>();
        queue = new Queue<Position>();

        this.inputFile = inputFile;
        outputFile = null;
    }

    public static void main(String[] args) {

        /* Create new instance of class Ex_5 */
        Ex_5 ex_5 = new Ex_5(new File("Ex_5.input"));

        /* run startProgram method to find path */
        ex_5.startProgram();

        /* Print result */
        ex_5.printPath(new File("Ex_5.output"));
    }

    public void startProgram() {
        loadData();
        
        findPath();
    }

    private void loadData() {
        try {
            // Create reader stream for inputFile
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(this.inputFile)));
        
            /** 
             * Read data from stream 
             * - Read n and m
             * - Read table
             */

            String size[] = reader.readLine().split(" ");
            n = Integer.parseInt(size[0]);
            m = Integer.parseInt(size[1]);

            // Read data and load to table
            table = new int[n][m];
            for (int i = 0; i < n; i++) {
                char aRow[] = reader.readLine().toCharArray();
                for (int j = 0; j < aRow.length; j++) {
                    table[i][j] = (int) aRow[j] - 48;
                }
            }
            
            // Close reader stream
            reader.close();
        } catch (IOException ioEx) {    
            System.err.println(ioEx.getMessage());
        }

    }

    private void findPath() {
        // Add begin position
        posList.add(new Position(0, 0));

        // Call findRealPath method
        findRealPath();

        // Add end position
        posList.add(new Position(n - 1, m - 1));
    }

    /*
     * Method findRealPath
     *  - find path between first position and last position
     *  - calculate distance to find min distance
     */
    private void findRealPath() {
        queue.offer(new Position(0, 0));

        for (!queue.isEmpty()) {
            
        }
    }

    public void printPath(File outputFile) {
        try {
            /* Open stream for writing result to output file */
            PrintWriter printer = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(outputFile)));

            // Print result from list of position
            for (int i = 0; i < posList.size(); i++) {
                
                int xPos = posList.get(i).getX() + 1;
                int yPos = posList.get(i).getY() + 1;

                printer.println(xPos + " " + yPos);
            }
            
            // Close stream
            printer.close();

        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    private boolean isPositionInTable(int i, int j) {

        /* Return true if i = [0..n] and j = [0..m] */
        return (((i >= 0) && (i < n)) && ((j >= 0) && (j < m)));
    }

    private boolean isPositionCanWalk(int i, int j) {
        return (table[i][j] == 1);
    }

    private boolean isPositionValid(int i, int j) {
        return (isPositionInTable(i, j) && isPositionCanWalk(i, j));
    }
}

class Position {
    private int x;
    private int y;

    public Position() {
        this.x = -1;
        this.y = -1;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
