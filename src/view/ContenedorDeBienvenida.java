package view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.handlers.BotonComenzarElDueloHandler;
import view.handlers.BotonPausaMusicaDeFondoHandler;
import view.handlers.BotonPlayMusicaDeFondoHandler;
import view.handlers.BotonStopMusicaDeFondoHandler;
import viewSupportFiles.PathArchivos;

public class ContenedorDeBienvenida extends VBox implements PathArchivos {

    Stage stage;
    String pathAImagenDeFondo = pathDeImagenes+"yugioh%20wpp.png";
    File direccionMusica;
    Media musicaDeFondo;
	MediaPlayer reproductor;
	
    public ContenedorDeBienvenida(Stage stage, Scene proximaEscena) {

        super();
        
        this.direccionMusica = new File("src/viewSupportFiles/Hollow%20Knight%20OST%20-%20Greenpath.wav");
        
        String direccionArreglada = this.direccionMusica.toURI().toString();
        
        direccionArreglada = direccionArreglada.replaceAll("2520", "20");
        
        
        this.musicaDeFondo = new Media(direccionArreglada);
        this.reproductor= new MediaPlayer(this.musicaDeFondo);
        this.reproductor.setAutoPlay(true);
        this.reproductor.setVolume(0.2);
        
        this.stage = stage;

        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Button botonComenzarElDuelo = new Button("Es hora del duelo");
        BotonComenzarElDueloHandler botonEntrarHandler = new BotonComenzarElDueloHandler(stage, proximaEscena,reproductor);
        botonComenzarElDuelo.setOnAction(botonEntrarHandler);
        
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD,22 ));
        etiqueta.setText("Bienvenido a Al-Go-Oh!");
        etiqueta.setTextFill(Color.web("#FFFAF0"));
        
        Label textoPresionar = new Label();
        textoPresionar.setFont(Font.font("Arial", FontWeight.BOLD,22 ));
        textoPresionar.setText("Presione el siguiente boton para comenzar el duelo:");
        textoPresionar.setTextFill(Color.web("#FFFAF0"));


        HBox cajaBotonDuelo = new HBox();
        cajaBotonDuelo.setSpacing(10);
        cajaBotonDuelo.getChildren().addAll(botonComenzarElDuelo);
        cajaBotonDuelo.setAlignment(Pos.CENTER);  
        
        HBox controlesMusicaDeFondo = new HBox();
        controlesMusicaDeFondo.setSpacing(10);
        controlesMusicaDeFondo.setAlignment(Pos.BOTTOM_RIGHT);  
        
        Button botonPlay = new Button("Play");
        BotonPlayMusicaDeFondoHandler playMusic = new BotonPlayMusicaDeFondoHandler(this.musicaDeFondo,this.reproductor);
        botonPlay.setOnAction(playMusic);

        Button botonPausa = new Button("Pausa");
        BotonPausaMusicaDeFondoHandler pauseMusic = new BotonPausaMusicaDeFondoHandler(this.musicaDeFondo,this.reproductor);
        botonPausa.setOnAction(pauseMusic);
       
        BotonStopMusicaDeFondoHandler stopMusic = new BotonStopMusicaDeFondoHandler(this.musicaDeFondo,this.reproductor);
        Button botonStop = new Button("Stop");
        botonStop.setOnAction(stopMusic);
        
        controlesMusicaDeFondo.getChildren().addAll(botonPausa,botonPlay,botonStop);
        
        HBox cajaTextoMusica = new HBox();
        cajaTextoMusica.setSpacing(20);
        cajaTextoMusica.setAlignment(Pos.BOTTOM_RIGHT); 
        
        Label musicaFondoTexto = new Label("Musica De Fondo:");
        musicaFondoTexto.setFont(Font.font("Arial", FontWeight.BOLD,22 ));
        musicaFondoTexto.setTextFill(Color.web("#FFFAF0"));
        
        cajaTextoMusica.getChildren().add(musicaFondoTexto);
        
        VBox.setVgrow(cajaBotonDuelo, Priority.ALWAYS);

        this.getChildren().addAll(etiqueta,textoPresionar,cajaBotonDuelo,cajaTextoMusica,controlesMusicaDeFondo);
    }

}
