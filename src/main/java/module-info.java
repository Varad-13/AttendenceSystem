module com.miniproject.attendencesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.miniproject.attendencesystem to javafx.fxml;
    exports com.miniproject.attendencesystem;
}