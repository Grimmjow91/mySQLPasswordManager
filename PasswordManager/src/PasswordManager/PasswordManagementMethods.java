package PasswordManager;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
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
            Scanner in = new Scanner(file);
            do{
                json.append(in.nextLine());
            }while(in.hasNext());
            LinkedList<PasswordProfile> importing = new LinkedList<PasswordProfile>();
            JSONObject obj = new JSONObject(json.toString());
            JSONArray arr = obj.getJSONArray("AUTHENTIFIANT");
            for(int i =0; i < arr.length();i++){
                {
                    JSONObject elem = arr.getJSONObject(i); //this is to make the code shorter
                    importing.add(new PasswordProfile(elem.getString("title"),elem.getString("password"),
                            elem.getString("login"), elem.getString("email"), elem.getString("domain"),
                            elem.getString("note")));
                }
            }
            System.out.println("taco");
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }
}
