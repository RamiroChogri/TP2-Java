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
import view.ContenedorDelDuelo;
import view.ManoJugador;
import view.handlers.*;

public class ClickEnCartaEnManoHandler implements EventHandler<ContextMenuEvent> {
	
	private Partida duelo;
	private Colocable carta;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	private CajaInformacion cajaInf;
	
	public ClickEnCartaEnManoHandler(CajaInformacion cajaInfRecibida, Partida partidaAColocar, Colocable cartaAColocar, Jugador jugadorEnTurno, ContenedorDelDuelo cajaDueloRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaDuelo = cajaDueloRecibida;
		this.cajaInf = cajaInfRecibida;
	}
	
	public void handle(ContextMenuEvent t) {
		//Desde la mano son indistinguibles las cartas (son todas colocables y solo pueden
		//usar metodos declarados en la interfaz colocable)
        if (duelo.estaEnFaseDePreparacion()) {
        	if (this.carta.esAtacable() && !this.duelo.seJugoUnaCartaMonstruoEsteTurno()) {
        		this.menuCartaAtacable(t);
        	} else if (this.carta.getClass() == CartaMagica.class) {
        		this.menuCartaMagica(t);
        	} else if (this.carta.getClass() == CartaTrampa.class) {
        		this.menuCartaTrampa(t);
        	} else if (this.carta.getClass() == CartaCampo.class) {
        		this.menuCartaCampo(t);
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
    	
    	BotonModoAtaqueBocaArribaHandler modoAtaqueBocaArribaHandler = new BotonModoAtaqueBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonModoDefensaBocaArribaHandler modoDefensaBocaArribaHandler = new BotonModoDefensaBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonModoDefensaBocaAbajoHandler modoDefensaBocaAbajoHandler = new BotonModoDefensaBocaAbajoHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaAbajoModoDefensa.setOnAction(modoDefensaBocaAbajoHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaMagica(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArriba = new MenuItem("Boca Arriba");
    	MenuItem bocaAbajo = new MenuItem("Boca Abajo");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArriba, bocaAbajo, cancelar);
    	
    	BotonBocaArribaHandler bocaArribaHandler = new BotonBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArriba.setOnAction(bocaArribaHandler);
    	
    	BotonBocaAbajoHandler bocaAbajoHandler = new BotonBocaAbajoHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaAbajo.setOnAction(bocaAbajoHandler);
    	
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
      	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
    }
	
	public void menuCartaTrampa(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaAbajo = new MenuItem("Boca Abajo");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaAbajo, cancelar);
    	
    	BotonBocaAbajoHandler bocaAbajoHandler = new BotonBocaAbajoHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaAbajo.setOnAction(bocaAbajoHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
      	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaCampo(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArriba = new MenuItem("Boca Arriba");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArriba, cancelar);
    	
    	BotonBocaArribaHandler bocaArribaHandler = new BotonBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArriba.setOnAction(bocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
      	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());		
	}
}