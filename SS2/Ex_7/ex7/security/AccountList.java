/**
 *  Class Account: final class to load user data
 *
 *  @author Chu Thanh Hung
 */

/* Sub package security */
package ex7.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class AccountList {

    /**
     * Return list of account 
     */
    public static ArrayList<User> getAccountList() {
        try {
            /**
             *  Create and open a stream to read file
             */
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(
                    new File("ex7/resource/account"))));

            /**
             *  List to store user data
             */
            ArrayList<User> listAccount = new ArrayList<User>();

            /**
             *  Main loop
             */
            while (true) {
                /* Read a line each loop */
                String str = reader.readLine();

                /* Exit loop and return null if end of file */
                if (str == null) break;

                /* A line include username and password */
                String[] userInfor = str.split("\\s");
            
                /* Create a new instance of User */
                User user = new User(userInfor[0], userInfor[1]);

                /* Add a user to list */
                listAccount.add(user);
            }

            return listAccount;
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }

        return null;
    }
}
