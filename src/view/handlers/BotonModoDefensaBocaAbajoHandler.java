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

public class BotonModoDefensaBocaAbajoHandler implements EventHandler<ActionEvent>{
	
	private Colocable carta;
	private Partida duelo;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public BotonModoDefensaBocaAbajoHandler(Colocable carta, Partida duelo, Jugador jugador, CajaCampo cajaCampo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaCampo = cajaCampo;
		
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
    				cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    			} else {
    				cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    			}
    		} catch (NoHaySuficientesMonstruosParaSacrificarException e) {
    		
    		}
    	}  catch (NoHayLugarVacioException e) {
    		
    	}
    }

}
