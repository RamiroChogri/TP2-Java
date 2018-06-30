package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseClickeadoEnImagenAbreMenuHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;
import viewSupportFiles.PathArchivos;

public class EspacioCarta extends StackPane implements PathArchivos{
	
	
	private ImageView imagenCarta;
	private ImageView cardBack;
	private	CajaInformacion cajaInformacion;
	private	Jugador jugadorDuenio;
	
		public EspacioCarta(CajaInformacion cajaInformacion, Jugador jugadorDuenio) {
			
			this.cajaInformacion = cajaInformacion;
			this.jugadorDuenio = jugadorDuenio;
			
			Rectangle rectanguloAtaque = new Rectangle();
			rectanguloAtaque.setWidth(60);
			rectanguloAtaque.setHeight(100);
			rectanguloAtaque.setStroke(Color.WHITE);
			
			Rectangle rectanguloDefensa = new Rectangle();
			rectanguloDefensa.setWidth(100);
			rectanguloDefensa.setHeight(60);
			rectanguloDefensa.setStroke(Color.WHITE);
			
			this.imagenCarta = null;
			this.cardBack = new ImageView(new Image(pathDePackCartas+"cardBackAlgo.png"));
			
			this.getChildren().addAll(rectanguloAtaque,rectanguloDefensa);
			this.setAlignment(Pos.CENTER);
			
		}
		
		public void pintarCartaEnModoAtaque(Image imagen) {
			this.getChildren().remove(imagenCarta);
			
			this.imagenCarta = new ImageView(imagen);
			imagenCarta.setFitWidth(60);
			imagenCarta.setFitHeight(100);
			
			MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
			imagenCarta.setOnMouseEntered(ponerEnZoom);
			 
			MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
			imagenCarta.setOnMouseExited(sacarDeZoom);
			
			this.getChildren().add(imagenCarta);
		}
		
		public void pintarCartaEnModoDefensaBocaArriba(Image imagen) {
			this.getChildren().remove(imagenCarta);
			
			this.imagenCarta = new ImageView(imagen);
			this.imagenCarta.setFitWidth(60);
			this.imagenCarta.setFitHeight(100);
			this.imagenCarta.setRotate(90);
			
			MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
			this.imagenCarta.setOnMouseEntered(ponerEnZoom);
			 
			 MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
			 this.imagenCarta.setOnMouseExited(sacarDeZoom);
			
			this.getChildren().add(imagenCarta);
		}
		
		public void pintarCartaEnModoDefensaBocaAbajo(Image imagen) {
			this.getChildren().remove(imagenCarta);
			this.cardBack.setFitWidth(60);
			this.cardBack.setFitHeight(100);
			this.cardBack.setRotate(90);
			this.imagenCarta = new ImageView(imagen);
			
			MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
			this.cardBack.setOnMouseEntered(ponerEnZoom);
			 
			 MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
			 this.cardBack.setOnMouseExited(sacarDeZoom);
			this.getChildren().add(this.cardBack);
		}
		
		public void limpiar() {
			if(this.getChildren().contains(this.imagenCarta))
			this.getChildren().remove(this.imagenCarta);
			else this.getChildren().remove(this.cardBack);
		}
		
		public void enviarAl(EspacioCementerio cementerio) {
			cementerio.recibirCarta(imagenCarta);
			this.getChildren().remove(imagenCarta);
			this.imagenCarta = null;
		}
			
}
