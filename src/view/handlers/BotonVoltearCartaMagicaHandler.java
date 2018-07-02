package view.handlers;

import cartas.Activable;
import cartas.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class BotonVoltearCartaMagicaHandler implements EventHandler<ActionEvent> {

	private Activable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonVoltearCartaMagicaHandler(Activable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
		this.jugador.voltearCarta(this.carta);
    	if (duelo.estaYugiEnTurno()) {
    		cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}