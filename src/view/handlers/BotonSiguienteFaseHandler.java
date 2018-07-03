package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import jugador.Jugador;
import partida.Partida;
import view.CajaConsola;
import view.ContenedorDelDuelo;

public class BotonSiguienteFaseHandler implements EventHandler<ActionEvent> {
	
	private Partida duelo;
	private Jugador jugadorEnTurno;
	private ContenedorDelDuelo contenedorDelDuelo;
	
	public BotonSiguienteFaseHandler(Partida partidaAColocar, Jugador jugadorAColocar, ContenedorDelDuelo contenedorAColocar) {
		this.duelo = partidaAColocar;
		this.jugadorEnTurno = jugadorAColocar;
		this.contenedorDelDuelo = contenedorAColocar;
	}
	
	public void handle(ActionEvent actionEvent) {
        this.duelo.avanzarFase();
        this.jugadorEnTurno = this.duelo.obtenerJugadorEnTurno();
        
        if (duelo.estaEnFaseDePreparacion()) {
        	CajaConsola.agregarMensaje("Es el turno de " + this.jugadorEnTurno.obtenerNombre());
        }
        
        if (this.duelo.estaYugiEnTurno()) {
        	this.contenedorDelDuelo.actualizarVistaYugiEnTurno(this.jugadorEnTurno, this.jugadorEnTurno.obtenerJugadorEnemigo());
        } else {
        	this.contenedorDelDuelo.actualizarVistaKaibaEnTurno(this.jugadorEnTurno, this.jugadorEnTurno.obtenerJugadorEnemigo());
        }
        
        if (this.jugadorEnTurno.estaDerrotado() || this.jugadorEnTurno.obtenerJugadorEnemigo().estaDerrotado()) {
        	
        	String ganador = "Ninguno";
    		if (this.jugadorEnTurno.estaDerrotado()) {
    			ganador = jugadorEnTurno.obtenerJugadorEnemigo().obtenerNombre();
    		} else {
    			ganador = jugadorEnTurno.obtenerNombre();
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
