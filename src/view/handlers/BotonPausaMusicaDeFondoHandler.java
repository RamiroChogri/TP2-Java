package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonPausaMusicaDeFondoHandler implements EventHandler<ActionEvent> {

	Media musicaDeFondo;
	MediaPlayer reproductor;
	
	
	public BotonPausaMusicaDeFondoHandler(Media musicaDeFondo , MediaPlayer reproductor) {
		this.musicaDeFondo = musicaDeFondo;
		this.reproductor = reproductor;
	}
	
	public void handle(ActionEvent arg0) {
		this.reproductor.pause();
	}

}
