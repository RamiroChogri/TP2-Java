package view;

import cartas.Colocable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import partida.Partida;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;
import viewSupportFiles.PathArchivos;

public class EspacioCartaMagica extends StackPane implements PathArchivos{
	
	private ImageView imagenCarta;
	private ImageView cardBack;
	private CajaInformacion cajaInformacion;
	private	Jugador jugadorDuenio;
	private Colocable carta;
	private Partida partida;
	private ContenedorDelDuelo cajaDuelo;
	
	public EspacioCartaMagica(CajaInformacion informacion, Partida duelo, Jugador jugadorDuenio, ContenedorDelDuelo cajaDueloRecibida) {
		
		this.cajaInformacion = informacion;
		this.jugadorDuenio = jugadorDuenio;
		this.partida = duelo;
		this.cajaDuelo = cajaDueloRecibida;
		
		Rectangle rectanguloAtaque = new Rectangle();
		rectanguloAtaque.setWidth(60);
		rectanguloAtaque.setHeight(100);
		rectanguloAtaque.setStroke(Color.WHITE);
		
		this.imagenCarta = null;
		this.cardBack = new ImageView(new Image( pathDePackCartas + "cardBackAlgo.png" ));
		
		
		this.getChildren().addAll(rectanguloAtaque);
		this.setAlignment(Pos.CENTER);
	}
	
	public void pintarCartaBocaAbajo(Image imagen, Colocable cartaRecibida) {
		
		this.cardBack.setFitWidth(60);
		this.cardBack.setFitHeight(100);
		this.carta = cartaRecibida;
		
		this.imagenCarta = new ImageView(imagen);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(this.imagenCarta,this.cajaInformacion);
		this.cardBack.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(this.cajaInformacion);
		this.cardBack.setOnMouseExited(sacarDeZoom);
		
		if (this.jugadorDuenio == this.partida.obtenerJugadorEnTurno() && this.partida.estaEnFaseFinal()) {
			this.carta.clickEnZona(this.partida, this.jugadorDuenio, this.cajaDuelo, this.cardBack);
		}
			
		this.getChildren().add(this.cardBack);
	}
	
	public void pintarCartaBocaArriba(Image imagen, Colocable cartaRecibida) {
		this.carta = cartaRecibida;
		
		this.imagenCarta = new ImageView(imagen);
		this.imagenCarta.setFitWidth(60);
		this.imagenCarta.setFitHeight(100);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(this.imagenCarta,cajaInformacion);
		this.imagenCarta.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
		this.imagenCarta.setOnMouseExited(sacarDeZoom);
		 
		this.getChildren().add(this.imagenCarta);
	}

	public void limpiar() {
		if(this.getChildren().contains(this.imagenCarta)) {
		this.getChildren().remove(this.imagenCarta);
		this.imagenCarta = null;
		}
		else this.getChildren().remove(this.cardBack);
		
		this.carta = null;
	}
}
