package com.example.batalhanaval;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Timeline timeline;
    LocalTime time=LocalTime.parse("00:00");
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm:ss");

    public Label timer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> incrementTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void incrementTime() {
        time = time.plusSeconds(1);
        timer.setText(time.format(dtf));
    }
    @FXML
    private void startTimer(ActionEvent event) {
        timeline.play();
    }
    @FXML
    private void pauseTimer(ActionEvent event){
        timeline.pause();
    }


}