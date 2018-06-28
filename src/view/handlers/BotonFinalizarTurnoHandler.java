package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.ContenedorDelDuelo;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private Partida duelo;
	private Jugador jugadorEnTurno;
	private ContenedorDelDuelo contenedorDelDuelo;
	
	public BotonFinalizarTurnoHandler(Partida partidaAColocar, Jugador jugadorAColocar, ContenedorDelDuelo contenedorAColocar) {
		this.duelo = partidaAColocar;
		this.jugadorEnTurno = jugadorAColocar;
		this.contenedorDelDuelo = contenedorAColocar;
	}
	
	public void handle(ActionEvent actionEvent) {
        this.duelo.finalizarTurno();
        this.jugadorEnTurno = this.duelo.obtenerJugadorEnTurno();
        
        if (this.duelo.estaYugiEnTurno()) {
        	this.contenedorDelDuelo.actualizarVistaYugiEnTurno(this.jugadorEnTurno, this.jugadorEnTurno.obtenerJugadorEnemigo());
        } else {
        	this.contenedorDelDuelo.actualizarVistaKaibaEnTurno(this.jugadorEnTurno, this.jugadorEnTurno.obtenerJugadorEnemigo());
        }
    }
}
