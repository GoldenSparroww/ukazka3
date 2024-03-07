package com.example.ukazka3;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    public Slider alfaSlider;
    public Slider betaSlider;
    public Label alfaZadej;
    public Label betaZadej;
    public Label gamaVysledek;
    public Label aZadej;
    public TextField aZdaejTextField;
    public Label bVysledek;
    public Label chyba;

    public void OK(ActionEvent actionEvent) {
        chyba.setText("");

        int alfa = (int) alfaSlider.getValue();
        int beta = (int) betaSlider.getValue();
        String a = aZdaejTextField.getText();

        int value1 = (int) alfaSlider.getValue();
        alfaZadej.setText("ALFA = "+String.valueOf(value1)+"°");

        int value2 = (int) betaSlider.getValue();
        betaZadej.setText("BETA = "+String.valueOf(value2)+"°");

        try {
            if (alfa + beta < 180){
                double aCislo = Double.parseDouble(a);
                if (!(aCislo <= 0)){
                    double b = aCislo*(Math.toRadians(alfa)/Math.toRadians(beta));
                    int gama = 180-alfa-beta;
                    bVysledek.setText("b = "+b);
                    gamaVysledek.setText("GAMA = "+gama+"°");
                } else {
                    chyba.setText("chyba: a je záporné");
                }
            } else {
                chyba.setText("chyba: ALFA + BETA >= 180°");
            }
        } catch (NumberFormatException e) {
            chyba.setText("chyba: a není číslo");
        }
    }
}
