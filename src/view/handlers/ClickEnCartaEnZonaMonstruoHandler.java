package view.handlers;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Atacable;
import cartas.CartaCampo;
import cartas.CartaMagica;
import cartas.CartaTrampa;
import cartas.Colocable;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.CajaInformacion;
import view.ContenedorDelDuelo;

public class ClickEnCartaEnZonaMonstruoHandler implements EventHandler<ContextMenuEvent> {

	private Partida duelo;
	private Atacable carta;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public ClickEnCartaEnZonaMonstruoHandler(Partida partidaAColocar, Atacable cartaAColocar, Jugador jugadorEnTurno, ContenedorDelDuelo cajaDueloRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaDuelo = cajaDueloRecibida;
	}
	
	
	public void handle(ContextMenuEvent t) {
		if (this.carta.estaEnModoAtaque() && this.duelo.estaEnFaseDeAtaqueYTrampas() && 
				!this.carta.atacoEsteTurno() && !this.duelo.esPrimerTurno()) {
			
    		this.menuCartaAtacar(t);
		} else if (this.carta.estaEnModoAtaque() && this.duelo.estaEnFaseDePreparacion()) {
			this.menuCartaEnModoAtaque(t);
    	} else if (this.carta.estaColocadaBocaArriba() && this.duelo.estaEnFaseDePreparacion()) {
    		this.menuCartaBocaArribaEnModoDefensa(t);
    	} else if (this.duelo.estaEnFaseDePreparacion()) {
    		this.menuCartaBocaAbajoEnModoDefensa(t);
    	}
	}
	
	
	public void menuCartaAtacar(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem atacar = new MenuItem("Intentar atacar a " + this.jugador.obtenerJugadorEnemigo().obtenerNombre());
    	
    	BotonAtacarAJugadorHandler atacarAJugadorHandler = new BotonAtacarAJugadorHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo, this.jugador.obtenerJugadorEnemigo());
    	atacar.setOnAction(atacarAJugadorHandler);
    			
    	contextMenu.getItems().add(atacar);
    	
    	LinkedList<Atacable> cartasEnemigo = jugador.obtenerJugadorEnemigo().obtenerMonstruosColocados();
		Iterator<Atacable> posicionesIterador = cartasEnemigo.iterator();		
		Atacable cartaMonstruoActual;
	    
		while (posicionesIterador.hasNext()) {
	    	
	    	cartaMonstruoActual = posicionesIterador.next();
	    	if (cartaMonstruoActual.estaColocadaBocaArriba()) {
	    		atacar = new MenuItem("Atacar a " + cartaMonstruoActual.obtenerNombre());
	    	} else {
	    		atacar = new MenuItem("Atacar a monstruo boca abajo");
	    	}
	    	BotonAtacarHandler atacarHandler = new BotonAtacarHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo, cartaMonstruoActual);
	    	atacar.setOnAction(atacarHandler);
	    			
	    	contextMenu.getItems().add(atacar);
	    
	    }
		
		MenuItem cancelar = new MenuItem("Cancelar");
		contextMenu.getItems().add(cancelar);
		
		BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaEnModoAtaque(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	
    	MenuItem bocaArribaModoDefensa = new MenuItem("Cambiar a Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoDefensa, cancelar);    	
    	
    	BotonRotarMonstruoHandler modoDefensaBocaArribaHandler = new BotonRotarMonstruoHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaBocaArribaEnModoDefensa(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Cambiar a Modo Ataque");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, cancelar);    	
    	
    	BotonRotarMonstruoHandler modoAtaqueBocaArribaHandler = new BotonRotarMonstruoHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaBocaAbajoEnModoDefensa(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Colocar boca arriba en Modo Ataque");
    	MenuItem bocaArribaModoDefensa = new MenuItem("Colocar boca arriba en Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, bocaArribaModoDefensa, cancelar);    	
    	
    	BotonVoltearMonstruoAModoAtaqueHandler modoAtaqueBocaArribaHandler = new BotonVoltearMonstruoAModoAtaqueHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonVoltearMonstruoAModoDefensaHandler modoDefensaBocaArribaHandler = new BotonVoltearMonstruoAModoDefensaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
	}
	
}
