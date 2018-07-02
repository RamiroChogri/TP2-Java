package view.handlers;

import cartas.Atacable;
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

public class BotonVoltearMonstruoAModoAtaqueHandler implements EventHandler<ActionEvent> {

	private Atacable carta;
	private Partida duelo;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public BotonVoltearMonstruoAModoAtaqueHandler(Atacable carta, Partida duelo, Jugador jugador, ContenedorDelDuelo cajaDuelo) {
		this.carta = carta;
		this.duelo = duelo;
		this.jugador = jugador;
		this.cajaDuelo = cajaDuelo;
		
	}
	
	@Override
    public void handle(ActionEvent event) {
        Modo modoACambiar;
        modoACambiar = new ModoAtaque();	
        carta.cambiarA(modoACambiar);
        this.jugador.voltearCarta(this.carta);
        this.carta.setSeCambioElEstadoEsteTurno(true);
        CajaConsola.agregarMensaje("Se volteo la carta " + this.carta.obtenerNombre() + " y se coloco en " + modoACambiar.obtenerNombre());
        if (duelo.estaYugiEnTurno()) {
    		cajaDuelo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	} else {
    		cajaDuelo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
    	}
    }
}
