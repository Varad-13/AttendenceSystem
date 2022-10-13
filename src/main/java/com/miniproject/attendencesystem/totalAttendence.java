package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class totalAttendence {
    @FXML
    private TextField s1 = new TextField();
    @FXML
    private TextField s2 = new TextField();
    @FXML
    private TextField s3 = new TextField();
    @FXML
    private TextField s4 = new TextField();
    @FXML
    private TextField s5 = new TextField();

    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("setTotalAttendence.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 317, 240);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws SQLException {
        dbGetStudentDetails db = new dbGetStudentDetails();
        db.rollNo(1);
        s1.setText(String.valueOf(dbGetStudentDetails.attn1));
        s2.setText(String.valueOf(dbGetStudentDetails.attn2));
        s3.setText(String.valueOf(dbGetStudentDetails.attn3));
        s4.setText(String.valueOf(dbGetStudentDetails.attn4));
        s5.setText(String.valueOf(dbGetStudentDetails.attn5));
    }
    public void close() throws IOException {
        Stage stage = (Stage) s1.getScene().getWindow();
        stage.hide();
        adminController admin = new adminController();
        admin.launch();
    }
    @FXML
    public void save() throws SQLException, IOException {
        dbGetStudentDetails db = new dbGetStudentDetails();
        int s1 = Integer.parseInt(this.s1.getText());
        int s2 = Integer.parseInt(this.s2.getText());
        int s3 = Integer.parseInt(this.s3.getText());
        int s4 = Integer.parseInt(this.s4.getText());
        int s5 = Integer.parseInt(this.s5.getText());
        db.updateMaxAttendence(s1, s2, s3, s4, s5);
        close();
    }
}
