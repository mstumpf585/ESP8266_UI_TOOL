package sample;

/**
 *   Author: Michael Stumpf
 *   Edit Date: 5/14/2016
 *
 *   This program is a tool for developing webpages with bootstrap and font awesome on the
 *   ESP8266. The user will select what element they want to be included in the C code and
 *   this program will generate it in a readable format.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("initialize_UI.fxml"));
        primaryStage.setTitle("ESP8266 UI");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
