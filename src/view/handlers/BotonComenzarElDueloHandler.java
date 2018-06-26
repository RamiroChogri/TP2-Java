package view.handlers;

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
	    String pathAHoraDelDuelo = pathDeMusica+ "ES%20HORA%20DE%20DE%20DE%20DE%20DE%20DEL%20DUELO!.wav";
	    MediaPlayer reproductorDeMusicaDeFondo;
	    
	    public BotonComenzarElDueloHandler(Stage stage, Scene escenaSiguiente,MediaPlayer reproductorDeMusicaDeFondo) {
	        this.stage = stage;
	        this.nuevaEscena = escenaSiguiente;
	        this.musicaComienzoDelDuelo = new Media(pathAHoraDelDuelo);
	        this.reproductor = new MediaPlayer(this.musicaComienzoDelDuelo);
	        this.reproductor.setVolume(0.5);
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


