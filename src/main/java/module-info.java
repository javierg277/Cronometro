module com.example.cronometro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cronometro to javafx.fxml;
    exports com.example.cronometro;
}