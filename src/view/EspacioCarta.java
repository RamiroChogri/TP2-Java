package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;
import viewSupportFiles.PathArchivos;

public class EspacioCarta extends StackPane implements PathArchivos{
	
	
	ImageView imagenCarta;
	Image cardBack;
	CajaInformacion cajaInformacion;
	
		public EspacioCarta(CajaInformacion cajaInformacion) {
			
			this.cajaInformacion = cajaInformacion;
			
			Rectangle rectanguloAtaque = new Rectangle();
			rectanguloAtaque.setWidth(60);
			rectanguloAtaque.setHeight(100);
			rectanguloAtaque.setStroke(Color.WHITE);
			
			Rectangle rectanguloDefensa = new Rectangle();
			rectanguloDefensa.setWidth(100);
			rectanguloDefensa.setHeight(60);
			rectanguloDefensa.setStroke(Color.WHITE);
			
			this.imagenCarta = null;
			this.cardBack = new Image(pathDePackCartas+"cardBackAlgo");
			
			this.getChildren().addAll(rectanguloAtaque,rectanguloDefensa);
			this.setAlignment(Pos.CENTER);
		}
		
		public void pintarCartaEnModoAtaque(Image imagen) {
			ImageView imagenCarta = new ImageView(imagen);
			imagenCarta.setFitWidth(60);
			imagenCarta.setFitHeight(100);
			
			MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
			imagenCarta.setOnMouseEntered(ponerEnZoom);
			 
			MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
			imagenCarta.setOnMouseExited(sacarDeZoom);
			 
			this.getChildren().add(imagenCarta);
		}
		
		public void pintarCartaEnModoDefensaBocaArriba(Image imagen) {
			ImageView imagenCarta = new ImageView(imagen);
			imagenCarta.setFitWidth(100);
			imagenCarta.setFitHeight(60);
			
			MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(imagenCarta,cajaInformacion);
			imagenCarta.setOnMouseEntered(ponerEnZoom);
			 
			 MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
			 imagenCarta.setOnMouseExited(sacarDeZoom);
			
			this.getChildren().add(imagenCarta);
		}
		
		public void pintarCartaEnModoDefensaBocaAbajo(Image imagen) {
			ImageView imagenCarta = new ImageView(cardBack);
			imagenCarta.setFitWidth(100);
			imagenCarta.setFitHeight(60);
			this.getChildren().add(imagenCarta);
		}
		
		public void limpiar() {
			this.getChildren().remove(imagenCarta);
		}
		
		public void enviarAl(EspacioCementerio cementerio) {
			this.getChildren().remove(imagenCarta);
			cementerio.recibirCarta(imagenCarta);
			this.imagenCarta = null;
		}
			
}
