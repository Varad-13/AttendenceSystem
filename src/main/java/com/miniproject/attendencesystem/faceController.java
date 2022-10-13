package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class faceController {
    @FXML
    private TextField faceData = new TextField();
    static String face;
    void launch() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("verifyFace.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 150);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void close(){
        Stage stage = (Stage) faceData.getScene().getWindow();
        stage.hide();
    }
    @FXML
    void proceed() throws SQLException, IOException {
        dbUser db = new dbUser();
        if(db.authenticate(faceData.getText())) {
            close();
            face = faceData.getText();
        }
        else{
            alertController alert = new alertController();
            alert.launch("Could not match face", "Failed");
        }
    }
}
