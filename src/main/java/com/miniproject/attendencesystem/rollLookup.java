package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class rollLookup {
    @FXML
    private TextField rollNo = new TextField();
    static String roll;
    void launch() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("rollNoLookup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 150);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void close(){
        Stage stage = (Stage) rollNo.getScene().getWindow();
        stage.hide();
    }
    @FXML
    void proceed() throws SQLException, IOException {
        dbUser db = new dbUser();
        if(db.rollNo(Integer.parseInt(rollNo.getText()))) {
            close();
            roll = rollNo.getText();
            editStudentController edit = new editStudentController();
            edit.launch();
        }
        else{
            alertController alert = new alertController();
            alert.launch("Could not find student please check roll number", "Failed");
        }
    }
}
