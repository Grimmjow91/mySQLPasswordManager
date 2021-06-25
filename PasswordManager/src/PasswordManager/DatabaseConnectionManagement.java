package PasswordManager;

import java.io.File;
import java.util.Scanner;


/**
 * file: DatabaseConnectionManagement
 * @author Nathan Premo
 * This file is going to contain the methods that handle the information for the database connection
 * it will handle the importing for information, the encrypting and decrypting of information, as well as the saving
 * of an external file.
 */

 class DatabaseConnectionManagement {
    /**
     * this is method is going handle reading in the new connection information for the program, make a
     * DatabaseConnectionInfo object out of it, and then write it to to a file.
     * @param inputFile this is the file that is being imported into the system that contains the connection
     *                  information for the database in a comma sepreated formae. It will be IP address, Port Number,
     *                  username, password.
     */
     protected void importConnectionData(File inputFile){
        String[] information;
        Scanner reader = null;
        Boolean issue = false;
        try {
            reader = new Scanner(inputFile);
        }
        catch(Exception E){
            issue = true;
            ErrorMessage.infoBox("Error: invalid file provided", "Error");
         }
        if (!issue){
            information = reader.nextLine().split("\t");
        }


     }


}
