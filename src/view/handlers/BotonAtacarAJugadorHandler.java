package view.handlers;

import cartas.Atacable;
import exceptions.NoSePuedeAtacarAlJugadorDirectamenteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;
import view.ContenedorDelDuelo;

public class BotonAtacarAJugadorHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	private CajaConsola consola;
	private Jugador jugadorEnemigo;
	
	public BotonAtacarAJugadorHandler(Atacable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo, Jugador jugadorAAtacar) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		this.jugadorEnemigo = jugadorAAtacar;
	}
	
	@Override
    public void handle(ActionEvent event) {
		
		try {
			this.jugador.atacar(this.carta, this.jugadorEnemigo);
			
			this.carta.setAtacoEsteTurno(true);
			
			CajaConsola.agregarMensaje("La carta " + this.carta.obtenerNombre() + " ataco al jugador " + this.jugadorEnemigo.obtenerNombre());
			
			if (duelo.estaYugiEnTurno()) {
				cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			} else {
				cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			}
		} catch (NoSePuedeAtacarAlJugadorDirectamenteException e) {
			//No hace nada
		}
	
	}

}
