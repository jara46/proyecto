package com.example.demo1;

import com.example.demo1.vistas.cal_2;
import com.example.demo1.vistas.calculadora;
import com.example.demo1.vistas.loteria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Scene escena;
    private BorderPane borderPane;
    private MenuBar menuBar;
    private Image image=new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\kayakizaka46\\B0SuSSV.jpg");
    private Menu parcial_1,parcial_2;
    private MenuItem miCalculadora,tmiCalculadora,tloteria;
    private void crearUI(){
        miCalculadora =new MenuItem("calculadora");
        tmiCalculadora =new MenuItem("cal_2");
        tloteria=new MenuItem("loteria");
        miCalculadora.setOnAction((event)->new calculadora());

        tmiCalculadora.setOnAction((event)->new cal_2());
        tloteria.setOnAction((event -> new loteria()));
        parcial_1=new Menu("pacial 1");
        parcial_1.getItems().addAll(miCalculadora,tmiCalculadora,tloteria);

        parcial_2=new Menu("parcial 2");
        menuBar=new MenuBar(parcial_1,parcial_2);


    }
    @Override
    public void start(Stage stage) throws IOException {

        crearUI();
       borderPane =new BorderPane();
       borderPane.setTop(menuBar);
       escena=new Scene(borderPane,300,200);



        stage.setScene(escena);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);

        borderPane.setCenter(imageView);
        stage.setTitle("mi primera calculadora ");
        stage.getIcons().add(new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\zakurazaka46\\QnAYD6QT_400x400.jpg"));
       //stage.setMaximized(true)
         stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}