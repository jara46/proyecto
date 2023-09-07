package com.example.demo1.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class calculadora extends Stage {

    private Scene ecena;
    private Image image = new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\kayakizaka46\\B0SuSSV.jpg");
    private VBox vBox;
    private BorderPane borderPane;
    private GridPane gridPane;
    private TextField textField;
    private Button[][] arrBotones = new Button[4][4];
    private String[] arrdigitos = {"7", "4", "1", "/", "8", "5", "2", "*", "9", "6", "3", "-", "0", ".", "=", "+"};
    private Button clean = new Button("c");
    private String valor = "";
    private float resultado;
    private String operador = "";

    public calculadora() {
        crearUI();
        ecena = new Scene(vBox, 200, 200);
        this.setTitle("calculadora");
        this.setScene(ecena);
        this.getIcons().add(new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\zakurazaka46\\QnAYD6QT_400x400.jpg"));
        this.show();
    }

    private void crearUI() {
        int pos = 0;
        gridPane = new GridPane();
        borderPane = new BorderPane();
        gridPane.add(clean, 3, 5);
        clean.setPrefSize(50, 50);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(200);
        borderPane.setCenter(imageView);
        textField = new TextField("");
        textField.setAlignment(Pos.BASELINE_RIGHT);
        textField.setEditable(false);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final String simbolo = arrdigitos[pos] + "";
                arrBotones[i][j] = new Button(simbolo);

                arrBotones[i][j].setPrefSize(50, 50);
                arrBotones[i][j].setOnAction(event -> expresion(simbolo));
                gridPane.add(arrBotones[i][j], i, j);
                pos++;
            }
        }
        clean.setOnAction(e -> {
            textField.setText("");
            valor = "";
            operador = "";
            resultado =0;
        });
        vBox = new VBox(textField, gridPane);
    }

    private void expresion(String simbolo) {
        if (simbolo.matches("[0-9.]")) {
            valor += simbolo;
            textField.setText(valor);
        } else if (simbolo.matches("[-+*/]")) {
            operador=simbolo;
            if (!valor.isEmpty()) {
                cal();
                textField.setText("");
            }
        }else if (simbolo.equals("=")) {
            cal2();
            textField.appendText("");
        }
    }
      public void cal() {
              float xx = Float.parseFloat(valor);
              switch (operador) {
                  case "+" -> resultado += xx;
                  case "-" -> resultado -= xx;
                  case "*" -> resultado *= xx;
                  case "/" -> resultado /= xx;
              }
              textField.setText(String.valueOf(resultado));
              valor = "";
              System.out.println("-----------------------------");
      }
     public void cal2(){
         if (!valor.isEmpty() == !operador.isEmpty()) {
             cal();
             System.out.println("000");
         }
    }
}














 /*if(valor.equals("+")){
        x=Integer.parseInt(valor);
        textField.setText("0");
        y=Integer.parseInt(valor);
        int z=x+y;
        textField.setText(Integer.toString(z));
        }
        if(valor.equals("+")){
        k=1;
        System.out.println(k);
        }
        if(valor.equals("-")){
        k=2;
        System.out.println(k);
        }
        if(valor.equals("*")){
        k=3;
        System.out.println(k);
        }
        if(valor.equals("/")){
        k=4;
        System.out.println(k);
        }
        if (k == 1) {

        *///}*/