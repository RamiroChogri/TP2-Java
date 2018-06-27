package view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class EspacioCarta extends StackPane {

		public EspacioCarta() {
			
			Rectangle rectanguloAtaque = new Rectangle();
			rectanguloAtaque.setWidth(60);
			rectanguloAtaque.setHeight(100);
			
			Rectangle rectanguloDefensa = new Rectangle();
			rectanguloDefensa.setWidth(100);
			rectanguloDefensa.setHeight(60);
			
			this.getChildren().addAll(rectanguloAtaque,rectanguloDefensa);
			this.setAlignment(Pos.CENTER);
		}
}
