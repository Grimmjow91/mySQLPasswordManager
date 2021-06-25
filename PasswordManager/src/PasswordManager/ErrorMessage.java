package PasswordManager;

import javax.swing.JOptionPane;
/**
 * file: errorMessage.java
 * @author Nathan Premo
 * This is a class that makes a messagebox show if there is an error or something that needs to be displayed to the user
 * the cose is from a stackoverflow post https://stackoverflow.com/questions/7080205/popup-message-boxes
 */
public class ErrorMessage {
    /**
     * This method takes the message and the title and makes a message box so you can display inforamtion
     * to the user
     * @param infoMessage this is the message that you want to send to the user
     * @param titleBar this is what you want to title the message box.
     */
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
