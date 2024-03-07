package com.example.cronometro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        // Obtener el controlador del archivo FXML
        CronometroApp cronometroApp = loader.getController();

        // Configurar el escenario
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cronómetro");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}