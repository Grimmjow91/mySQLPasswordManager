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
    private MenuItem mnuPasswordHIstory;

    @FXML
    private MenuBar mnuBar;

    @FXML
    private MenuItem mnuNewUser;

    @FXML
    private TextField txtArea;

    @FXML
    void MakeFull(ActionEvent event) {
       spPane.setDividerPositions(100,0);

    }

    @FXML
    void MakeHalf(ActionEvent event) {
        spPane.setDividerPositions(.500,0);
    }

    @FXML
    void HandlemnuImportDatabase(ActionEvent event) {
        Stage newStage = null;
        final FileChooser fc = new FileChooser();
        File file;
        fc.setTitle("Pick Database Connection Information file");
        file = fc.showOpenDialog(newStage);
        if (file!= null) {
            data = DatabaseConnectionManagement.importConnectionData(file);
        }
    }


}
