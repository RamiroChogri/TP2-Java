package view.handlers;

import cartas.Activable;
import cartas.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;

public class BotonVoltearCartaMagicaHandler implements EventHandler<ActionEvent> {

	private Activable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public BotonVoltearCartaMagicaHandler(Activable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
		this.jugador.voltearCarta(this.carta);
    	if (duelo.estaYugiEnTurno()) {
    		cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}