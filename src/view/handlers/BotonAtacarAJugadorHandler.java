package view.handlers;

import cartas.Atacable;
import exceptions.NoSePuedeAtacarAlJugadorDirectamenteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;

public class BotonAtacarAJugadorHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	private CajaConsola consola;
	private Jugador jugadorEnemigo;
	
	public BotonAtacarAJugadorHandler(Atacable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo, Jugador jugadorAAtacar) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		this.jugadorEnemigo = jugadorAAtacar;
	}
	
	@Override
    public void handle(ActionEvent event) {
		
		try {
			this.jugador.atacar(this.carta, this.jugadorEnemigo);
			
			this.carta.setAtacoEsteTurno(true);
			
			if (duelo.estaYugiEnTurno()) {
				cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			} else {
				cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
			}
		} catch (NoSePuedeAtacarAlJugadorDirectamenteException e) {
			//No hace nada
		}
	
	}

}
