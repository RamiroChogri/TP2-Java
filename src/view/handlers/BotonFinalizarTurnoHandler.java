package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import jugador.Jugador;
import partida.Partida;
import view.CajaConsola;
import view.ContenedorDelDuelo;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private Partida duelo;
	private Jugador jugadorYugi;
	private Jugador jugadorKaiba;
	private ContenedorDelDuelo contenedorDelDuelo;
	
	public BotonFinalizarTurnoHandler(Partida partidaAColocar, ContenedorDelDuelo contenedorAColocar) {
		this.duelo = partidaAColocar;
		this.jugadorYugi = this.duelo.getJugadorYugi();
		this.jugadorKaiba = this.duelo.getJugadorKaiba();
		this.contenedorDelDuelo = contenedorAColocar;
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
    		if (this.jugadorYugi.estaDerrotado()) {
    			ganador = jugadorKaiba.obtenerJugadorEnemigo().obtenerNombre();
    		} else {
    			ganador = jugadorYugi.obtenerNombre();
    		}
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		
    		alert.setTitle("Partida Finalizada");
    		
    	    alert.setHeaderText("Ha ganado el jugador " + ganador + ", el otro es malisimo");
    	    String mensaje = "Pero malisimo eh, muy mal jugo";
    	    alert.setContentText(mensaje);
    	    alert.show();
        	
        }
        
        
    }
}
