package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class addAdminController {
    @FXML
    private PasswordField password = new PasswordField();
    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("addAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 120);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    public void close(){
        Stage stage = (Stage) password.getScene().getWindow();
        stage.hide();
    }
    public void proceed() throws SQLException, IOException {
        dbUser db = new dbUser();
        db.insertAdminDetails(password.getText());
        alertController alert = new alertController();
        close();
        alert.launch("Your password is: "+password.getText(), "Success");
    }
}
