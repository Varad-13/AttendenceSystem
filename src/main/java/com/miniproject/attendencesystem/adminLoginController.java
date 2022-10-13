package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class adminLoginController {
    @FXML
    private PasswordField password = new PasswordField();
    dbUser db = new dbUser();
    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("adminLogin.fxml"));
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
    public void exit(){close();}
    public void proceed() throws SQLException, IOException {
        if(db.admin_login(password.getText())){
            close();
            adminController admin = new adminController();
            admin.launch();
        }
        else {
            alertController alert = new alertController();
            alert.launch("Wrong password", "Failed");
        }
    }
}
