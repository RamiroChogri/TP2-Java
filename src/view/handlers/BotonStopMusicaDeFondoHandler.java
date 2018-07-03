package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonStopMusicaDeFondoHandler implements EventHandler<ActionEvent>{
	
	Media musicaDeFondo;
	MediaPlayer reproductor;
	
	public BotonStopMusicaDeFondoHandler(Media musicaDeFondo , MediaPlayer reproductor) {
		this.musicaDeFondo = musicaDeFondo;
		this.reproductor = reproductor;
	}
	
	public void handle(ActionEvent arg0) {
		this.reproductor.stop();
	}

}
