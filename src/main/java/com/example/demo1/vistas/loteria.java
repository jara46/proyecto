package com.example.demo1.vistas;

import java.util.*;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class loteria extends Stage {
    private Scene escena;
    private HBox hprincipal,hsecundaria,botones;
    private VBox carta,mazo;
    private Button btnAnterior,btnSiguiente,btnStart;
    private Image imazo,imagencarta,imagenDamwn;
    private GridPane gridPane;
    private BorderPane borderPane;
    private int[][] arr1 = {
            {0, 21, 19, 12},
            {29, 25, 18, 3},
            {13, 15, 5, 11},
            {31, 33, 1, 23}
    };
    private int []arr2={34,16,11,18,12,25,21,7,10,28,15,20,24,29,19,5};
    private Button[][] arrbtn=new Button[4][4];
    private  int [] arrImage={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
    private Timer timer;
    private int tiempoCambioMazo = 2000;
    private Set<Integer> imagenesUsadas = new HashSet<>();
    private int totalImagenesUnicas;
    private int indiceImagenActualDelMazo = -1;

    public loteria(){
        crearUI();

        escena=new Scene(hprincipal,1024,600);
        this.setTitle("LOTERIA");
        this.getIcons().add(new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\zakurazaka46\\QnAYD6QT_400x400.jpg"));
        this.setScene(escena);
        this.show();
    }

    private void crearUI(){ //sse crea la interfaz
        CrearTablilla();
        crearMazo();

        totalImagenesUnicas = arrImage.length;
        btnAnterior=new Button("<---");

        btnAnterior.setPrefSize(200,100);  //se le da el tamaño de los botones

        btnSiguiente=new Button("--->");
        btnSiguiente.setPrefSize(200,100);

        botones=new HBox(btnAnterior,btnSiguiente); //se coloca los botones en la hbox
        carta=new VBox(gridPane,botones);// se agrega los botones y el gridpane en la cata que es un vbox
        btnStart.setOnAction(event -> {
            // Comenzar el temporizador para cambiar el mazo
            iniciarTimer();
        });

        hprincipal=new HBox(carta,mazo);
        mazo.setTranslateX(250);
        mazo.setSpacing(150);
        hprincipal.setPadding(new Insets(20));
        carta.setSpacing(20);

    }

    private void crearMazo() {
        imagenDamwn=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+0+".png");
        ImageView imv=new ImageView(imagenDamwn);
        imv.setFitHeight(300);
        imv.setFitWidth(150);
        btnStart=new Button("START");
        btnStart.setPrefSize(200,100);
        mazo=new VBox(imv,btnStart);
    }
    private void CrearTablilla() {
        gridPane = new GridPane();
        AtomicInteger contador = new AtomicInteger();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                //Image imagencarta=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+k+".png");
                Image imagencarta = new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\" + arrImage[arr1[i][j]]+".png");
                ImageView imv = new ImageView(imagencarta);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
                arrbtn[i][j] = new Button();
                arrbtn[i][j].setGraphic(imv);
                arrbtn[i][j].setPrefSize(100, 140);
                gridPane.add(arrbtn[i][j], i, j);



                int finalI = i;
                int finalJ = j;
                arrbtn[i][j].setOnAction(event -> {

                    int valorBoton=arr1[finalI][finalJ];
                    int valorMazo = obtenerValorMazoActual();


                    if (valorBoton == valorMazo) {
                        contador.getAndIncrement();
                        arr1[finalI][finalJ]=0;
                        Image imagencarta1 = new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\kayakizaka46\\G3bOYVQ.jpg");
                        ImageView imv1 = new ImageView(imagencarta1);
                        imv1.setFitHeight(100);
                        imv1.setFitWidth(100);
                        arrbtn[finalI][finalJ].setGraphic(imv1);
                        System.out.println("¡Los valores son iguales! "+contador);
                    } else if (imagenesUsadas.contains(valorBoton)){
                        contador.getAndIncrement();
                        arr1[finalI][finalJ]=0;
                        Image imagencarta2 = new Image("C:\\Users\\rodri\\OneDrive\\Escritorio\\kayakizaka46\\G3bOYVQ.jpg");
                        ImageView imv2 = new ImageView(imagencarta2);
                        imv2.setFitHeight(100);
                        imv2.setFitWidth(100);
                        arrbtn[finalI][finalJ].setGraphic(imv2);
                        System.out.println("¡la imagen ya habia salido tienes que estar mas al pendiente ! "+contador);

                    }else{
                        System.out.println("Los valores son diferentes.");
                    }
                    if(contador.get() ==16){

                        GANASTE();
                        detenerTimer();
                    }


                });

            }
        }
    }
    private void CrearTablilla2() {
        gridPane=new GridPane();
        int k=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                //Image imagencarta=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+k+".png");
                Image imagencarta=new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\"+arrImage[arr2[k]]);
                ImageView imv=new ImageView(imagencarta);
                imv.setFitHeight(100);
                imv.setFitWidth(100);
                arrbtn[i][j]=new Button();
                arrbtn[i][j].setGraphic(imv);
                arrbtn[i][j].setPrefSize(100,140);
                gridPane.add(arrbtn[i][j],i,j);
                k++;
            }

        }
    }
    private void iniciarTimer() {
        int n=0;
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        TimerTask tareaCambioMazo = new TimerTask() {

            @Override
            public void run() {

                // Cambiar la imagen del mazo aquí

                Platform.runLater(() -> {
                    if (imagenesUsadas.size() < totalImagenesUnicas) {
                        cambiarImagenMazo();

                    } else {
                        detenerTimer();
                    }

                });
            }
        };

        timer.scheduleAtFixedRate(tareaCambioMazo, tiempoCambioMazo, tiempoCambioMazo);
    }

    private void cambiarImagenMazo() {
        // Aquí cambia la imagen del mazo sin repetirlas
        Random random = new Random();
        int indiceImagen;
        // Busca una imagen aleatoria que aún no se haya utilizado
        do {
            indiceImagen = random.nextInt(arrImage.length);
        } while (imagenesUsadas.contains(indiceImagen));
        imagenesUsadas.add(indiceImagen);
        indiceImagenActualDelMazo = indiceImagen;
        Image nuevaImagen = new Image("C:\\Users\\rodri\\IdeaProjects\\demo1\\src\\main\\java\\imagen\\" + arrImage[indiceImagen] + ".png");
        ImageView imv = new ImageView(nuevaImagen);
        imv.setFitHeight(300);
        imv.setFitWidth(150);
        mazo.getChildren().set(0, imv); // Reemplaza la imagen del mazo con la nueva imagen
    }
    private void detenerTimer() {
        if (timer != null) {
            timer.cancel();
        }

    }
    private int obtenerValorMazoActual() {
        return indiceImagenActualDelMazo;
    }
    private void GANASTE() {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("FELICIDADES HAS GANADO ERES UN CRACK");
        Optional<ButtonType> option=alert.showAndWait();
        if(option.get() == ButtonType.OK){
            this.close();
        }

    }
}

