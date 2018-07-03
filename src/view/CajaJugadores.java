package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import jugador.Jugador;
import partida.Partida;
import view.handlers.BotonFinalizarTurnoHandler;
import view.handlers.BotonPlayMusicaDeFondoHandler;
import view.handlers.BotonSiguienteFaseHandler;
import viewSupportFiles.PathArchivos;

public class CajaJugadores extends VBox implements PathArchivos{

	private String pathImagenYugi = pathDeImagenes+"yugiPerfil.png";
	private String pathImagenKaiba = pathDeImagenes+"kaiba%20perfil.png";
	private VistaJugador perfilJugador1;   
	private VistaJugador perfilJugador2;
	private Partida duelo;
	private Jugador jugador; 
	ContenedorDelDuelo contenedorDelDuelo;
	private Label fase;
	    
	public CajaJugadores(CajaInformacion cajaInformacion, Partida dueloRecibido, Jugador jugadorEnTurno, ContenedorDelDuelo contenedorAColocar, Stage stage) {
		
		this.duelo = dueloRecibido;
		this.jugador = jugadorEnTurno;
		this.contenedorDelDuelo = contenedorAColocar;
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
		
    	String nombreFase = duelo.getNombreFase();
    	
    	this.fase = new Label(nombreFase);
		fase.setFont(Font.font("Arial", FontWeight.BOLD,18 ));
		fase.setTextFill(Color.web("WHITE"));
    	
    	this.perfilJugador1 = new VistaJugador(yugiView,cajaInformacion, nombreFase); 
    	perfilJugador1.setAlignment(Pos.BOTTOM_LEFT);
    	
    	this.perfilJugador2 = new VistaJugador(kaibaView,cajaInformacion, nombreFase); 
    	perfilJugador2.setAlignment(Pos.TOP_RIGHT);
    	
    	Button botonFinalizarTurno = new Button("Finalizar Turno ");
    	botonFinalizarTurno.getStylesheets().add("view/StyleButtonCajaJugador.css");
    	BotonFinalizarTurnoHandler finalizarTurno = new BotonFinalizarTurnoHandler(this.duelo, this.contenedorDelDuelo,stage);
        botonFinalizarTurno.setOnAction(finalizarTurno);
        
        botonFinalizarTurno.setMaxWidth(250);
    	
    	
    	Button botonSiguienteFase = new Button("Siguiente Fase ");
    	botonSiguienteFase.getStylesheets().add("view/StyleButtonCajaJugador.css");
    	BotonSiguienteFaseHandler siguienteFase = new BotonSiguienteFaseHandler(this.duelo, this.contenedorDelDuelo, stage);
    	botonSiguienteFase.setOnAction(siguienteFase);
    	
    	botonSiguienteFase.setMaxWidth(250);
    	
    	
    	this.setSpacing(10);
    	this.setAlignment(Pos.TOP_LEFT);
    	VBox.setVgrow(perfilJugador1, Priority.ALWAYS);
    	VBox.setVgrow(perfilJugador2, Priority.ALWAYS);
    	this.getChildren().addAll(perfilJugador2,fase,botonSiguienteFase,botonFinalizarTurno,perfilJugador1);
    	this.setStyle("-fx-background-color: linear-gradient(DARKRED, DARKVIOLET);");
	}
	
	public void actualizarVida(Jugador yugi, Jugador kaiba) {
		this.perfilJugador1.updateVida(Integer.toString(yugi.obtenerVida()));
		this.perfilJugador2.updateVida(Integer.toString(kaiba.obtenerVida()));
		this.updateFase(this.duelo.getNombreFase());
		this.updateFase(this.duelo.getNombreFase());
	}
	
	public void updateFase(String faseRecibida) {
		this.fase.setText(faseRecibida);
	}
}
