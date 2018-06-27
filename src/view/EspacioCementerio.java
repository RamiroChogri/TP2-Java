package view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCementerio extends StackPane{

		public EspacioCementerio() {
			Rectangle espacioCementerio = new Rectangle(60,100,Color.GREY);
			this.getChildren().add(espacioCementerio);
			this.setAlignment(Pos.CENTER);
		}
		
		public void recibirCarta(ImageView imagenCarta) {
			this.getChildren().add(imagenCarta);
		}
}
