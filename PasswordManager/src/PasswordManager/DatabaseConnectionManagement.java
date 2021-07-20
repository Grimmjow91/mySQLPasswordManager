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

     protected static DatabaseConnectionInfo importConnectionData(File inputFile){
        readData data = new readData();
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
            return new DatabaseConnectionInfo(information[data.user], information[data.pass],
                    information[data.URL]);
        }
        else
        {
            //if something goes wrong we are just going to return null
            return null;
        }


     }
}

/**
 * this class exits just for the sake of readablity when it comes to the reading in
 * data connection information from a file. It makes it so it used the data names instead
 * of the numbers.
 * Variables:
 *      User - this is going to be the position of the username in the array
 *      Pass - this is the position of the password in the array
 *      URL - this is the position of the URL in the array.
 */
 class readData{
    final int user = 0;
    final int pass = 1;
    final int URL = 2;
}


