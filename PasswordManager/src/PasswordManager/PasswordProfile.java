package PasswordManager;

import java.io.Serializable;

/**
 * File Name:PasswordProfile.java
 * @author Nathan Premo
 * This is the object that will be used to store
 * the password information. It will be stored in a HashMap.
 *  Variables:
 *  intPasswordID - this is going to hold the ID number
 *      of the password obeject in the database
 *  strName - this is going to hold a string of the name of the
 *      password object
 *  strPassword - this is going to hold a string of the password
 *  strLogin - this is going to hold a string of the login if it is
 *      different from the email
 *  strWebsite - this is going to hold a string of the website
 *      URL. If there isn't one it will be an empty string
 *  strNotes - this is going to hold a string of any notes
 *      that might be saved about the password object
 */
public class PasswordProfile implements Serializable {
    private static final long serialVersionUID = 1465744587697948685L;
     private String strName;
     private String strPassword;
     private String strLogin;
     private String strWebsite;
     private String strEmail;
     private String strbNotes;

    /**
     * This is just a generic constructor to make a blank password
     * object
     */
    public PasswordProfile() {

    }

    /**
     * @author Nathan Premo
     * this is the standard constructor for the password object
     * if the note section of the login section is empty just pass
     * it a empty string
     * @param strName - this is the name of the password, it must be unqiue
     * @param strPassword - this is the password for the account
     * @param strLogin - this is the login if it isn't different than the email
     *                 if you don't have one send an empty string.
     * @param strWebsite - this is the website URL If there isn't one
     *                   just send an empty string
     * @param strNotes - this is for the note regarding the password. If
     *                 you don't have any just send an empty string.
     */
    public PasswordProfile(String strName, String strPassword, String strLogin, String strEmail, String strWebsite, String strNotes) {
        this.strEmail = strEmail;
        this.strName = strName;
        this.strPassword = strPassword;
        this.strLogin = strLogin;
        this.strWebsite = strWebsite;
        this.strbNotes = strNotes;
    }


    /**
     * This is going to return the password name
     * @return strName
     */
    public String getStrName() {
        return strName;
    }

    /**
     * This is going to set the password name
     * @param strName this is the name of the password
     */
    public void setStrName(String strName) {
        this.strName = strName;
    }

    /**
     * This is going to return the password
     * @return strPassword
     */
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * This is going to set the password
     * @param strPassword this is the password that you are going to
     *                    set the password to
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    /**
     *  this is going to return the login.
     *  The login may be an empty string
     *  if it does not have one.
     * @return strLogin
     */
    public String getStrLogin() {
        return strLogin;
    }

    /**
     * This is going to set the login for the password
     * @param strLogin this is the login you want to set
     *                 the password to
     */
    public void setStrLogin(String strLogin) {
        this.strLogin = strLogin;
    }

    /**
     * this is will return the website URL. If there isn't one
     * it will return an empty string
     * @return strWebsite
     */

    public String getStrWebsite() {
        return strWebsite;
    }

    /**
     * This is going to set the website URL
     * @param strWebsite this is the URL you want to
     *                   set the password to
     */

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    /**
     * this is the notes that are stored on the password
     * If there aren't any it will be an empty string
     * @return strNotes
     */
    public String getStrbNotes() {
        return strbNotes;
    }

    /**
     * This will add information to the notes.
     * @param strNotes this is the information you
     *                 are adding to the notes
     */
    public void setStrbNotes(String strNotes) {
        this.strbNotes = strbNotes;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

} //end of class
