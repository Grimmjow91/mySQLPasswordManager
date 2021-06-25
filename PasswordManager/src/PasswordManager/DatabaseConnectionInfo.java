package PasswordManager;

/**
 * File:DataConnectionInfo.java
 * @author Nathan Premo
 * This file is going to be for the object that stores the connection information for the
 * database. This information in populated by reading in information from an external encryped file.
 * Variables:
 * user - this is the user name that will bve used to access the database
 * pass - this is the password that is used to access the database
 * URL this is the connection string that is used to access teh database. It will look something
 *      like "jdbc:mysql://ipaddress:3306/ASN";
 */


public class DatabaseConnectionInfo {
    private String user;
    private String pass;
    private String URL;

    public DatabaseConnectionInfo(String user, String pass, String URL) {
        this.user = user;
        this.pass = pass;
        this.URL = URL;
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
}
