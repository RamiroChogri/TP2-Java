package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaJugador extends HBox{
	
	ImageView imagenDelJugador;
	Label vida;
	
	public VistaJugador(ImageView imagenDelJugador) {
		this.imagenDelJugador = imagenDelJugador;
		
		 this.vida = new Label("Vida:8000");
		 vida.setFont(Font.font("Arial", FontWeight.BOLD,18 ));
		 vida.setTextFill(Color.web("#000000"));
		 this.getChildren().addAll(this.imagenDelJugador,this.vida);
//		 this.setStyle("-fx-background-color: DARKVIOLET;");
	}
	
	public VistaJugador(ImageView imagenDelJugador,Boolean estaArriba) {
		this.imagenDelJugador = imagenDelJugador;
		
		 this.vida = new Label("Vida:8000");
		 vida.setFont(Font.font("Arial", FontWeight.BOLD,18 ));
		 vida.setTextFill(Color.web("#000000"));
		 this.getChildren().addAll(this.vida,this.imagenDelJugador);
//		 this.setStyle("-fx-background-color: DARKRED;");
	}

	public void updateVida(String vidaNueva){
		this.vida.setText("Vida:"+ vidaNueva);
	}
}
