package view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCementerio extends StackPane{
	
	ImageView imagenCarta;

		public EspacioCementerio() {
			this.imagenCarta = null;
			Rectangle espacioCementerio = new Rectangle(60,100,Color.GREY);
			espacioCementerio.setStroke(Color.WHITE);
			this.getChildren().add(espacioCementerio);
			this.setAlignment(Pos.CENTER);
		}
		
		public void recibirCarta(ImageView imagenCarta) {
			if(this.imagenCarta != null)
				this.getChildren().remove(this.imagenCarta);
			
			imagenCarta.setOpacity(0.5);
			this.imagenCarta = imagenCarta;
			this.getChildren().add(this.imagenCarta);
		}
}
