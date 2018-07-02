package view;

import cartas.Colocable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import partida.Partida;
import view.handlers.ClickEnCartaEnManoHandler;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;
import viewSupportFiles.PathArchivos;
import jugador.*;

public class EspacioCartaEnMano extends StackPane implements PathArchivos{
	
	private ImageView imagenCarta;
	private ImageView cardBack;
	private CajaInformacion cajaInformacion;
	private Partida partida;
	private Colocable carta;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	
	public EspacioCartaEnMano(CajaInformacion informacion, Partida duelo, Colocable cartaActual, Jugador jugadorAColocar, ContenedorDelDuelo cajaDueloRecibida) {
		
		this.cajaInformacion = informacion;
		
		Rectangle rectanguloAtaque = new Rectangle();
		rectanguloAtaque.setWidth(60);
		rectanguloAtaque.setHeight(100);
		rectanguloAtaque.setStroke(Color.WHITE);
		
		this.imagenCarta = null;
		this.cardBack = new ImageView (new Image( pathDePackCartas + "cardBackAlgo.png" ));
		this.cardBack.setFitWidth(60);
		this.cardBack.setFitHeight(100);
		this.cardBack = new ImageView (new Image( pathDePackCartas + "cardBackAlgo.png" ));
		this.cardBack.setFitWidth(60);
		this.cardBack.setFitHeight(100);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(this.cardBack,this.cajaInformacion);
		this.cardBack.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(this.cajaInformacion);
		this.cardBack.setOnMouseExited(sacarDeZoom);
		
		this.cajaDuelo = cajaDueloRecibida;
		this.partida = duelo;
		this.carta = cartaActual;
		this.jugador = jugadorAColocar;
		
		this.getChildren().addAll(rectanguloAtaque);
		this.setAlignment(Pos.CENTER);
	}
	
	public void pintarCartaBocaAbajo(Image imagen) {
//		ImageView imagenCarta = new ImageView(this.cardBack);
//		imagenCarta.setFitWidth(60);
//		imagenCarta.setFitHeight(100);
//		
//		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,this.cajaInformacion);
//		imagenCarta.setOnMouseEntered(ponerEnZoom);
//		 
//		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(this.cajaInformacion);
//		imagenCarta.setOnMouseExited(sacarDeZoom);
//		
		this.getChildren().add(this.cardBack);
	}
	
	public void pintarCartaBocaArriba(Image imagen) {
		this.imagenCarta = new ImageView(imagen);
		imagenCarta.setFitWidth(60);
		imagenCarta.setFitHeight(100);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
		imagenCarta.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
		imagenCarta.setOnMouseExited(sacarDeZoom);
		
		ClickEnCartaEnManoHandler verOpcionesDeColocacion = new ClickEnCartaEnManoHandler(this.cajaInformacion, this.partida, this.carta, this.jugador, this.cajaDuelo);
		imagenCarta.setOnContextMenuRequested(verOpcionesDeColocacion);
		
		
		this.getChildren().add(imagenCarta);
	}
}
