package PasswordManager;

import javafx.event.ActionEvent;
import javafx.scene.control.SplitPane;

/**
 * @author Nathan Premo
 * File: PasswordManager.GUIControllerLibrary
 * This file is going to make it so all of the common actions between admin GUI screen
 * and the standard user GUI screen
 */

public class GUIControllerLibrary {
    /**
     * This is the method that actually moves the split pane. It will move it to the left at the middle of the window.
     * It is in it own file to make sure I can use it on
     * more than one Scene.
     * @param event this is the information that JavaFX sends
     * @param spPane this is the spiltPane in the GUI
     */
    public static void MakeHalf(ActionEvent event, SplitPane spPane) {spPane.setDividerPositions(.500,0);}

    /**
     * This is the methocd that actually moves the spiltpane. It moves it all the way to the right to hide the
     * password information pane. It is in it own file so I can use it on more than one Scene
     * @param event this is the information that JavaFX sends.
     * @param spPane this is the spilt pane that is actually moved.
     */
    public static void MakeFull(ActionEvent event, SplitPane spPane){spPane.setDividerPositions(100,0);}

}//end of class
