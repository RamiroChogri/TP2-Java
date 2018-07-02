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

public class ClickEnCartaEnZonaMonstruoHandler implements EventHandler<ContextMenuEvent> {

	private Partida duelo;
	private Atacable carta;
	private Jugador jugador;
	private CajaCampo cajaCampo;
	
	public ClickEnCartaEnZonaMonstruoHandler(Partida partidaAColocar, Atacable cartaAColocar, Jugador jugadorEnTurno, CajaCampo cajaCampoRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaCampo = cajaCampoRecibida;
	}
	
	
	public void handle(ContextMenuEvent t) {
		if (this.carta.estaEnModoAtaque()) {
    		this.menuCartaEnModoAtaque(t);
    	} else if (this.carta.estaColocadaBocaArriba()) {
    		this.menuCartaBocaArribaEnModoDefensa(t);
    	} else if (this.carta.getClass() == CartaTrampa.class) {
    		this.menuCartaBocaArribaEnModoDefensa(t);
    	}
	}
	
	
	public void menuCartaEnModoAtaque(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem atacar;
    	
    	LinkedList<Atacable> cartasEnemigo = jugador.obtenerJugadorEnemigo().obtenerMonstruosColocados();
		Iterator<Atacable> posicionesIterador = cartasEnemigo.iterator();		
		Atacable cartaMonstruoActual;
	    
		while (posicionesIterador.hasNext()) {
	    	
	    	cartaMonstruoActual = posicionesIterador.next();
	    	atacar = new MenuItem("Atacar a " + cartaMonstruoActual.obtenerNombre());
	    	
	    	BotonAtacarHandler atacarHandler = new BotonAtacarHandler(this.carta, this.duelo, this.jugador, this.cajaCampo, cartaMonstruoActual);
	    	atacar.setOnAction(atacarHandler);
	    			
	    	contextMenu.getItems().add(atacar);
	    
	    }
    	
    	
    	MenuItem bocaArribaModoDefensa = new MenuItem("Cambiar a Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoDefensa, cancelar);    	
    	
    	BotonRotarMonstruoHandler modoDefensaBocaArribaHandler = new BotonRotarMonstruoHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaBocaArribaEnModoDefensa(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Cambiar a Modo Ataque");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, cancelar);    	
    	
    	BotonRotarMonstruoHandler modoAtaqueBocaArribaHandler = new BotonRotarMonstruoHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
	}
	
	public void menuCartaBocaAbajoEnModoDefensa(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArribaModoAtaque = new MenuItem("Colocar boca arriba en Modo Ataque");
    	MenuItem bocaArribaModoDefensa = new MenuItem("Colocar boca arriba en Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArribaModoAtaque, bocaArribaModoDefensa, cancelar);    	
    	
    	BotonVoltearMonstruoAModoAtaqueHandler modoAtaqueBocaArribaHandler = new BotonVoltearMonstruoAModoAtaqueHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonVoltearMonstruoAModoDefensaHandler modoDefensaBocaArribaHandler = new BotonVoltearMonstruoAModoDefensaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
	}
	
}
