package com.example.batalhanaval;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    Pane tier1Pane,tier2Pane,tier3Pane,tier4Pane,tier5Pane;
    boolean barco_tier1 =false, barco_tier2 =false, barco_tier3 =false, barco_tier4 =false, barco_tier5 =false,started=false;
    Timeline timeline;
    LocalTime time=LocalTime.parse("00:00");
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm:ss");

    public Label timer;
    //Barcos
    public Button tier1,tier2,tier3,tier4,tier5;
    //Enimigos
    public Button e11,e21,e31,e41,e51,e61,e71,e81,e91,e101,e12,e22,e32,e42,e52,e62,e72,e82,e92,e102;
    public Button e13,e23,e33,e43,e53,e63,e73,e83,e93,e103,e14,e24,e34,e44,e54,e64,e74,e84,e94,e104;
    public Button e15,e25,e35,e45,e55,e65,e75,e85,e95,e105,e16,e26,e36,e46,e56,e66,e76,e86,e96,e106;
    public Button e17,e27,e37,e47,e57,e67,e77,e87,e97,e107,e18,e28,e38,e48,e58,e68,e78,e88,e98,e108;
    public Button e19,e29,e39,e49,e59,e69,e79,e89,e99,e109,e110,e210,e310,e410,e510,e610,e710,e810,e910,e1010;
    //Array enimigos
    public Button[][] botoesEnimigo={{e11 , e12, e13, e14, e15, e16, e17, e18, e19, e110},
                                     {e21 , e22, e23, e24, e25, e26, e27, e28, e29, e210},
                                     {e31 , e32, e33, e34, e35, e36, e37, e38, e39, e310},
                                     {e41 , e42, e43, e44, e45, e46, e47, e48, e49, e410},
                                     {e51 , e52, e53, e54, e55, e56, e57, e58, e59, e510},
                                     {e61 , e62, e63, e64, e65, e66, e67, e68, e69, e610},
                                     {e71 , e72, e73, e74, e75, e76, e77, e78, e79, e710},
                                     {e81 , e82, e83, e84, e85, e86, e87, e88, e89, e810},
                                     {e91 , e92, e93, e94, e95, e96, e97, e98, e99, e910},
                                     {e101,e102,e103,e104,e105,e106,e107,e108,e109,e1010}};
    //Player
    public Button y11,y21,y31,y41,y51,y61,y71,y81,y91,y101,y12,y22,y32,y42,y52,y62,y72,y82,y92,y102;
    public Button y13,y23,y33,y43,y53,y63,y73,y83,y93,y103,y14,y24,y34,y44,y54,y64,y74,y84,y94,y104;
    public Button y15,y25,y35,y45,y55,y65,y75,y85,y95,y105,y16,y26,y36,y46,y56,y66,y76,y86,y96,y106;
    public Button y17,y27,y37,y47,y57,y67,y77,y87,y97,y107,y18,y28,y38,y48,y58,y68,y78,y88,y98,y108;
    public Button y19,y29,y39,y49,y59,y69,y79,y89,y99,y109,y110,y210,y310,y410,y510,y610,y710,y810,y910,y1010;
    //Array player
    public Button[][] botoesPlayer={{y11 , y12, y13, y14, y15, y16, y17, y18, y19, y110},
                                    {y21 , y22, y23, y24, y25, y26, y27, y28, y29, y210},
                                    {y31 , y32, y33, y34, y35, y36, y37, y38, y39, y310},
                                    {y41 , y42, y43, y44, y45, y46, y47, y48, y49, y410},
                                    {y51 , y52, y53, y54, y55, y56, y57, y58, y59, y510},
                                    {y61 , y62, y63, y64, y65, y66, y67, y68, y69, y610},
                                    {y71 , y72, y73, y74, y75, y76, y77, y78, y79, y710},
                                    {y81 , y82, y83, y84, y85, y86, y87, y88, y89, y810},
                                    {y91 , y92, y93, y94, y95, y96, y97, y98, y99, y910},
                                    {y101,y102,y103,y104,y105,y106,y107,y108,y109,y1010}};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> incrementTime()));
        timeline.setCycleCount(Animation.INDEFINITE);

        e11.hoverProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object number, Object t1) {
                mouseOver(e11);
            }
        });
        tier1.hoverProperty().addListener((observableValue, number, t1) -> mouseOver(tier1));
        tier2.hoverProperty().addListener((observableValue, number, t1) -> mouseOver(tier2));
        tier3.hoverProperty().addListener((observableValue, number, t1) -> mouseOver(tier3));
        tier4.hoverProperty().addListener((observableValue, number, t1) -> mouseOver(tier4));
        tier5.hoverProperty().addListener((observableValue, number, t1) -> mouseOver(tier5));
    }

    private void incrementTime() {
        time = time.plusSeconds(1);
        timer.setText(time.format(dtf));
    }
    private void startTimer() {
        timeline.play();
    }
    private void pauseTimer(){
        timeline.pause();
    }

    public void start(){
        if (started){
            pauseTimer();
            started=false;
        }else {
            startTimer();
            started=true;
        }
    }

    public void mouseOver(Button but){
        if (but.isHover()){
            but.setStyle("-fx-background-color: #ade3f0");
        }else {
            but.setStyle("-fx-background-color: rgba(0,0,0,0);");
        }
    }

    public void bandeira(MouseEvent butao){
        if (e11.getText().equals("") && butao.getButton()== MouseButton.SECONDARY){
           e11.setText("?");
        }else{
            e11.setText("");
        }
    }

    public boolean setTrue(boolean barco,Pane pane){
        if (barco){
            pane.setStyle("-fx-background-color: #ffffff");
            barco=false;
        }else {
            pane.setStyle("-fx-background-color: #ade3f0");
            barco=true;
        }
        return barco;
    }

    public void setTier1(){
        barco_tier1=setTrue(barco_tier1,tier1Pane);
        barco_tier2 =false;
        barco_tier3 =false;
        barco_tier4 =false;
        barco_tier5 =false;
    }
    public void setTier2(){
        barco_tier1 =false;
        barco_tier2 =true;
        barco_tier3 =false;
        barco_tier4 =false;
        barco_tier5 =false;
    }
    public void setTier3(){
        tier3Pane.setStyle("-fx-background-color: #ade3f0");
        barco_tier1 =false;
        barco_tier2 =false;
        barco_tier3 =true;
        barco_tier4 =false;
        barco_tier5 =false;
    }
    public void setTier4(){
        tier4Pane.setStyle("-fx-background-color: #ade3f0");
        barco_tier1 =false;
        barco_tier2 =false;
        barco_tier3 =false;
        barco_tier4 =true;
        barco_tier5 =false;
    }
    public void setTier5(){
        tier5Pane.setStyle("-fx-background-color: #ade3f0");
        barco_tier1 =false;
        barco_tier2 =false;
        barco_tier3 =false;
        barco_tier4 =false;
        barco_tier5 =true;
    }

    public void disposicao(){
        if (barco_tier1){

        }
    }


}