package view;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Colocable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import jugador.Jugador;
import partida.Partida;
import viewSupportFiles.PathArchivos;

public class ManoJugador extends HBox implements PathArchivos {

	private LinkedList<EspacioCartaEnMano> espaciosEnMano;
	private Jugador jugadorDeLaMano;
	private Partida partida;
	private CajaCampo cajaCampo;
	
	public ManoJugador(Partida duelo, Jugador jugadorDeLaMano, CajaCampo cajaCampoRecibida) {
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(15);
		this.espaciosEnMano = new LinkedList<EspacioCartaEnMano>();
		this.jugadorDeLaMano = jugadorDeLaMano;
		this.partida = duelo; 
		this.cajaCampo = cajaCampoRecibida;
	}
	
	
	public void darVueltaCartasEnManoJugador(CajaInformacion cajaInformacion) {
		
		LinkedList<Colocable> cartasEnMano = this.jugadorDeLaMano.obtenerCartasEnMano();
		
		this.limpiarPosiciones();
		Colocable cartaActual = null;
		Image imagen;
		Iterator<Colocable> posicionesIterador = cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			this.espaciosEnMano.add(new EspacioCartaEnMano(cajaInformacion, this.partida, cartaActual, this.jugadorDeLaMano ,this.cajaCampo));
			this.espaciosEnMano.getLast().pintarCartaBocaAbajo(imagen);
			this.getChildren().add(this.espaciosEnMano.getLast());
		}
		
		
		
	}
	
	public void pintarCartasEnManoJugador(CajaInformacion cajaInformacion) {
		
		LinkedList<Colocable> cartasEnMano = this.jugadorDeLaMano.obtenerCartasEnMano();
		
		this.limpiarPosiciones();
		Colocable cartaActual = null;
		Image imagen;
		Iterator<Colocable> posicionesIterador = cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			this.espaciosEnMano.add(new EspacioCartaEnMano(cajaInformacion, this.partida, cartaActual, this.jugadorDeLaMano ,this.cajaCampo));
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
