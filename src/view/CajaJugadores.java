package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import viewSupportFiles.PathArchivos;

public class CajaJugadores extends VBox implements PathArchivos{

	 String pathImagenYugi = pathDeImagenes+"yugiPerfil.png";
	 String pathImagenKaiba = pathDeImagenes+"kaiba%20perfil.png";
	    
	    
	public CajaJugadores(CajaInformacion cajaInformacion) {
		
		final ImageView yugiView = new ImageView();
    	yugiView.setFitWidth(150);
    	yugiView.setFitHeight(150);
    	
    	final ImageView kaibaView = new ImageView();
    	kaibaView.setFitWidth(150);
    	kaibaView.setFitHeight(150);
    	
    	Image kaiba = new Image(pathImagenKaiba);
    	kaibaView.setImage(kaiba);
    	
    	Image yugi = new Image(pathImagenYugi);
    	yugiView.setImage(yugi);
		VistaJugador perfilJugador1 = new VistaJugador(yugiView,cajaInformacion);
    	perfilJugador1.setAlignment(Pos.BOTTOM_LEFT);
    	VistaJugador perfilJugador2 = new VistaJugador(kaibaView,cajaInformacion);
    	perfilJugador2.setAlignment(Pos.TOP_RIGHT);
    	
    	Button botonFinalizarTurno = new Button("Finalizar Turno");
    	botonFinalizarTurno.getStylesheets().add("view/StyleButtonCajaJugador.css");
    	Button botonSiguienteFase = new Button("Siguiente fase");
    	botonSiguienteFase.getStylesheets().add("view/StyleButtonCajaJugador.css");
    	
    	this.setSpacing(10);
    	this.setAlignment(Pos.TOP_LEFT);
    	VBox.setVgrow(perfilJugador1, Priority.ALWAYS);
    	VBox.setVgrow(perfilJugador2, Priority.ALWAYS);
    	this.getChildren().addAll(perfilJugador2,botonSiguienteFase,botonFinalizarTurno,perfilJugador1);
    	this.setStyle("-fx-background-color: linear-gradient(DARKRED, DARKVIOLET);");
	}
}
