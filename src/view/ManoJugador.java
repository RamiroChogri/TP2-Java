package view;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Colocable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import viewSupportFiles.PathArchivos;

public class ManoJugador extends HBox implements PathArchivos {

	private LinkedList<EspacioCartaEnMano> espaciosEnMano;
	
	public ManoJugador() {
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(15);
		this.espaciosEnMano = new LinkedList<EspacioCartaEnMano>();

	}
	
	public void agregarCarta() {
		
	}
	
	public void darVueltaCartasEnManoJugador(CajaInformacion cajaInformacion, LinkedList<Colocable> cartasEnMano) {
		this.limpiarPosiciones();
		Colocable cartaActual = null;
		Image imagen;
		Iterator<Colocable> posicionesIterador = cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			this.espaciosEnMano.add(new EspacioCartaEnMano(cajaInformacion));
			this.espaciosEnMano.getLast().pintarCartaBocaAbajo(imagen);
			this.getChildren().add(this.espaciosEnMano.getLast());
		}
		
		
		
	}
	
	public void pintarCartasEnManoJugador(CajaInformacion cajaInformacion, LinkedList<Colocable> cartasEnMano) {
		
		this.limpiarPosiciones();
		Colocable cartaActual = null;
		Image imagen;
		Iterator<Colocable> posicionesIterador = cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			this.espaciosEnMano.add(new EspacioCartaEnMano(cajaInformacion));
			this.espaciosEnMano.getLast().pintarCartaBocaArriba(imagen);
			this.getChildren().add(this.espaciosEnMano.getLast());
		}
		
	}
	
	private void limpiarPosiciones() {
		
		Iterator<EspacioCartaEnMano> posicionesIterador = espaciosEnMano.iterator();
		EspacioCartaEnMano espacioActual;
		while(posicionesIterador.hasNext()) {
			espacioActual = posicionesIterador.next();
			this.getChildren().remove(espacioActual);
		}
		
	}
		
}
