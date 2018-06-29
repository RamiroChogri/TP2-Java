package view.handlers;

import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayLugarVacioException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;

public class BotonBocaArribaHandler implements EventHandler<ActionEvent> {

	private Colocable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public BotonBocaArribaHandler(Colocable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
    	EstadoCarta estadoCarta = new EstadoCartaColocadaBocaArriba();
		try {
			jugador.colocar(carta, estadoCarta);
			jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
			if (duelo.estaYugiEnTurno()) {
				cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			} else {
				cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			}
		} catch (NoHayLugarVacioException e) {
			
		}
    }
	
}
