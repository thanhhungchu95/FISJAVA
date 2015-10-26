/**
 * Class Program: main class to run application
 *
 * @author Chu Thanh Hung
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /**
         * First, show main menu of functional
         */
        System.out.println("=========== String Utility ===========");
        System.out.println("1. Reverse string");
        System.out.println("2. Make first character of string to upper");
        System.out.println("3. Make first chracter of each word to upper");
        System.out.println("4. Get all upper character of string");
        System.out.println("5. Shift right all character of string");
        System.out.print("Your want: ");

        // User type their choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        String str = StringUtility.typeString();
        String result = " ";

        // Call method depend on the choice of user
        switch (choice) {
            case 1: 
                result = StringUtility.reverse(str);
                break;
            case 2:
                result = StringUtility.upperCaseFirstOne(str);
                break;
            case 3:
                result = StringUtility.upperCaseFirstAll(str);
                break;
            case 4:
                result = StringUtility.getUpperCaseString(str);
                break;
            case 5:
                result = StringUtility.shiftRightString(str);
                break;
            default: break;
        }

        System.out.println("RESULT: " + result);
    }
}
