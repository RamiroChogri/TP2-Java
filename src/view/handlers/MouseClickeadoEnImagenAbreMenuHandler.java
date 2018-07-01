package view.handlers;

import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import jugador.Jugador;
import view.EspacioCartaMonstruo;

public class MouseClickeadoEnImagenAbreMenuHandler implements EventHandler<ContextMenuEvent> {

	ContextMenu opcionesCartaEnCampo;
	EspacioCartaMonstruo espacioCarta;
	
	public MouseClickeadoEnImagenAbreMenuHandler(Jugador jugador, EspacioCartaMonstruo espacioCarta) {
		this.opcionesCartaEnCampo = new ContextMenu();	
		this.espacioCarta = espacioCarta;
		MenuItem ponerEnModoAtaque = new MenuItem("Poner en modo ataque");
		MenuItem ponerEnModoDefensa = new MenuItem("Poner en modo defensa");
		MenuItem ponerEnModoDefensaBocaAbajo = new MenuItem("Poner en modo defensa boca abajo");
		
		this.opcionesCartaEnCampo.getItems().addAll(ponerEnModoAtaque,ponerEnModoDefensa,ponerEnModoDefensaBocaAbajo);
	}
	
	@Override
	public void handle(ContextMenuEvent arg0) {
		this.opcionesCartaEnCampo.show(this.espacioCarta, arg0.getX(), arg0.getY());
	}

}
