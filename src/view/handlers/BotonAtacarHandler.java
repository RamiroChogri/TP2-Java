package view.handlers;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Atacable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	private CajaConsola consola;
	private Atacable cartaMonstruoEnemiga;
	
	public BotonAtacarHandler(Atacable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo, Atacable cartaMonstruoAAtacar) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		this.cartaMonstruoEnemiga = cartaMonstruoAAtacar;
	}
	
	@Override
    public void handle(ActionEvent event) {
		
		this.jugador.atacar(this.carta, this.cartaMonstruoEnemiga);
		
		if (!carta.estaDestruida()) {
			this.carta.setAtacoEsteTurno(true);
		}
		
	    if (duelo.estaYugiEnTurno()) {
			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		} else {
			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		}
	
	}

}
