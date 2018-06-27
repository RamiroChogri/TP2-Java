package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CajaInformacion extends StackPane{
	
	Rectangle baseDeInfoCarta;
	ImageView imagenV;

	public CajaInformacion() {
		this.baseDeInfoCarta = new Rectangle(250,400,Color.PERU);
		baseDeInfoCarta.setStroke(Color.WHITE);
		
		this.imagenV=null;
		
		this.getChildren().add(baseDeInfoCarta);
		this.setAlignment(Pos.CENTER);
		this.setStyle("-fx-background-color: BLACK");
	}
	
	public void zoomAImagen(Image imagen) {
		this.imagenV = new ImageView(imagen);
		imagenV.setFitWidth(250);
		imagenV.setFitHeight(400);
		
		this.getChildren().add(imagenV);
	}
	
	public void quitarImagen() {
		this.getChildren().remove(this.imagenV);
	}
}
