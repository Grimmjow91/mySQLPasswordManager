package PasswordManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
   DatabaseConnectionInfo testing =
        DatabaseConnectionManagement.decryptFile("NotThePermaPassword");

        try {
            System.out.println(testing.getDatabaseName());
            DatabaseTableCreation.Setup(testing);
        }catch (Exception e){
            System.out.println(e.toString());
        }


        Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
        primaryStage.setTitle("Password Manager");
        primaryStage.setScene(new Scene(root, 1034, 788));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);

    }
}




