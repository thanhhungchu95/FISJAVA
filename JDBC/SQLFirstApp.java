/**
 * @author  Chu Thanh Hung
 * 
 * @version 1.0
 *
 * Please visited https://github.com/thanhhungchu95/FISJAVA/JDBC
 * for more information.
 * 
 * Or, send an e-mail to thanhhungchu95@gmail.com
 */

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Class SQLFirstApp: The first application to test SQL API
 *
 * This class use MySQL JDBC Driver for demo
 */
public class SQLFirstApp {

    /**
     * HOST: Server SQL
     * DB_NAME: name of database
     * USER_NAME: SQL username
     * PASSWORD: password for SQL username
     */
	private static final String HOST = "localhost";
	private static final String DB_NAME = "training";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";

    private Connection connection;	// Connect to DB using JDBC

    /**
     * Constructor method
     *
     * Checking JDBC Driver existed ?
     */
	public SQLFirstApp() {
		try {

			/* Create new instance of JDBC Driver */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException ex) {
			
			/* Catch if not found Driver */
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			
			/* Catch if can't create instance of Driver */
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {

			/* Catch if mustn't create instance of Driver */
			System.err.println(ex.getMessage());
		}
	}

    /**
     * connectToDB method: Get connection from Class DriverManager
     *
     * Using for connect to DB
     *
     * Example use mysql
     */
    public void connectToDB() {

    	/* URL for connection */
        String url = "jdbc:mysql://" + HOST 
                     + "/" + DB_NAME 
                     + "?user=" + USER_NAME 
                     + "&password=" + PASSWORD;
        
        try {
            
    	    connection = DriverManager.getConnection(url);
    	} catch (SQLException sqlEx) {

    		/* Catch if can't connect to DB */
    		System.err.println(sqlEx.getMessage());
    	}
    }

    /**
     * Execute a SQL query and return result 
     * @param  query A query String 
     * @return       Return ResultSet as result of SQL query 
     */
	public ResultSet executeSQL(String query) {
        try {

        	/* Create statement from connection */
        	Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException sqlEx) {

        	/* Catch if can't create statement or execute query */
        	System.err.println(sqlEx.getMessage());
        }

        /* Return null if method throw an exception */
        return null;
	}

    /**
     * Test a query and print result
     * @param  args         Default cli arguments
     * @throws SQLException catch an exception but don't process
     */
	public static void main(String[] args) throws SQLException {

		/* Create new instance of class SQLFirstApp */
		SQLFirstApp app = new SQLFirstApp();

        /* Try connect to DB */
		app.connectToDB();

        /* Get result after execute a SQL query */
		ResultSet rs = app.executeSQL("SELECT `idUser`, `name` FROM `user`");

        /*
         * Print result
         *  - First, print to column
         *  - Second, print all row from result
         */
        System.out.println("idUser | name");

		while (rs.next()) {
			System.out.println("----------------");
			System.out.println("     " + rs.getInt("idUser") + " | " + rs.getString("name"));
		}
	}
}
