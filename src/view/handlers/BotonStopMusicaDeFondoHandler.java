package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonStopMusicaDeFondoHandler implements EventHandler<ActionEvent>{
	
	Media musicaDeFondo;
	MediaPlayer reproductor;
	Button botonPlay;
	
	public BotonStopMusicaDeFondoHandler(Media musicaDeFondo , MediaPlayer reproductor, Button botonPlay) {
		this.musicaDeFondo = musicaDeFondo;
		this.reproductor = reproductor;
		this.botonPlay = botonPlay;
	}
	
	public void handle(ActionEvent arg0) {
		this.reproductor.stop();
		this.botonPlay.requestFocus();
	}

}
