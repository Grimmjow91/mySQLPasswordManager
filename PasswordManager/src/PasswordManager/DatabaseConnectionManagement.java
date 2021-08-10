package PasswordManager;

import java.io.*;
import java.util.Scanner;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

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
                    information[data.IPandPort], information[data.databaseName]);

        }
        else
        {
            //if something goes wrong we are just going to return null
            return null;
        }


     }

    /**
     *
     * This method is going to write the connection information to the hard drive so the program can use it later.
     * It will call the encryption method as well.
     * @param data this is the connection information object that is being written to the hard drive.
     */
     protected static void writeToFile(DatabaseConnectionInfo data){
         File file = new File("config.bin");
         try {
             FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             file.createNewFile();
             oos.writeObject(data);
             oos.flush();
             oos.close();
             fos.close();
             encryptFile(file, "NotThePermaPassword");
         } catch (IOException e) {
             System.out.println("Error creating connection file: " +e.toString());
             e.printStackTrace();
         }


     }

     protected static void encryptFile(File file, String key) {
         File encryptedFile = new File("config.ebin");

     }

}



/**
 * this class exists just for the sake of readablity when it comes to the reading in
 * data connection information from a file. It makes it so it used the data names instead
 * of the numbers.
 * Variables:
 *      User - this is going to be the position of the username in the array
 *      Pass - this is the position of the password in the array
 *      URL - this is the position of the URL in the array.
 *      databaseName - this is the position of the name of the database.
 */
 class readData{
    final int user = 0;
    final int pass = 1;
    final int IPandPort = 2;
    final int databaseName = 3;
}


