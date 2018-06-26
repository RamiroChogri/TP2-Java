package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class ManoJugador extends HBox{

		public ManoJugador() {
			this.setAlignment(Pos.BOTTOM_CENTER);
			this.setSpacing(15);
			
			Rectangle carta1 = new Rectangle();
			carta1.setWidth(60);
			carta1.setHeight(100);
			
			Rectangle carta2 = new Rectangle();
			carta2.setWidth(60);
			carta2.setHeight(100);
			
			Rectangle carta3 = new Rectangle();
			carta3.setWidth(60);
			carta3.setHeight(100);
			
			this.getChildren().addAll(carta1, carta2,carta3);
		}
		
		public void agregarCarta() {
			
		}
}
