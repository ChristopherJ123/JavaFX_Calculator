module com.example.javafx_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_calculator to javafx.fxml;
    exports com.example.javafx_calculator;
}