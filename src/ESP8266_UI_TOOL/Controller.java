package ESP8266_UI_TOOL;

/**
 *   Author: Michael Stumpf
 *   Edit Date: 5/17/2016
 *
 *   controller for ESP8266 experiment
 *
 *   functions:
 *       initialize(ActionEvent event)
 *           1. determines what html text is needed and prepares it in a string
 *           2. closes the ESP8266 selection tool and opens text file view
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Controller {

    private String html = "";
    private html_string html_gen = new html_string();


    // initialize UI elements
    @FXML
    private TextField author;
    @FXML
    private TextField description;

    // selection UI elements
    @FXML
    private CheckBox Bootstrap;
    @FXML
    private CheckBox Direction;
    @FXML
    private CheckBox Selection;
    @FXML
    private CheckBox Various;
    @FXML
    private javafx.scene.control.Button done;
    @FXML
    private javafx.scene.control.Button done_initialize;

    @FXML
    public  void initialize(ActionEvent event) throws IOException {

        // edit HTML string based on user input
        html+= html_gen.overhead_gen();
        html+= html_gen.variable_description_gen(description.toString(), author.toString(), "test3");

        //close UI
        Stage stage = (Stage) done_initialize.getScene().getWindow();
        stage.close();

        //start code generation
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Selection_UI.fxml"));
        secondaryStage.setTitle("ESP8266 UI");
        secondaryStage.setScene(new Scene(root, 300, 275));
        secondaryStage.show();
    }

    public void code_generation(ActionEvent event) throws IOException{

        if(Bootstrap.isSelected()){
            html += html_gen.bootstrap_gen();
        }

        //TODO make functions for the 3 if statements
        if(Direction.isSelected()){

            html += "Discription";
        }

        if(Selection.isSelected()){
            html += "Selection";
        }

        if(Various.isSelected()){
            html += "Various";
        }

        //put string in a .c file
        Path file = Paths.get("ESP8266_UI.c");
        //TODO figure out how to get rid of asList
        List<String> lines = Arrays.asList(html);
        Files.write(file, lines, Charset.forName("UTF-8"));

        //close UI
        Stage stage = (Stage) done.getScene().getWindow();
        stage.close();
    }
}
