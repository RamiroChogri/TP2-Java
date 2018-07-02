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
import view.ContenedorDelDuelo;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	private CajaConsola consola;
	private Atacable cartaMonstruoEnemiga;
	
	public BotonAtacarHandler(Atacable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo, Atacable cartaMonstruoAAtacar) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		this.cartaMonstruoEnemiga = cartaMonstruoAAtacar;
	}
	
	@Override
    public void handle(ActionEvent event) {
		
		this.jugador.atacar(this.carta, this.cartaMonstruoEnemiga);
		
		CajaConsola.agregarMensaje("La carta " + this.carta.obtenerNombre() + " ataco a la carta " + this.cartaMonstruoEnemiga.obtenerNombre());
		
		if (!carta.estaDestruida()) {
			this.carta.setAtacoEsteTurno(true);
		}
		
	    if (duelo.estaYugiEnTurno()) {
			cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		} else {
			cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		}
	
	}

}
