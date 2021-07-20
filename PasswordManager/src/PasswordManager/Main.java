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
        Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1034, 788));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        System.out.println(giveText("taco"));
    }

    public static String giveText(String stuff) {
        String something= stuff.concat(" Hi");

        return something;
    }
}




