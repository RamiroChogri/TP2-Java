package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import partida.Partida;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private Partida duelo;
	
	public BotonFinalizarTurnoHandler(Partida partidaAColocar) {
		this.duelo = partidaAColocar;
	}
	
	public void handle(ActionEvent actionEvent) {
        this.duelo.finalizarTurno();
    }
}
