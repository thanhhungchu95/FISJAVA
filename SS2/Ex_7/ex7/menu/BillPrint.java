/**
 *  Class BillPrint
 *
 *  @author Chu Thanh Hung
 */

package ex7.menu;

/* Extends from MainMenu */
public class BillPrint extends MainMenu {
    
    @Override
    public void showMenu() {
        System.out.println();
        System.out.println("===== Bill Print =====");
        System.out.println("1. Print by quantity");
        System.out.println("2. Print by price");
        System.out.println("3. Print by quantity and price");
        System.out.println("4. Return previous menu");

        executeFunctional();
    }

    private void executeFunctional() {
        System.out.print("Type your choice: ");
        int choice = super.getChoice() - 48;

        switch (choice) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                super.showMenu();
                break;

            default:
                showMenu();
                break;
        }
    }
}
