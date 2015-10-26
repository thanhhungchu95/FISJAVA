/**
 *  Class User: using for management User data
 *
 *  @author Chu Thanh Hung
 */

package ex7.security;

public class User {

    // Protected because Login is extends from this class
    protected String username;          // Username of account
    protected String password;          // Password of account
    
    /**
     *  Default constructor with null username and null password
     */
    public User() {
        this("", "");
    }

    /**
     *  Constructor with two arguments
     */
    public User(String username, String password) {
        setUsername(username);

        setPassword(password);
    }

    /**
     *  Setter for username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *  Getter for username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     *  Setter for password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Getter for password
     */
    public String getPassword() {
        return this.password;
    }
}
