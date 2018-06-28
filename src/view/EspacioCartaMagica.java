package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;
import viewSupportFiles.PathArchivos;

public class EspacioCartaMagica extends StackPane implements PathArchivos{
	
	ImageView imagenCarta;
	Image cardBack;
	CajaInformacion cajaInformacion;
	
	public EspacioCartaMagica(CajaInformacion informacion,Jugador jugadorDuenio) {
		
		this.cajaInformacion = informacion;
		
		Rectangle rectanguloAtaque = new Rectangle();
		rectanguloAtaque.setWidth(60);
		rectanguloAtaque.setHeight(100);
		rectanguloAtaque.setStroke(Color.WHITE);
		
		this.imagenCarta = null;
		this.cardBack = new Image( pathDePackCartas + "cardBackAlgo.png" );
		
		
		this.getChildren().addAll(rectanguloAtaque);
		this.setAlignment(Pos.CENTER);
	}
	
	public void pintarCartaBocaAbajo(Image imagen) {
		ImageView imagenCarta = new ImageView(this.cardBack);
		imagenCarta.setFitWidth(60);
		imagenCarta.setFitHeight(100);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,this.cajaInformacion);
		imagenCarta.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(this.cajaInformacion);
		imagenCarta.setOnMouseExited(sacarDeZoom);
		
		this.getChildren().add(imagenCarta);
	}
	
	public void pintarCartaBocaArriba(Image imagen) {
		ImageView imagenCarta = new ImageView(imagen);
		imagenCarta.setFitWidth(60);
		imagenCarta.setFitHeight(100);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
		imagenCarta.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
		imagenCarta.setOnMouseExited(sacarDeZoom);
		 
		this.getChildren().add(imagenCarta);
	}
}
