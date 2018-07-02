package view;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Colocable;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import jugador.Jugador;
import partida.Partida;
import viewSupportFiles.PathArchivos;

public class ManoJugador extends ScrollPane implements PathArchivos {

	private LinkedList<EspacioCartaEnMano> espaciosEnMano;
	private Jugador jugadorDeLaMano;
	private Partida partida;
	private CajaCampo cajaCampo;
	private HBox mano;
	
	public ManoJugador(Partida duelo, Jugador jugadorDeLaMano, CajaCampo cajaCampoRecibida) {
//		this.setAlignment(Pos.BOTTOM_CENTER);
//		this.setSpacing(15);
		this.mano = new HBox();
		this.mano.setAlignment(Pos.CENTER);
		this.mano.setSpacing(15);
		
		HBox.setHgrow(mano, Priority.ALWAYS);
		
		this.mano.setStyle("-fx-background-color: BLACK");
		this.setStyle("-fx-background: rgb(0,0,0);");
		
		this.setContent(mano);
		this.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		this.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		
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
			this.mano.getChildren().add(this.espaciosEnMano.getLast());
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
			this.mano.getChildren().add(this.espaciosEnMano.getLast());
		}
		
	}
	
	private void limpiarPosiciones() {
		
		Iterator<EspacioCartaEnMano> posicionesIterador = espaciosEnMano.iterator();
		EspacioCartaEnMano espacioActual;
		while(posicionesIterador.hasNext()) {
			espacioActual = posicionesIterador.next();
			this.mano.getChildren().remove(espacioActual);
		}
		this.espaciosEnMano.clear();
	}
		
}
