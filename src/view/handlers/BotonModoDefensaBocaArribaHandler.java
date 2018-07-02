package view.handlers;

import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jugador.Jugador;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;
import partida.Partida;
import view.CajaCampo;
import view.CajaConsola;
import view.ContenedorDelDuelo;

public class BotonModoDefensaBocaArribaHandler implements EventHandler<ActionEvent>{

	private Colocable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonModoDefensaBocaArribaHandler(Colocable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
        Modo modoACambiar = new ModoDefensa();
        EstadoCarta estadoACambiar = new EstadoCartaColocadaBocaArriba();
        try {
        	try {
        		carta.cambiarA(modoACambiar);
        		jugador.colocar(carta, estadoACambiar);
        		jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		duelo.setSeJugoCartaMonstruo();
        		CajaConsola.agregarMensaje("Se coloco la carta " + this.carta.obtenerNombre() + " boca arriba en " + modoACambiar.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
        	} catch (NoHaySuficientesMonstruosParaSacrificarException e) {
        	
        	} 
        }catch (NoHayLugarVacioException e) {
    	
        }
    }
}
