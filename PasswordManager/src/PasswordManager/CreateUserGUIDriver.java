package PasswordManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateUserGUIDriver{

    @FXML
    private Text lblUserName;

    @FXML
    private Text lblVPassword;

    @FXML
    private Text lblLName;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtFName;

    @FXML
    private Button btnCancel;

    @FXML
    private Text LblPassword;

    @FXML
    private Button btnCheckUserName;

    @FXML
    private Text lblFName;

    @FXML
    private Button btnCreateUser;

    @FXML
    private TextField txtVPassword;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtPassword;

    @FXML
    void CheckUserName(ActionEvent event) {

    }

    @FXML
    void CreateUser(ActionEvent event) {

    }

    @FXML
    /**
     * This is going to add another button to close the Create User window.
     */
    void Cancel(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * This is going to be a method that is going to hide the password entry stuff so it is only shown
     * if the Username is unqiue in the database. It just sets teh visiblity of everyting to false.
     */
    public void hidePasswordStuff(){
        LblPassword.setVisible(false);
        lblVPassword.setVisible(false);
        txtPassword.setVisible(false);
        txtVPassword.setVisible(false);
        btnCreateUser.setVisible(false);
    }

    /**
     * This method is going to show the password stuff that was hidden until the username was confirmed
     * as unqiue
     */
    public void showPasswordStuff(){
        LblPassword.setVisible(true);
        lblVPassword.setVisible(true);
        txtPassword.setVisible(true);
        txtVPassword.setVisible(true);
        btnCreateUser.setVisible(true);
    }

    /**
     * This method exists to make the window for the Create users GUI.
     * It makes it modal so it can't be dismissed until you do something with it.
     */
    public void CreateWindow(){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("CreateUserGUI.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            //TODO make the user creation window not look like crap
            stage.setTitle("Create User");
            stage.setScene(new Scene(root, 332, 266));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}//end of class
