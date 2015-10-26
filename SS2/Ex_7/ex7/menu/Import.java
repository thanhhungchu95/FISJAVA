/**
 *  Class Import: manage import to stock
 *
 *  @author Chu Thanh Hung
 */

package ex7.menu;

/* Extends from MainMenu */
public class Import extends MainMenu {
    
    @Override
    public void showMenu() {
        System.out.println();
        System.out.println("===== Import =====");
        System.out.println("1. Import an unit");
        System.out.println("2. Import box of 20 units");
        System.out.println("3. Import set of 10 units");
        System.out.println("4. Change quantity");
        System.out.println("5. Return previous menu");

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
                super.showMenu();
                break;

            default:
                showMenu();
                break;
        }
    }
}
