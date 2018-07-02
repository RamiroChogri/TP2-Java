package view.handlers;

import cartas.Atacable;
import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import modos.*;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class BotonRotarMonstruoHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonRotarMonstruoHandler(Atacable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
        Modo modoACambiar;
        if (this.carta.estaEnModoAtaque()) {
        	modoACambiar = new ModoDefensa();
    		carta.cambiarA(modoACambiar);
        } else {
        	modoACambiar = new ModoAtaque();
        	carta.cambiarA(modoACambiar);
        }
        
        this.carta.setSeCambioElEstadoEsteTurno(true);
        			
    	if (duelo.estaYugiEnTurno()) {
    		cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}
