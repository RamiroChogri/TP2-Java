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

public class BotonRotarMonstruoHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public BotonRotarMonstruoHandler(Atacable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		
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
        			
    	if (duelo.estaYugiEnTurno()) {
    		cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}
