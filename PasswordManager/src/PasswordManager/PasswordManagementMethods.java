package PasswordManager;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.rmi.server.ExportException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.*;



/**
 * @author Nathan Premo
 * file: PasswordManager.PasswordImportMethods
 * This file is going to contain all the method that handle the managing of passwords.
 * including but not limited to, import, export, loading, updating, etc
 */
public class PasswordManagementMethods {

    /**
     * This method is going to handle reading the the file that is going to be used for importing.
     * The passwords must be in either a comma seperated format or a table seperated format.
     * There is JSON Support but that is for exports from programs like dashlane and I make
     * no promises that it will work for any other JSON objects.
     * if it is a JSON object it will call a method to parse it.
     * @param file this is the file we are reading in.
     * @param type this is the type of file, so either csv, or tab
     */
    public static void readFile(File file, String type){
        final String seperator;
        switch (type){
            case "json":
                parseJson(file);
                break;
            case "csv": seperator = ",";
                break;
            case "txt": seperator = "\t";
                break;
        }
        if (!type.equals("json")){

        }



    }

    /**
     * This is going to be the method that parese the json file
     * It is going to use the org.json library found here in the Needed Module folder
     * You can see how to use the library here: http://theoryapp.com/parse-json-in-java/
     * @param file this is the json file that we are parsing.
     */
    public static void parseJson(File file){
        StringBuilder json = new StringBuilder();
        try{
            //the JSON library is expecting everything to be in a string so we have to read
            //the file in as one big string to give to the library
            Scanner in = new Scanner(file);
            do{
                json.append(in.nextLine());
            }while(in.hasNext());

            LinkedList<PasswordProfile> importing = new LinkedList<PasswordProfile>();
            JSONObject obj = new JSONObject(json.toString());
            //all passwords from the program dashlane are under the "AUTHENTIFIANT" key and
            //therefore my program expects that too.
            JSONArray arr = obj.getJSONArray("AUTHENTIFIANT");
            for(int i =0; i < arr.length();i++){
                {
                    JSONObject elem = arr.getJSONObject(i); //this is to make the code shorter
                    importing.add(new PasswordProfile(elem.getString("title"),elem.getString("password"),
                            elem.getString("login"), elem.getString("email"), elem.getString("domain"),
                            elem.getString("note")));
                }
            }
            uploadPasswords(importing);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * this method is going to be what handle converting the passwords objects to binary,
     * encrypting them, and then sending them to the database.
     * @param importing
     */
    public static void uploadPasswords(LinkedList<PasswordProfile> importing){
        LinkedList<PasswordProfile> EncryptedPasswords = new LinkedList<PasswordProfile>();
        DatabaseConnectionInfo testing =
                DatabaseConnectionManagement.decryptFile("NotThePermaPassword");
        String key = "P)6@rS=/J9K$js:r";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //convert to binary
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
           byte[] encryptedImporting;
            for (PasswordProfile password: importing) {
                oos.writeObject(password);
            }
            oos.flush();
            encryptedImporting = bos.toByteArray();
            testing(encryptedImporting);
             encryptedImporting = CryptoUtils.bEncrypt("TestingPassword", encryptedImporting);
            testing(encryptedImporting);

             testing(CryptoUtils.bDecrypt("TestingPassword",encryptedImporting));
            //encryption
            System.out.println("taco");

        } catch (Exception ex){
            ErrorMessage.infoBox("Error with object convertion", "Error in upload");
            ex.printStackTrace();
        }

    }
    public static void testing(byte[] stuff){
        for (byte element: stuff
             ) {System.out.print(element);
        }
        System.out.println("");
    }


}//end of class
