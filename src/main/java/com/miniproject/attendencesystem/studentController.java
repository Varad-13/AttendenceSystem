package com.miniproject.attendencesystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class studentController {
    @FXML
    private Label attendence1 = new Label();
    @FXML
    private Label attendence2 = new Label();
    @FXML
    private Label attendence3 = new Label();
    @FXML
    private Label attendence4 = new Label();
    @FXML
    private Label attendence5 = new Label();
    @FXML
    private Label s1 = new Label();
    @FXML
    private Label s2 = new Label();
    @FXML
    private Label s3 = new Label();
    @FXML
    private Label s4 = new Label();
    @FXML
    private Label s5 = new Label();
    @FXML
    private Label total = new Label();
    @FXML
    private Label stotal = new Label();
    @FXML
    private Label percentage = new Label();
    dbGetStudentDetails db = new dbGetStudentDetails();
    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("studentHomepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 768, 240);
        Stage stage = new Stage();
        stage.setTitle("Attendence System");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws SQLException {
        db.getStudent(loginController.face);
        attendence1.setText(String.valueOf(dbGetStudentDetails.attn1));
        attendence2.setText(String.valueOf(dbGetStudentDetails.attn2));
        attendence3.setText(String.valueOf(dbGetStudentDetails.attn3));
        attendence4.setText(String.valueOf(dbGetStudentDetails.attn4));
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn5));
        int total = dbGetStudentDetails.attn1 + dbGetStudentDetails.attn2 + dbGetStudentDetails.attn3 + dbGetStudentDetails.attn4 + dbGetStudentDetails.attn5;
        db.rollNo(1);
        s1.setText(String.valueOf(dbGetStudentDetails.attn1));
        s2.setText(String.valueOf(dbGetStudentDetails.attn2));
        s3.setText(String.valueOf(dbGetStudentDetails.attn3));
        s4.setText(String.valueOf(dbGetStudentDetails.attn4));
        s5.setText(String.valueOf(dbGetStudentDetails.attn5));
        int stotal = dbGetStudentDetails.attn1 + dbGetStudentDetails.attn2 + dbGetStudentDetails.attn3 + dbGetStudentDetails.attn4 + dbGetStudentDetails.attn5;
        this.total.setText(String.valueOf(total));
        this.stotal.setText(String.valueOf(stotal));
        float percentage = ((float) total/(float) stotal)*100;
        this.percentage.setText(String.valueOf(percentage));
    }
    public void close(){
        Stage stage = (Stage) attendence1.getScene().getWindow();
        stage.hide();
    }
    public void attendence1() throws SQLException {
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn1+1));
        initialize();
    }
    public void attendence2() throws SQLException {
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn2+1));
        initialize();
    }
    public void attendence3() throws SQLException {
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn3+1));
        initialize();
    }
    public void attendence4() throws SQLException {
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn4+1));
        initialize();
    }
    public void attendence5() throws SQLException {
        attendence5.setText(String.valueOf(dbGetStudentDetails.attn5+1));
        initialize();
    }
}
