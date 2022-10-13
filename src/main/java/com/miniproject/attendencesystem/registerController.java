package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class registerController {
    @FXML
    private Label label = new Label();
    @FXML
    private TextField name = new TextField();
    @FXML
    private TextField division = new TextField();
    @FXML
    private TextField face = new TextField();
    @FXML
    private RadioButton ds = new RadioButton();
    @FXML
    private RadioButton cs = new RadioButton();
    @FXML
    private RadioButton ai = new RadioButton();
    @FXML
    private RadioButton civil = new RadioButton();
    @FXML
    private RadioButton mech = new RadioButton();
    @FXML
    private RadioButton fe = new RadioButton();
    @FXML
    private RadioButton se = new RadioButton();
    @FXML
    private RadioButton te = new RadioButton();
    @FXML
    private RadioButton be = new RadioButton();
    dbUser db = new dbUser();
    alertController alert = new alertController();
    void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("registerStudent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 494, 343);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void close() throws IOException {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.hide();
        adminController admin = new adminController();
        admin.launch();
    }
    @FXML
    void addData() throws SQLException, IOException {
        int year = 0;
        String department = null;
        while(true) {
            if (ds.isSelected()) {
                department = "ds";
                break;
            }
            if (cs.isSelected()) {
                department = "cs";
                break;
            }
            if (ai.isSelected()) {
                department = "ai";
                break;
            }
            if (civil.isSelected()) {
                department = "civil";
                break;
            }
            if(mech.isSelected()) {
                department = "mech";
                break;
            }
        }
        while(true){
            if(fe.isSelected()) {
                year = 1;
                break;
            }
            if(se.isSelected()){
                year = 2;
                break;
            }
            if(te.isSelected()){
                year = 3;
                break;
            }
            if(be.isSelected()){
                year = 4;
                break;
            }
        }
        db.insertLoginDetails(name.getText(), division.getText(), year, department, face.getText());
        alert.launch("Your Roll number is "+db.getRollno(face.getText()), "Success");
    }
}
