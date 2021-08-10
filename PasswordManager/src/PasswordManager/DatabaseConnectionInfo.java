package PasswordManager;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
 */


public class DatabaseConnectionInfo {
    private String user;
    private String pass;
    private String URL;
    private String DatabaseName;

    public DatabaseConnectionInfo(String user, String pass, String IPandPort, String Database) {
        this.user = user;
        this.pass = pass;
        this.URL = "jdbc:mysql://" +IPandPort+"/";
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

}

