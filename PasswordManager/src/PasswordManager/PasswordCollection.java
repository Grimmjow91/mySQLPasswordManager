package PasswordManager;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * File Name: PasswordCollection
 * @author Nathan Premo
 *  This is the the object that is going to hold
 *  all the passwords. It is using a HashMap.
 *  Variables:
 *  Passwords - this is the Hashmap of the passwords the Key is the name
 *  *  of the password and the value is the password object.
 */

public class PasswordCollection {
    private HashMap<String, PasswordProfile> Passwords;

    /**
     * This is the basic constructor to make the
     * HashMap
     */
    public PasswordCollection() {

    }

    /**
     * this is the method that is going to add a password to the HashMap
     * @param intPasswordID - this is the ID of the Password If you are importing password
     *                      to be uploaded to the database this will be null.
     * @param strName - this is the name of the password
     * @param strPassword - this is the password for the account
     * @param strLogin - this is the login if it is different than the email
     *                 if you don't have one send an empty string.
     * @param strWebsite - this is the website URL If there isn't one
     *                   just send an empty string
     * @param strNotes - this is for the note regarding the password. If
     *                 you don't have any just send an empty string.
     */
    public void addPassword(String intPasswordID, String strName, String strPassword,
                       String strLogin, String strWebsite, String strNotes) {
        Passwords.put(strName, new PasswordProfile(intPasswordID, strName, strPassword,
                strLogin, strWebsite, strNotes));
    }

    /**
     * This will search and return the password that matches
     * the name provided. If a password doesn't have that
     * name it will return null
     *
     * Variables:
     * password - this is the password object if one is found
     *    if a password object is not found it will be null
     * @param PasswordName this is the password you are
     *                     searching for
     * @return password
     *
     */
    public PasswordProfile findPassword(String PasswordName) {
         PasswordProfile password = null;
        if (Passwords.containsKey(PasswordName)) {
            password = Passwords.get(PasswordName);
        }
        return password;
    }

    /**
     * This is going to search the collection of passwords
     * and return a list of names the pattern matches. This
     * will be used as a search function.
     * 
     * Variables: 
     * PasswordNames this is an array list of the possible password names
     *     that the search pattern matches. If there are no matches it will 
     *     return null
     *  
     * @param SearchPattern this is the pattern that you are searching for
     * @return PasswordNames 
     */
    public ArrayList searchPasswords(String SearchPattern){
        ArrayList<String> PasswordNames = null;
        //this is looping over the hashmap
        for (String Name: Passwords.keySet()) {
            if(Name.contains(SearchPattern)) {
                PasswordNames.add(Name);
            }
        }
        return PasswordNames;
    }

}
