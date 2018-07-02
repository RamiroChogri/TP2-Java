package view.handlers;

import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import exceptions.NoHayLugarVacioException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class BotonBocaAbajoHandler implements EventHandler<ActionEvent> {

	private Colocable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonBocaAbajoHandler(Colocable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
    	EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
		try {
			jugador.colocar(carta, estadoCarta);
			jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
			if (duelo.estaYugiEnTurno()) {
				cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			} else {
				cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			}
		} catch (NoHayLugarVacioException e) {
			
		}
    }
	
}
