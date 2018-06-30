package view.handlers;

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
    	MenuItem atacar = new MenuItem("Atacar");
    	MenuItem bocaArribaModoDefensa = new MenuItem("Cambiar a Modo Defensa");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(atacar, bocaArribaModoDefensa, cancelar);    	
    	
    	BotonAtacarHandler atacarHandler = new BotonAtacarHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	atacar.setOnAction(atacarHandler);
    	
    	BotonModoDefensaBocaArribaHandler modoDefensaBocaArribaHandler = new BotonModoDefensaBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
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
    	
    	BotonModoAtaqueBocaArribaHandler modoAtaqueBocaArribaHandler = new BotonModoAtaqueBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
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
    	
    	BotonModoAtaqueBocaArribaHandler modoAtaqueBocaArribaHandler = new BotonModoAtaqueBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoAtaque.setOnAction(modoAtaqueBocaArribaHandler);
    	
    	BotonModoDefensaBocaArribaHandler modoDefensaBocaArribaHandler = new BotonModoDefensaBocaArribaHandler(this.carta, this.duelo, this.jugador, this.cajaCampo);
    	bocaArribaModoDefensa.setOnAction(modoDefensaBocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
    	contextMenu.show(cajaCampo, t.getSceneX(), t.getSceneY());
	}
	
}
