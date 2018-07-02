package view.handlers;

import cartas.Activable;
import cartas.Atacable;
import cartas.CartaTrampa;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import jugador.Jugador;
import partida.Partida;
import view.CajaCampo;
import view.ContenedorDelDuelo;

public class ClickEnCartaMagicaInvocadaHandler implements EventHandler<ContextMenuEvent> {

	private Partida duelo;
	private Activable carta;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public ClickEnCartaMagicaInvocadaHandler(Partida partidaAColocar, Activable cartaAColocar, Jugador jugadorEnTurno, ContenedorDelDuelo cajaDueloRecibida) {
		this.duelo = partidaAColocar;
		this.carta = cartaAColocar;
		this.jugador = jugadorEnTurno;
		this.cajaDuelo = cajaDueloRecibida;
	}
	
	public void handle(ContextMenuEvent t) {
		if (this.carta.estaColocadaBocaAbajo()) {
    		this.menuCartaMagica(t);
    	}
	}
	
	public void menuCartaMagica(ContextMenuEvent t) {
		ContextMenu contextMenu = new ContextMenu();
    	MenuItem bocaArriba = new MenuItem("Voltear");
    	MenuItem cancelar = new MenuItem("Cancelar");
    	contextMenu.getItems().addAll(bocaArriba, cancelar);
    	
    	BotonVoltearCartaMagicaHandler bocaArribaHandler = new BotonVoltearCartaMagicaHandler(this.carta, this.duelo, this.jugador, this.cajaDuelo);
    	bocaArriba.setOnAction(bocaArribaHandler);
    	
    	BotonCancelarHandler cancelarHandler = new BotonCancelarHandler();
    	cancelar.setOnAction(cancelarHandler);
    	
      	contextMenu.show(cajaDuelo, t.getSceneX(), t.getSceneY());
    }
	
}
