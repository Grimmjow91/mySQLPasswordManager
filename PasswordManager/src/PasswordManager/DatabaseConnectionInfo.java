package PasswordManager;


import java.io.Serializable;
import java.sql.*;
import java.util.Scanner;

/**
 * File:DataConnectionInfo.java
 * @author Nathan Premo
 * https://dbschema.com/jdbc-driver/MySql.html
 * https://www.javatpoint.com/example-to-connect-to-the-mysql-database
 * This file is going to be for the object that stores the connection information for the
 * database. This information in populated by reading in information from an external encryped file.
 * Variables:
 * user - this is the user name that will bve used to access the database
 * pass - this is the password that is used to access the database
 * URL this is the connection string that is used to access teh database. It will look something
 *      like "jdbc:mysql://ipaddress:3306/DatabaseName";
 * DatabaseName - this is the name of the database on the MySQL server.
 * useStatement - this is the state that adds the using databaseName String
 */


public class DatabaseConnectionInfo implements Serializable {
    private static final long serialVersionUID = 1485784584697548685L;
    private String user;
    private String pass;
    private String URL;
    private String DatabaseName;

    public DatabaseConnectionInfo(String user, String pass, String IPandPort, String Database) {
        this.user = user;
        this.pass = pass;
        this.URL = "jdbc:mysql://" +IPandPort+"/" + Database;
        this.DatabaseName = Database;

    }

    /**
     * this just returns the username
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * this just returns the password
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * this just returns the connection URL
     * @return URL
     */
    public String getURL() {
        return URL;
    }


    /**
     * This returns the name of the database
     * @return DatabaseName
     */
    public String getDatabaseName() {
        return DatabaseName;
    }



    public void excuteUpdate(String command){
        try {
            Connection connection = DriverManager.getConnection(URL,user, pass);
            Statement statement = connection.createStatement();
            statement.execute(command);
        }catch (Exception ex){
            displayIssue(ex);
            ErrorMessage.infoBox(command, "MySQL Statement");
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect(String command){
        ResultSet result = null;
        try {
            Connection connection = DriverManager.getConnection(URL,user, pass);
            Statement statement = connection.createStatement();
            result = statement.executeQuery(command);

        }catch (Exception ex){
            displayIssue(ex);
            ErrorMessage.infoBox(command, "MySQL Statement");
            ex.printStackTrace();
        }
        return result;

    }
    public void displayIssue(Exception ex){
        ErrorMessage.infoBox("Bad Sql statement/n" + ex.toString(), "SQL Error");
    }
}//end of class



