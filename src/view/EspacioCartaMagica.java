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
	ImageView cardBack;
	CajaInformacion cajaInformacion;
	
	public EspacioCartaMagica(CajaInformacion informacion,Jugador jugadorDuenio) {
		
		this.cajaInformacion = informacion;
		
		Rectangle rectanguloAtaque = new Rectangle();
		rectanguloAtaque.setWidth(60);
		rectanguloAtaque.setHeight(100);
		rectanguloAtaque.setStroke(Color.WHITE);
		
		this.imagenCarta = null;
		this.cardBack = new ImageView(new Image( pathDePackCartas + "cardBackAlgo.png" ));
		
		
		this.getChildren().addAll(rectanguloAtaque);
		this.setAlignment(Pos.CENTER);
	}
	
	public void pintarCartaBocaAbajo(Image imagen) {
		
		this.cardBack.setFitWidth(60);
		this.cardBack.setFitHeight(100);
		
		this.imagenCarta = new ImageView(imagen);
		
		MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(this.imagenCarta,this.cajaInformacion);
		this.cardBack.setOnMouseEntered(ponerEnZoom);
		 
		MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(this.cajaInformacion);
		this.cardBack.setOnMouseExited(sacarDeZoom);
		
		this.getChildren().add(this.cardBack);
	}
	
	public void pintarCartaBocaArriba(Image imagen) {
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
		if(this.getChildren().contains(this.imagenCarta))
		this.getChildren().remove(this.imagenCarta);
		else this.getChildren().remove(this.cardBack);
	}
}
