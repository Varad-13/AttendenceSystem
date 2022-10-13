package com.miniproject.attendencesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class alertController {
    @FXML
    private TextArea text = new TextArea();
    @FXML
    private Button exit = new Button();
    private static String a;
    void launch(String a, String b) throws IOException {
        this.a = a;
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("alertBox.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
        Stage stage = new Stage();
        stage.setTitle(b);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        System.out.println(this.a);
        text.setText(this.a);
        text.setEditable(false);
    }
    public void close(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.hide();
    }
}
