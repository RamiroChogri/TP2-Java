package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jugador.Jugador;
import partida.Partida;
import view.CajaConsola;
import view.ContenedorDelDuelo;
import view.ContenedorVictoria;
import viewSupportFiles.PathArchivos;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent>,PathArchivos {
	
	private Partida duelo;
	private Jugador jugadorYugi;
	private Jugador jugadorKaiba;
	private ContenedorDelDuelo contenedorDelDuelo;
	private Stage stage;
	
	public BotonFinalizarTurnoHandler(Partida partidaAColocar, ContenedorDelDuelo contenedorAColocar,Stage stage) {
		this.duelo = partidaAColocar;
		this.jugadorYugi = this.duelo.getJugadorYugi();
		this.jugadorKaiba = this.duelo.getJugadorKaiba();
		this.contenedorDelDuelo = contenedorAColocar;
		this.stage = stage;
	}
	
	public void handle(ActionEvent actionEvent) {
        this.duelo.finalizarTurno();
        
        if (this.duelo.estaYugiEnTurno()) {
        	this.contenedorDelDuelo.actualizarVistaYugiEnTurno(this.jugadorYugi, this.jugadorKaiba);
        	CajaConsola.agregarMensaje("Es el turno de "+ this.jugadorYugi.obtenerNombre());
        } else {
        	this.contenedorDelDuelo.actualizarVistaKaibaEnTurno(this.jugadorKaiba, this.jugadorYugi);
        	CajaConsola.agregarMensaje("Es el turno de "+ this.jugadorKaiba.obtenerNombre());
        }
        
        if (this.jugadorYugi.estaDerrotado() || this.jugadorKaiba.estaDerrotado()) {
        	
        	String ganador = "Ninguno";
        	Image imagenGanador = null;
        	Boolean ganoYugi = null;
    		if (this.jugadorYugi.estaDerrotado()) {
    			ganador = jugadorKaiba.obtenerNombre();
    			imagenGanador = new Image(pathDeImagenes+"kaiba%20perfil.png");
    			ganoYugi = false;
    		} else {
    			ganador = jugadorYugi.obtenerNombre();
    			imagenGanador = new Image(pathDeImagenes+"yugiPerfil.png");
    			ganoYugi = true;
    		}
    		
    		ContenedorVictoria contenedorVictoria = new ContenedorVictoria(ganador, imagenGanador,ganoYugi);
    		Scene escenaVictoria = new Scene(contenedorVictoria,1190,670);
    		this.stage.setScene(escenaVictoria);
	        stage.setFullScreenExitHint("");
	        stage.setFullScreen(true);
        }
    }
}
