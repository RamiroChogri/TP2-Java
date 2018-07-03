package view.handlers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import viewSupportFiles.PathArchivos;

public class BotonComenzarElDueloHandler  implements EventHandler<ActionEvent> , PathArchivos{
	   	
		Stage stage;
	    Scene nuevaEscena;
	    Media musicaComienzoDelDuelo;
	    MediaPlayer reproductor;
	    File direccionMusica;
	    MediaPlayer reproductorDeMusicaDeFondo;
	    MediaPlayer reproductorBatalla;
	    
	    public BotonComenzarElDueloHandler(Stage stage, Scene escenaSiguiente,MediaPlayer reproductorDeMusicaDeFondo) {
	    	
	    	this.stage = stage;
	        this.nuevaEscena = escenaSiguiente;
	       
	        ///////
	        this.direccionMusica = new File("src/viewSupportFiles/ES%20HORA%20DE%20DE%20DE%20DE%20DE%20DEL%20DUELO!.wav");
	        
	        String direccionArreglada = this.direccionMusica.toURI().toString();
	        
	        direccionArreglada = direccionArreglada.replaceAll("2520", "20");
	        ///////
	        
	        
	        this.musicaComienzoDelDuelo = new Media(direccionArreglada);
	        this.reproductor = new MediaPlayer(this.musicaComienzoDelDuelo);
	        this.reproductor.setVolume(1);
	        this.reproductorDeMusicaDeFondo = reproductorDeMusicaDeFondo;

	    }

	    public void handle(ActionEvent actionEvent) {
	        stage.setScene(nuevaEscena);
	        stage.setFullScreenExitHint("");
	        stage.setFullScreen(true);
	        this.reproductorDeMusicaDeFondo.stop();
	        this.reproductor.play();
	    }
	}


