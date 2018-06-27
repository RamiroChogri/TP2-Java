package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.handlers.MouseArribaDeImagenHandler;
import view.handlers.MouseSalirArribaDeImagenHandler;

public class VistaJugador extends HBox{
	
	ImageView imagenDelJugador;
	Label vida;
	
    
	public VistaJugador(ImageView imagenDelJugador,CajaInformacion cajaInformacion) {
		this.imagenDelJugador = imagenDelJugador;
		
		 this.vida = new Label("Vida:8000");
		 vida.setFont(Font.font("Arial", FontWeight.BOLD,18 ));
		 vida.setTextFill(Color.web("WHITE"));
		 this.getChildren().addAll(this.imagenDelJugador,this.vida);
		 
		 
		 MouseArribaDeImagenHandler ponerEnZoom = new MouseArribaDeImagenHandler(this.imagenDelJugador,cajaInformacion);
		 this.imagenDelJugador.setOnMouseEntered(ponerEnZoom);
		 
		 MouseSalirArribaDeImagenHandler sacarDeZoom = new MouseSalirArribaDeImagenHandler(cajaInformacion);
		 this.imagenDelJugador.setOnMouseExited(sacarDeZoom);
		 
	}
	
	public void updateVida(String vidaNueva){
		this.vida.setText("Vida:"+ vidaNueva);
	}
}
