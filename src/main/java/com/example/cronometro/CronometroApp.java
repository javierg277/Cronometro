package com.example.cronometro;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CronometroApp extends Application {
    private Timeline timeline;
    private int segundos, minutos, horas;

    @FXML
    private Label tiempoLabel;
    @FXML
    private Button iniciarBtn;
    @FXML
    private Button detenerBtn;
    private boolean cronometroIniciado = false;

    @Override
    public void start(Stage primaryStage) {

    }

    // Método para iniciar el cronómetro
    @FXML
    private void iniciarCronometro() {
        if (!cronometroIniciado) {
            iniciarBtn.setText("CONTANDO");
            iniciarBtn.setDisable(true);

            cronometroIniciado = true; // Marca que el cronómetro está en marcha

            timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        horas++;
                    }
                }
                actualizarLabelTiempo();
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    // Método para detener el cronómetro
    @FXML
    private void detenerCronometro() {

        if (timeline != null) {
            timeline.stop();
            iniciarBtn.setText("DETENIDO");
            iniciarBtn.setDisable(false);
            iniciarBtn.setText("Reanudar");
            cronometroIniciado = false; // Restablecer la bandera para permitir iniciar el cronómetro nuevamente
        }
    }

    @FXML
    private void reiniciarCronometro() {
        if (timeline != null) {
            timeline.stop();
        }
        segundos = minutos = horas = 0;
        actualizarLabelTiempo();
        iniciarBtn.setText("INICIA");
        iniciarBtn.setDisable(false);
        detenerBtn.setText("DETENER");
        cronometroIniciado = false; // Restablecer la bandera al reiniciar el cronómetro
    }

    // Método para actualizar el tiempo mostrado en la etiqueta
    private void actualizarLabelTiempo() {
        String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        tiempoLabel.setText(tiempo);
    }

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    private void reanudarCronometro() {
        if (timeline != null) {
            timeline.play();
            iniciarBtn.setText("CONTANDO");
            detenerBtn.setText("DETENER");
            cronometroIniciado = true; // Marca que el cronómetro está en marcha
        }
    }
}