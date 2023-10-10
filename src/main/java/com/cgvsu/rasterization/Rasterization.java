package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

/*
7. Реализовать метод (класс) для заполнения сектора окружности.
Добавить возможность интерполяции цвета, например, при удалении от центра круга.

, вы не можете использовать здесь готовые библиотечные методы. Единственная доступная опция —
заливка цветом отдельного пикселя по его координатам
 */

public class Rasterization {

    /* public static void drawCircleSector(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color)
    {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }

     */

   /* public static void drawCircleSector(
            final GraphicsContext graphicsContext,
            final int centerX, final int centerY,
            final int radius,
            final double startAngleDegrees, //начальный угол в градусах
            final double endAngleDegrees,  //конечный угол в градусах
            final Color innerColor,
            final Color outerColor) {

        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        final int xStart = centerX - radius;
        final int xEnd = centerX + radius;
        final int yStart = centerY - radius;
        final int yEnd = centerY + radius;

        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                double angle = Math.toDegrees(Math.atan2(y - centerY, x - centerX));
                if (angle < 0) {
                    angle += 360.0;  // Привести угол к положительным значениям
                }

                if (angle >= startAngleDegrees && angle <= endAngleDegrees) {
                    double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
                    double fraction = (distance - radius) / radius; // Интерполяция цвета
                    fraction = Math.min(1.0, Math.max(0.0, fraction)); // Ограничение в диапазоне [0, 1]

                    // Вычисление цвета пикселя с интерполяцией между innerColor и outerColor
                    Color pixelColor = interpolateColor(innerColor, outerColor, fraction);

                    // Установка цвета пикселя
                    pixelWriter.setColor(x, y, pixelColor);
                }
            }
        }
    }

    */

    /* public static void drawCircleSector(
            final GraphicsContext graphicsContext,
            final int centerX, final int centerY,
            final int radius,
            final double startAngleDegrees, // начальный угол в градусах
            final double endAngleDegrees,   // конечный угол в градусах
            final Color innerColor,
            final Color outerColor) {

        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int x = centerX - radius; x <= centerX + radius; x++) {
            for (int y = centerY - radius; y <= centerY + radius; y++) {
                double angle = Math.toDegrees(Math.atan2(y - centerY, x - centerX));
                if (angle < 0) {
                    angle += 360.0;  // Привести угол к положительным значениям
                }

                if (angle >= startAngleDegrees && angle <= endAngleDegrees) {
                    double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
                    if (distance <= radius) {
                        double fraction = (distance - radius) / radius; // Интерполяция цвета
                        fraction = Math.min(1.0, Math.max(0.0, fraction)); // Ограничение в диапазоне [0, 1]

                        // Вычисление цвета пикселя с интерполяцией между innerColor и outerColor
                        Color pixelColor = interpolateColor(innerColor, outerColor, fraction);

                        // Установка цвета пикселя
                        pixelWriter.setColor(x, y, pixelColor);
                    }
                }
            }
        }
    }

     */

    public static void drawCircleSector(
            final GraphicsContext graphicsContext,
            final int centerX, final int centerY,
            final int radius,
            final double startAngleDegrees, // начальный угол в градусах
            final double endAngleDegrees,   // конечный угол в градусах
            final Color innerColor,
            final Color outerColor) {

        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        final double startAngleRadians = Math.toRadians(startAngleDegrees);
        final double endAngleRadians = Math.toRadians(endAngleDegrees);

        for (int x = centerX - radius; x <= centerX + radius; x++) { //Двойной цикл, который перебирает каждый пиксель в прямоугольной области, охватывающей окружность.
            for (int y = centerY - radius; y <= centerY + radius; y++) {
                double angle = Math.toDegrees(Math.atan2(y - centerY, x - centerX)); //Рассчет угла между центром окружности и текущей точкой (x, y) с помощью функции Math.atan2. Затем угол переводится в градусы.
                if (angle < 0) {
                    angle += 360.0;  // Привести угол к положительным значениям
                }

                if (angle >= startAngleDegrees && angle <= endAngleDegrees) { // Проверка, находится ли текущий угол внутри заданного сектора.
                    double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)); //Вычисление расстояния от текущей точки (x, y) до центра окружности.
                    if (distance <= radius) { //находится ли текущая точка внутри окружности
                        double fraction = (angle - startAngleDegrees) / (endAngleDegrees - startAngleDegrees); // Интерполяция цвета по углу
                        //fraction представляет собой отношение угла между текущей точкой и начальным углом к общей разнице между начальным и конечным углом.
                        fraction = Math.min(1.0, Math.max(0.0, fraction)); // Ограничение в диапазоне [0, 1]

                        // Вычисление цвета пикселя с интерполяцией между innerColor и outerColor
                        Color pixelColor = interpolateColor(innerColor, outerColor, fraction);

                        // Установка цвета пикселя
                        pixelWriter.setColor(x, y, pixelColor);
                    }
                }
            }
        }
    }



    // Метод для интерполяции цвета между двумя цветами

//    private static Color interpolateColor(Color color1, Color color2, double fraction) {
//        double r = color1.getRed() * (1 - fraction) + color2.getRed() * fraction;
//        double g = color1.getGreen() * (1 - fraction) + color2.getGreen() * fraction;
//        double b = color1.getBlue() * (1 - fraction) + color2.getBlue() * fraction;
//        return new Color(r, g, b, 1.0);
//    }


    private static Color interpolateColor(Color startColor, Color endColor, double ratio) {
        //ratio - это значение между 0 и 1, которое указывает, как близко к endColor должен быть результирующий цвет.
        double r = startColor.getRed() + ratio * (endColor.getRed() - startColor.getRed());
        double g = startColor.getGreen() + ratio * (endColor.getGreen() - startColor.getGreen());
        double b = startColor.getBlue() + ratio * (endColor.getBlue() - startColor.getBlue());

        return new Color(r, g, b,1.0);
    }






}
