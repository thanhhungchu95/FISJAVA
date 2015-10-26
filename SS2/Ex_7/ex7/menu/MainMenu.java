/** 
 * Class MainMenu: main menu of application
 *
 * @author Chu Thanh Hung
 */

package ex7.menu;

import java.util.Scanner;

public class MainMenu {

    /* Show main menu of application */
    public void showMenu() {
        System.out.println();
        System.out.println("===== PROGRAM =====");
        System.out.println("1. Import to stock");
        System.out.println("2. Export from stock");
        System.out.println("3. Price management");
        System.out.println("4. Print the bill");
        System.out.println("5. Exit");

        executeFunctional();
    }

    private void executeFunctional() {
        System.out.print("Type your choice: ");
        int choice = getChoice() - 48;
        
        switch (choice) {
            case 1:

                /* Show Import menu */
                Import imp = new Import();
                imp.showMenu();
                break;

            case 2:

                /* Show Export menu */
                Export exp = new Export();
                exp.showMenu();
                break;

            case 3:

                /* Show Price Management menu */
                PriceManagement pr = new PriceManagement();
                pr.showMenu();
                break;

            case 4:

                /* Show Bill Print menu */
                BillPrint bill = new BillPrint();
                bill.showMenu();
                break;

            case 5:

                /* Call exit method */
                exitFunctional();
                break;

            default:
                showMenu();
                break;
        }
    }

    protected int getChoice() {
        Scanner scanner = new Scanner(System.in);
        return (int) scanner.next().charAt(0);
    }

    /**
     *  If user type Y, exit appplication
     *  Else, show main menu
     */
    private void exitFunctional() {
        System.out.print("Are you want to exit? (Y/N)");
        int choice = getChoice();

        // 89 is 'Y' in ASCII
        if (choice == 89) {
            System.exit(0);
        } else {
            MainMenu mn = new MainMenu();
            mn.showMenu();
        }
    }
}
