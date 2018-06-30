package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonPlayMusicaDeFondoHandler implements EventHandler<ActionEvent> {

	Media musicaDeFondo;
	MediaPlayer reproductor;
	
	public BotonPlayMusicaDeFondoHandler(Media musicaDeFondo , MediaPlayer reproductor) {
		this.musicaDeFondo = musicaDeFondo;
		this.reproductor = reproductor;
	}
	
	public void handle(ActionEvent arg0) {
		this.reproductor.play();
	}

}
