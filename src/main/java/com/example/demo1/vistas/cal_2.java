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

public class cal_2 extends Stage {

    private Scene ecena;
    private Image image = new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\kayakizaka46\\B0SuSSV.jpg");
    private VBox vBox;
    private BorderPane borderPane;
    private GridPane gridPane;
    private TextField textField;
    private Button[][] arrBotones = new Button[4][4];
    private String[] arrdigitos = {"7", "4", "1", "/", "8", "5", "2", "*", "9", "6", "3", "-", "0", ".", "=", "+"};
    private Button clean = new Button("c");
    private String valor = "",valor2="";
    private float resultado;
    private String operador = "";

    public cal_2() {
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
            System.out.println(valor+" ---------> valor1");
            textField.setText(valor);
        } else if (simbolo.matches("[-+*/]")) {
            operador=simbolo;
            if (!valor.isEmpty()) {
                cal();
                System.out.println(valor2+" --------> valor2");
                textField.setText("");
            }
        }else if (simbolo.equals("=")) {
            cal2();
            textField.appendText("");
        }
    }
    public void cal() {
        if (!valor.isEmpty() == !operador.isEmpty()) {
            float x = Float.parseFloat(valor);
            float y = Float.parseFloat(valor2);
            switch (operador) {
                case "+" -> resultado = x + y;
                case "-" -> resultado = x * y;
                case "*" -> resultado = x * y;
                case "/" -> resultado = x / y;
            }

            textField.setText(String.valueOf(resultado));
            valor = "";
            System.out.println("-----------------------------");
        }
    }
    public void cal2(){
        if (!valor.isEmpty() == !operador.isEmpty()) {
            cal();
            System.out.println("000");
        }
    }
}



/*package com.example.demo1.vistas;

import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.GenericArrayType;

public class cal_2 extends Stage {
    private Scene ecena;
    private GridPane gridPane,grdTeclado;
    private BorderPane borderPane;
    private VBox vBox;
    private TextField textField;

    public cal_2(){
        vBox=new VBox();

        gridPane=new GridPane();
        borderPane=new BorderPane();
        ecena=new Scene(borderPane,200,200);
        gridPane.add(new Button("7"),1,1);
        gridPane.add(new Button("8"),2,1);
        gridPane.add(new Button("9"),3,1);
        gridPane.add(new Button("C"),4,1);
        gridPane.add(new Button("4"),1,2);
        gridPane.add(new Button("5"),2,2);
        gridPane.add(new Button("6"),3,2);
        gridPane.add(new Button("*"),4,2);
        gridPane.add(new Button("1"),1,3);
        gridPane.add(new Button("2"),2,3);
        gridPane.add(new Button("3"),3,3);
        gridPane.add(new Button("+"),4,3);
        gridPane.add(new Button("0"),1,4);
        gridPane.add(new Button("-"),2,4);
        gridPane.add(new Button("/"),3,4);
        gridPane.add(new Button("="),4,4);
        borderPane.setCenter(gridPane);
     //   ecena=new Scene(new Button("hola"));

        this.setTitle("cal_2.0");
        this.setScene(ecena);
        this.getIcons().add(new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\zakurazaka46\\QnAYD6QT_400x400.jpg"));
      //  this.setMaximized(true);
        this.show();
    }
}*/
