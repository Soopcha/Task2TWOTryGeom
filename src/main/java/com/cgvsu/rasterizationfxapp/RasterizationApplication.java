package com.cgvsu.rasterizationfxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RasterizationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Этот метод start является точкой входа для вашего JavaFX-приложения. Он будет вызван при запуске приложения.
        FXMLLoader fxmlLoader = new FXMLLoader(RasterizationApplication.class.getResource("mainwindow.fxml"));
        //Создается объект FXMLLoader для загрузки файла FXML (графического макета интерфейса) с именем "mainwindow.fxml".
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        //Создается объект Scene с содержимым, загруженным из FXML-файла. Этот объект представляет собой сцену, на которой отображается ваш интерфейс.
        stage.setTitle("Сircle sector");
        stage.setScene(scene); //Устанавливается сцена для окна stage
        stage.show(); //Окно приложения отображается на экране
    }

    public static void main(String[] args) {
        launch(); //инициализирует и запускает JavaFX-приложение
    }
}