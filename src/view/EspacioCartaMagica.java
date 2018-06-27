package view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCartaMagica extends StackPane {
	
	public EspacioCartaMagica() {
		Rectangle rectanguloAtaque = new Rectangle();
		rectanguloAtaque.setWidth(60);
		rectanguloAtaque.setHeight(100);
		rectanguloAtaque.setStroke(Color.WHITE);
		
		this.getChildren().addAll(rectanguloAtaque);
		this.setAlignment(Pos.CENTER);
	}
}
