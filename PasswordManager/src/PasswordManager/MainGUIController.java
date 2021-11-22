package PasswordManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class MainGUIController {
    DatabaseConnectionInfo data;
    @FXML
    private MenuItem mnuPasswordGen;

    @FXML
    private MenuItem mnuImportPasswords;

    @FXML
    private MenuItem mnuImportDatabase;


    @FXML
    private MenuItem mnuSettings;

    @FXML
    private MenuItem mnuNewGroup;

    @FXML
    private MenuItem mnuExportPasswords;

    @FXML
    private SplitPane spPane;

    @FXML
    private MenuItem mnuPasswordMan;

    @FXML
    private Button btnHalf;

    @FXML
    private MenuItem mnuNewPassword;

    @FXML
    private Menu mnuTools;

    @FXML
    protected Button btnFull;


    @FXML
    private Label lblHello;

    @FXML
    private MenuItem mnuQuit;

    @FXML
    private MenuItem mnuGroupMan;

    @FXML
    private MenuItem mnuUserMan;

    @FXML
    private MenuItem mnuImportUsers;

    @FXML
    private MenuItem mnuPasswordHistory;

    @FXML
    private MenuBar mnuBar;

    @FXML
    private MenuItem mnuNewUser;

    @FXML
    private TextField txtArea;

    /**
     * This method is going to make the password selection pane full to hind
     * the password information pane.
     * @param event this is the event information that javaFx sends.
     */
    @FXML
    void MakeFull(ActionEvent event) {GUIControllerLibrary.MakeFull(event, spPane);}

    /**
     * this is the method that is going to cut the window in half to show the password information
     * It calls another method that does the work.
     * @param event this is the event information that javaFx sends.
     */
    @FXML
    void MakeHalf(ActionEvent event) {GUIControllerLibrary.MakeHalf(event, spPane);}

    /**
     * This is going to handle importing the connection information for the database.
     * @param event this is the event information that JavaFX sends.
     */
    @FXML
    void HandlemnuImportDatabase(ActionEvent event) {
        File file = filePicker("Pick Database Connection Information file","tab");
        if (file!= null) {
            data = DatabaseConnectionManagement.importConnectionData(file);
            DatabaseConnectionManagement.writeToFile(data);
        }
    }

    /**
     * This is going to start the importing of passwords, the passwords have to be in a
     * command seperated file or a tab delimited file or it will fail.
     * Variables:
     *      file - this is the file that we are trying to import data from
     *      extention - this is the files exention so we know what type of file it is.
     * @param event this is the event information that JavaFX sends.
     */
    @FXML
    void ImportPasswords(ActionEvent event){
        File file = filePicker("Pick a file Containing Passwords","tab/csv");
        String extention;
        if (file!=null){
            extention = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")+1);
            System.out.println(extention);
            PasswordManagementMethods.readFile(file, extention);

        }
    }

    /**
     * this is the method that is going to handle choosing the file
     * @return the file
     */
    public File filePicker(String title, String type){
        //TODO need to work a way to delete the import file in for added security.
        Stage newStage = null;
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter;
        if(type.equals("tab/csv")){
            extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt) | CSV Files (*.csv) | JSON Files (*.json)", "*.txt" , "*.csv", "*.json");
        } else{
            extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        }
        fc.getExtensionFilters().add(extensionFilter);
        File file;
        fc.setTitle(title);
        file = fc.showOpenDialog(newStage);
        return file;
    }

    /**
     * This method is going to create the window for the user creation.
     * @param event this is the event information that JavaFX sends.
     */
    @FXML
    void CreateUser(ActionEvent event) {
        CreateUserGUIDriver UserCreation = new CreateUserGUIDriver();
        UserCreation.CreateWindow();
        UserCreation.hidePasswordStuff(); //hide all the password stuff first.
    }
}
