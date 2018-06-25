package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonPlayMusicaDeFondoHandler implements EventHandler<ActionEvent> {

	Media musicaDeFondo;
	MediaPlayer reproductor;
	Button botonPausa;
	
	public BotonPlayMusicaDeFondoHandler(Media musicaDeFondo , MediaPlayer reproductor) {
		this.musicaDeFondo = musicaDeFondo;
		this.reproductor = reproductor;
		this.botonPausa = null;
	}
	
	public void setBotonPausa(Button botonPausa) {
		this.botonPausa = botonPausa;
	}
	
	public void handle(ActionEvent arg0) {
		this.reproductor.play();
		this.botonPausa.requestFocus();
	}

}
