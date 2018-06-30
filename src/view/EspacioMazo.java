package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import jugador.Jugador;
import viewSupportFiles.PathArchivos;

public class EspacioMazo extends StackPane implements PathArchivos{

	private Jugador jugadorDelMazo;
	private Label cartasEnMazo;
	private ImageView imagenMazo;
	
	public EspacioMazo(Jugador jugadorDelMazo) {
		this.jugadorDelMazo = jugadorDelMazo;
		this.imagenMazo = new ImageView(pathDePackCartas+"CardBackAlgo.png");
		imagenMazo.setFitHeight(100);
		imagenMazo.setFitWidth(60);
		int cantidadDeCartasEnMazo = this.jugadorDelMazo.obtenerCartasMazo();
		String cantidadCartas = String.valueOf(cantidadDeCartasEnMazo);
		this.cartasEnMazo = new Label(cantidadCartas);
		this.cartasEnMazo.setFont(Font.font("Arial", FontWeight.BOLD,18 ));
		this.cartasEnMazo.setTextFill(Color.web("WHITE"));
		
		this.getChildren().addAll(this.imagenMazo,this.cartasEnMazo);
	}
	
	public void actualizarCartasEnMazo() {
		int cantidadDeCartasEnMazo = this.jugadorDelMazo.obtenerCartasMazo();
		String cantidadCartas = String.valueOf(cantidadDeCartasEnMazo);	
		this.cartasEnMazo.setText(cantidadCartas);
	}
}
