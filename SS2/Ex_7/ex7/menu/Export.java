/**
 *  Class Export: manage export from stock
 *
 *  @author Chu Thanh Hung
 */

package ex7.menu;

/* Extends from MainMenu */
public class Export extends MainMenu {
    
    @Override
    public void showMenu() {
        System.out.println();
        System.out.println("===== Export =====");
        System.out.println("1. Export an unit");
        System.out.println("2. Export box of 20 units");
        System.out.println("3. Export set of 10 units");
        System.out.println("4. Change quantity");
        System.out.println("5. Check quantity");
        System.out.println("6. Return previous menu");

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
                break;

            case 5:
                break;

            case 6:
                super.showMenu();
                break;

            default:
                showMenu();
                break;
        }
    }
}
