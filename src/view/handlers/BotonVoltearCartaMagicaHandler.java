package view.handlers;

import cartas.Activable;
import cartas.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;
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
		CajaConsola.agregarMensaje("Se activo el efecto de la carta " + this.carta.obtenerNombre());
		if (duelo.estaYugiEnTurno()) {
    		cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}