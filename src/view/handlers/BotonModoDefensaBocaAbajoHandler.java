package view.handlers;

import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaAbajo;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import modos.Modo;
import modos.ModoDefensa;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class BotonModoDefensaBocaAbajoHandler implements EventHandler<ActionEvent>{
	
	private Colocable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonModoDefensaBocaAbajoHandler(Colocable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
        Modo modoACambiar = new ModoDefensa();
        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaAbajo();
    	try {
    		try {
    			carta.cambiarA(modoACambiar);
    			jugador.colocar(carta, estadoACambiar);
    			jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
    			duelo.setSeJugoCartaMonstruo();
    			if (duelo.estaYugiEnTurno()) {
    				cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    			} else {
    				cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    			}
    		} catch (NoHaySuficientesMonstruosParaSacrificarException e) {
    		
    		}
    	}  catch (NoHayLugarVacioException e) {
    		
    	}
    }

}
