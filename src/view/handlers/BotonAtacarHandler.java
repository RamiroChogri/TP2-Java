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
	
	public BotonAtacarHandler(Atacable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
	}
	
	@Override
    public void handle(ActionEvent event) {
		LinkedList<Atacable> cartasEnemigo = jugador.obtenerJugadorEnemigo().obtenerMonstruosColocados();
		Iterator<Atacable> posicionesIterador = cartasEnemigo.iterator();		
		Atacable cartaMonstruoActual;
	    if (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	this.jugador.atacar(this.carta, cartaMonstruoActual);
	    	CajaConsola.agregarMensaje(this.carta.obtenerNombre()+" atacó a "+cartaMonstruoActual.obtenerNombre());
	    }
	    if (duelo.estaYugiEnTurno()) {
			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		} else {
			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
		}
	
	}

}
