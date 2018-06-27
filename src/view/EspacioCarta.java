package view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCarta extends StackPane {

		public EspacioCarta() {
			
			Rectangle rectanguloAtaque = new Rectangle();
			rectanguloAtaque.setWidth(60);
			rectanguloAtaque.setHeight(100);
			rectanguloAtaque.setStroke(Color.WHITE);
			
			Rectangle rectanguloDefensa = new Rectangle();
			rectanguloDefensa.setWidth(100);
			rectanguloDefensa.setHeight(60);
			rectanguloDefensa.setStroke(Color.WHITE);
			
			this.getChildren().addAll(rectanguloAtaque,rectanguloDefensa);
			this.setAlignment(Pos.CENTER);
		}
}
