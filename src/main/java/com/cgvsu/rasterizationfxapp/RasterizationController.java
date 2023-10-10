package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 200, 300, 150, 100, 150, Color.AQUA,Color.RED);
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 250, 250, 50, 200, 240,Color.BLANCHEDALMOND,Color.CHOCOLATE );
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 350, 150, 60, 12, 240,Color.DARKOLIVEGREEN,Color.AZURE );


        // Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 450, 150, 60, 280, 440,Color.DARKOLIVEGREEN,Color.AZURE );
        //Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 400, 250, 60, 280, 500,Color.DARKOLIVEGREEN,Color.AZURE );

        // Сектор, который идет вправо от центра
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 450, 150, 60, 0, 80, Color.AZURE, Color.WHITE);

// Сектор, который идет влево от центра
        Rasterization.drawCircleSector(canvas.getGraphicsContext2D(), 450, 150, 60, 280, 360, Color.DARKOLIVEGREEN, Color.AZURE);

    }

}