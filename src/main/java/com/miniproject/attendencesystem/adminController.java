package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class adminController {
    @FXML
    private Label text = new Label();
    void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("adminHomepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 536, 160);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void close(){
        Stage stage = (Stage) text.getScene().getWindow();
        stage.hide();
    }
    @FXML
    void addAdmin() throws IOException {
        addAdminController admin = new addAdminController();
        admin.launch();
    }
    @FXML
    void editStudent() throws IOException, SQLException {
        rollLookup roll = new rollLookup();
        close();
        roll.launch();
    }
    @FXML
    void addStudent() throws IOException {
        close();
        registerController register = new registerController();
        register.launch();
    }
    @FXML
    void setTotal() throws IOException, SQLException {
        close();
        totalAttendence total = new totalAttendence();
        total.launch();
    }
}
