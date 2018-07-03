package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.handlers.BotonSalirHandler;

public class ContenedorVictoria extends BorderPane{
	
	
	public ContenedorVictoria(String nombreDelGanador, Image imagenDelGanador, Boolean ganoYugi) {
		Label textoVictoria = new Label("Felicidades!! El jugador "+nombreDelGanador+" a ganado la partida!!");
		textoVictoria.setAlignment(Pos.CENTER);
		textoVictoria.setFont(Font.font("Arial", FontWeight.BOLD,30 ));
		textoVictoria.setTextFill(Color.web("#FFFAF0"));
		
		ImageView imagenGanador = new ImageView(imagenDelGanador);
		imagenGanador.setFitHeight(750);
		imagenGanador.setFitWidth(550);
		
		if(ganoYugi)
			this.setStyle("-fx-background-color: linear-gradient(BLACK, DARKVIOLET);");
		else
			this.setStyle("-fx-background-color: linear-gradient(BLACK, RED)");
		
		BotonSalirHandler salir = new BotonSalirHandler();
		Button botonSalir = new Button("Salir");
		botonSalir.getStylesheets().add("view/Style.css");
		botonSalir.setStyle("-fx-font-size: 40px;");
		botonSalir.setOnAction(salir);
		botonSalir.setAlignment(Pos.BOTTOM_LEFT);
		
		this.setCenter(botonSalir);
		this.setRight(imagenGanador);
		this.setTop(textoVictoria);
	}

}
