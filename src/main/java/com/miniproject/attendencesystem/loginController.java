package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class loginController {
    public static String face;
    @FXML
    private TextField faceData;
    dbUser db = new dbUser();

    void launch(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 150);
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
        if(db.authenticate(faceData.getText())){
            studentController student = new studentController();
            face = faceData.getText();
            close();
            student.launch();
        }
       else{
            alertController alert = new alertController();
            alert.launch("Couldn't verify face data", "Error");
        }
    }
    @FXML
    void admin() throws IOException {
        close();
        adminLoginController admin = new adminLoginController();
        admin.launch();
    }
}
