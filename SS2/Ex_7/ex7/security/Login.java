/**
 *  Class Login: management login 
 *
 *  @author Chu Thanh Hung
 */

package ex7.security;

import java.util.Scanner;

import ex7.menu.MainMenu;

/* Extends from user class */
public class Login extends User {
    
    public Login() {
        super();
    }

    /**
     *  Start method
     */
    public void startProgram() {
        
        /* Using for type username and password */
        Scanner scanner = new Scanner(System.in);

        int turn = 1;   // Turn = 1 because {do while} always run a loop without condition

        do {
            System.out.print("Type your username: ");
            setUsername(scanner.nextLine());

            System.out.print("Type your password: ");
            setPassword(scanner.nextLine());

            // After 3 try without valid account, wait 1 minuter
            if (turn == 3) {
                try {
                    System.out.println("You failure three times, please try again after 1 minute");

                    // Sleep in 1 minute = 60 seconds
                    Thread.sleep(60000);
                } catch (InterruptedException in) {
                    System.out.println(in.getMessage());
                }
                turn = 0;
            } else if (Authentication.checkAccount(getUsername(), 
                                                   getPassword())) {

                // If account valid, show menu of application

                System.out.println("Welcome!!!");

                MainMenu mn = new MainMenu();
                mn.showMenu();
            } else {
                System.out.println("Failure!!! Try again");
                turn++;
            }

        } while (true);
    }
}
