package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import viewSupportFiles.PathArchivos;

public class CajaJugadores extends VBox implements PathArchivos{

	 String pathImagenYugi = pathDeImagenes+"yugiPerfil.png";
	 String pathImagenKaiba = pathDeImagenes+"kaiba%20perfil.png";
	    
	    
	public CajaJugadores() {
		
		final ImageView yugiView = new ImageView();
    	yugiView.setFitWidth(150);
    	yugiView.setFitHeight(150);
    	
    	final ImageView kaibaView = new ImageView();
    	kaibaView.setFitWidth(125);
    	kaibaView.setFitHeight(125);
    	
    	Image kaiba = new Image(pathImagenKaiba);
    	kaibaView.setImage(kaiba);
    	
    	Image yugi = new Image(pathImagenYugi);
    	yugiView.setImage(yugi);
		VistaJugador perfilJugador1 = new VistaJugador(yugiView);
    	perfilJugador1.setAlignment(Pos.BOTTOM_LEFT);
    	VistaJugador perfilJugador2 = new VistaJugador(kaibaView);
    	perfilJugador2.setAlignment(Pos.TOP_RIGHT);
    	
    	this.setAlignment(Pos.TOP_LEFT);
    	this.getChildren().addAll(perfilJugador2,perfilJugador1);
    	VBox.setVgrow(perfilJugador1, Priority.ALWAYS);
    	this.setStyle("-fx-background-color: linear-gradient(DARKRED, DARKVIOLET);");
	}
}
