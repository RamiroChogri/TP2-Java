package view.handlers;

import cartas.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;

public class BotonVoltearMonstruoAModoDefensaHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public BotonVoltearMonstruoAModoDefensaHandler(Atacable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
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
