package PasswordManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class MainGUIController{
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
        File file = filePicker("Pick Database Connection Information file");
        if (file!= null) {
            data = DatabaseConnectionManagement.importConnectionData(file);
            DatabaseConnectionManagement.writeToFile(data);
        }
    }

    @FXML
    void ImportPasswords(ActionEvent event){
    File file = filePicker("Pick a file Containing Passwords");

    }

    /**
     * this is the method that is going to handle shoing the
     * @return
     */
    public File filePicker(String title){
        Stage newStage = null;
        final FileChooser fc = new FileChooser();
        File file;
        fc.setTitle(title);
        file = fc.showOpenDialog(newStage);
        return file;
    }

}
