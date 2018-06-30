package view.handlers;

import cartas.Activable;
import cartas.CartaCampo;
import cartas.CartaMagica;
import cartas.CartaTrampa;
import cartas.Colocable;
import estadoCarta.*;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import jugador.Jugador;
import modos.*;
import partida.Partida;
import view.CajaCampo;
import view.CajaInformacion;
import view.ManoJugador;
import view.handlers.*;

public class ClickEnCartaEnManoHandler implements EventHandler<ContextMenuEvent> {
	
	private Partida duelo;
	private Colocable carta;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	private CajaInformacion cajaInf;
	
	public ClickEnCartaEnManoHandler(CajaInformacion cajaInfRecibida, Partida partidaAColocar, Colocable cartaAColocar, Jugador jugadorEnTurno, CajaCampo cajaCampoRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaCampo = cajaCampoRecibida;
		this.cajaInf = cajaInfRecibida;
	}
	
	public void handle(ContextMenuEvent t) {
        if (duelo.estaEnFaseDePreparacion()) {
        	if (this.carta.esAtacable() && !this.duelo.seJugoUnaCartaMonstruoEsteTurno()) {
        		this.menuCartaAtacable(t);
        	} else if (this.carta.getClass() == CartaMagica.class) {
        		this.menuCartaMagica(t);
        	} else if (this.carta.getClass() == CartaTrampa.class) {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaAbajo();
        		try {
        			this.jugador.colocar(carta, estadoCarta);
        			this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        			if (duelo.estaYugiEnTurno()) {
        				cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        			} else {
        				cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        			}
        		} catch (NoHayLugarVacioException e) {
        			
        		}
        	} else if (this.carta.getClass() == CartaCampo.class) {
        		EstadoCarta estadoCarta = new EstadoCartaColocadaBocaArriba();
        		this.jugador.colocar(carta, estadoCarta);
        		this.jugador.eliminarCartaDeLaMano(carta.obtenerNombre());
        		if (duelo.estaYugiEnTurno()) {
        			cajaCampo.actualizarVistaYugiEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		} else {
        			cajaCampo.actualizarVistaKaibaEnTurno(jugador, jugador.obtenerJugadorEnemigo());
        		}
        	}
        	
        }
    }
	
	public void menuCartaAtacable(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Colocar boca arriba en Modo Ataque");
    	MenuItem bocaArribaModoDefensa = new MenuItem("Colocar boca arriba en Modo Defensa");
    	MenuItem bocaAbajoModoDefensa = new MenuItem("Colocar boca abajo en Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, bocaArribaModoDefensa, bocaAbajoModoDefensa, cancelar);    	
    	
    	BotonModoAtaqueBocaArribaHandler modoAtaqueBocaArribaHandler = new BotonModoAtaqueBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonModoDefensaBocaArribaHandler modoDefensaBocaArribaHandler = new BotonModoDefensaBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonModoDefensaBocaAbajoHandler modoDefensaBocaAbajoHandler = new BotonModoDefensaBocaAbajoHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaAbajoModoDefensa.setOnAction(modoDefensaBocaAbajoHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaMagica(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArriba = new MenuItem("Boca Arriba");
    	MenuItem bocaAbajo = new MenuItem("Boca Abajo");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArriba, bocaAbajo, cancelar);
    	
    	BotonBocaArribaHandler bocaArribaHandler = new BotonBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArriba.setOnAction(bocaArribaHandler);
    	
    	BotonBocaAbajoHandler bocaAbajoHandler = new BotonBocaAbajoHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaAbajo.setOnAction(bocaAbajoHandler);
    	
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
      	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
    }
}