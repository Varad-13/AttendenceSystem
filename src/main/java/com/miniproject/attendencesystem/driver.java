package com.miniproject.attendencesystem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class driver extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        dbUser database = new dbUser();
        if(database.checkConnection()){
            loginController login = new loginController();
            login.launch(stage);
            System.out.println("connection Success");
        }
    }

    public static void main(String[] args){
        launch();
    }
}