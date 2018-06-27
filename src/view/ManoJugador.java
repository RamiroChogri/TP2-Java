package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ManoJugador extends HBox{

		public ManoJugador() {
			this.setAlignment(Pos.BOTTOM_CENTER);
			this.setSpacing(15);
			
			Rectangle carta1 = new Rectangle();
			carta1.setWidth(60);
			carta1.setHeight(100);
			carta1.setStroke(Color.WHITE);
			
			Rectangle carta2 = new Rectangle();
			carta2.setWidth(60);
			carta2.setHeight(100);
			carta2.setStroke(Color.WHITE);
			
			Rectangle carta3 = new Rectangle();
			carta3.setWidth(60);
			carta3.setHeight(100);
			carta3.setStroke(Color.WHITE);
			
			Rectangle carta4 = new Rectangle();
			carta4.setWidth(60);
			carta4.setHeight(100);
			carta4.setStroke(Color.WHITE);
			Rectangle carta5 = new Rectangle();
			carta5.setWidth(60);
			carta5.setHeight(100);
			carta5.setStroke(Color.WHITE);
			
			this.getChildren().addAll(carta1, carta2,carta3,carta4,carta5);
		}
		
		public void agregarCarta() {
			
		}
}
