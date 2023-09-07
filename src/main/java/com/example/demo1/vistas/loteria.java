package com.example.demo1.vistas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loteria extends Stage {
    private Scene escena;
    private HBox hprincipal,hsecundaria,botones;
    private VBox carta,mazo;
    private Button btnAnterior,btnSiguiente,btnStart;
    private Image imazo,imagencarta,imagenDamwn;
    private GridPane gridPane;
    private BorderPane borderPane;
    private Button[][] arrbtn=new Button[4][4];
    private  String[] arrImage={"1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","20_kousaka.jpg"};
    public loteria(){
        crearUI();

        escena=new Scene(hprincipal,1024,600);
        this.setTitle("LOTERIA");
        this.getIcons().add(new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\zakurazaka46\\QnAYD6QT_400x400.jpg"));
        this.setScene(escena);
        this.show();
    }

    private void crearUI(){
        CrearTablilla();
        crearMazo();
        btnAnterior=new Button("<---");
        btnAnterior.setPrefSize(200,100);
        btnSiguiente=new Button("--->");
        btnSiguiente.setPrefSize(200,100);
        botones=new HBox(btnAnterior,btnSiguiente);
        carta=new VBox(gridPane,botones);

        hprincipal=new HBox(carta,mazo);
        hprincipal.setPadding(new Insets(20));
        carta.setSpacing(20);
    }

    private void crearMazo() {
        imagenDamwn=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+0+".png");
        ImageView imv=new ImageView(imagenDamwn);
        imv.setFitHeight(100);
        imv.setFitWidth(100);

        btnStart=new Button("START");
        btnStart.setPrefSize(200,100);

        mazo=new VBox(imv,btnStart);
    }

    private void CrearTablilla() {

        gridPane=new GridPane();
        int k=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

             //Image imagencarta=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+k+".png");
                Image imagencarta=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+arrImage[k]);
                ImageView imv=new ImageView(imagencarta);
                imv.setFitHeight(100);
                imv.setFitWidth(100);


                arrbtn[i][j]=new Button();
                arrbtn[i][j].setGraphic(imv);
                arrbtn[i][j].setPrefSize(100,140);
                gridPane.add(arrbtn[i][j],i,j);
                if (k == 9) {
                    k=0;

                }else{
                    k++;
                }
            }

        }
    }
}
