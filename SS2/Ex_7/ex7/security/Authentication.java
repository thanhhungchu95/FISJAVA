/**
 *  Class Authentication: use to authentication user
 *
 *  @author Chu Thanh Hung
 */

/* Sub package security */
package ex7.security;

import java.util.ArrayList;

public final class Authentication {

    /* Initialize account list null */
    private static ArrayList<User> listAccount = null;

    /**
     *  Check account function 
     */
    public static boolean checkAccount(String username, String password) {
        /* Get account method */
        Authentication.getAccountList();

        /**
         *  If username and password valid, return true
         *  Else, return false
         */
        for (User user : listAccount) {
            if (user.getUsername().equals(username) 
                && user.getPassword().equals(password)) {
                
                return true;
            }
        }
        return false;
    }

    /**
     *  Get account list
     */
    private static void getAccountList() {

        /* Only load list of account if current is null */
        if (listAccount == null) {
            listAccount = AccountList.getAccountList();
        }
    }
}
