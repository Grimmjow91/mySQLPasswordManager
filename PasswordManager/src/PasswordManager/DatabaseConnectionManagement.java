package PasswordManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
     * Variables:
     *      data - this is the object that is going to be used to make accessing the array more
     *              readable.
     *      Information - this is the array that is used to store the information from the line.
     *      read- this is the scanner that will read the file
     *      issue - this is the boolean that will indicate if there was an issue reading the file.
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
     * Variables:
     *      file - this is the connection information file
     *      fos - this is the file stream that is used to input information
     *              into the file.
     *      oss - this is the object stream that is going to be used to convert the connection information
     *            into binary.
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
             //TODO remove the references to the NotThePermaPassword
             encryptFile(file, "NotThePermaPassword");
         } catch (IOException e) {
             System.out.println("Error creating connection file: " +e.toString());
             e.printStackTrace();
         }


     }

    /**
     * This is the method that is going to handle the encrypting of the file. It relays on an encryption
     * method made by someone else.
     *
     * Variables:
     *   encryptedFile - this is the file the encrypted information is going to be stored in.
     * @param file this is the unencrypted connection information file
     * @param pass this is the key that is going to be used to encrypted and decrypt the file.
     *
     */
     protected static void encryptFile(File file, String pass) {
         File encryptedFile = new File("config.ebin");
         try {
             encryptedFile.createNewFile();
             /**
              * TODO change the way the encyption settings are.
              *     Change the Encryption and decryption salts
              */

             CryptoUtils.encrypt(new String(CryptoUtils.hashPassword(pass.toCharArray(),
                     ("testing").getBytes(StandardCharsets.UTF_8),1, 128)), file, encryptedFile);
         } catch (Exception e){
            ErrorMessage.infoBox(e.toString(), "Error");

         }
         file.delete(); //remove the old file for security
     }


    /**
     * This is going to handle the decrypted of the connection information file. It relays on an decryption
     * method made by someone else.
     * Variable:
     *      encryptedFile - this is the encrypted file that we are using.
     *      decryptedFile - this is the decrypted file where the unencrypted data will be stored.
     * @param pass this is the password that is used
     */
    protected static DatabaseConnectionInfo decryptFile(String pass){
        DatabaseConnectionInfo connection = null;
         File encryptedFile = new File("config.ebin");
         File decryptedFile = new File("config.bin");

         try{
             decryptedFile.createNewFile();
             //need to change the key into an AES key
             //TODO change the way these encyprtion settings are
             CryptoUtils.decrypt(new String(CryptoUtils.hashPassword(pass.toCharArray(), ("testing").getBytes(StandardCharsets.UTF_8),1, 128)),
                     encryptedFile,decryptedFile);
             connection = readFile(decryptedFile);


         }catch (Exception e){

         }
        decryptedFile.delete();//remove the unencrypted file for security.
         return connection;
     }

    /**
     * This reads the file to pull back the Database connection object from the file.
     * Variables:
     *      connection - this is either the database connection object or null.
     *      fis - this is the file input stream that reads in the file.
     *      ois - this is the object input stream that allows us to see the stream as an object.
     * @param file this is the file that has the binary of the database connection object.
     * @return It will return the database connection object, or null if there was an issue.
     */
     protected static DatabaseConnectionInfo readFile(File file){
         DatabaseConnectionInfo connection;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            connection = (DatabaseConnectionInfo)ois.readObject();
            ois.close();
            fis.close();

        }catch(Exception e){
            ErrorMessage.infoBox("Error reading file:" + e.toString(), "Error reading file");
            connection = null;
        }
        return connection;
     }

} //end of DatabseConnectionManagement class



/**
 * this class exists just for the sake of readablity when it comes to the reading in
 * data connection information from a file. It makes it so it used the data names instead
 * of the numbers.
 *
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


