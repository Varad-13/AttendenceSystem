package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class editStudentController {
    @FXML
    private TextField name = new TextField();
    @FXML
    private TextField division = new TextField();
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

    dbUser dbStud = new dbUser();

    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("editStudent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 494, 310);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws SQLException {
        dbGetStudentDetails db = new dbGetStudentDetails();
        db.rollNo(Integer.parseInt(rollLookup.roll));
        name.setText(dbGetStudentDetails.name);
        division.setText(dbGetStudentDetails.division);
        String dept = dbGetStudentDetails.department;
        switch(dept){
            case "ds":
                ds.setSelected(true);
                break;
            case "cs":
                cs.setSelected(true);
                break;
            case "ai":
                ai.setSelected(true);
                break;
            case "mech":
                mech.setSelected(true);
                break;
            case "civil":
                civil.setSelected(true);
                break;
        }
        int year = dbGetStudentDetails.year;
        switch(year){
            case 1:
                fe.setSelected(true);
                break;
            case 2:
                se.setSelected(true);
                break;
            case 3:
                te.setSelected(true);
                break;
            case 4:
                be.setSelected(true);
                break;
        }
    }
    public void close() throws IOException {
        Stage stage = (Stage) be.getScene().getWindow();
        stage.hide();
        adminController admin = new adminController();
         admin.launch();
    }
    public void update() throws SQLException, IOException {
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
        dbGetStudentDetails db = new dbGetStudentDetails();
        db.updateStudentDetails(name.getText(), division.getText(), year, department);
        alertController alert = new alertController();
        alert.launch("Successfully Updated", "Success");
    }
}
