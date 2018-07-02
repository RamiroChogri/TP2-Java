package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import jugador.Jugador;
import viewSupportFiles.PathArchivos;

public class AlertaPartidaFinalizadaHandler implements EventHandler<ActionEvent> , PathArchivos{

	//POR AHORA NO SE ESTA USANDO ESTE HANDLER, SE PREGUNTA EN EL BOTON SIGUIENTE FASE Y EL
	//BOTON TERMINAR TURNO CON UN IF SI EL JUGADOR ESTA MUERTO Y SE EJECUTA EL CODIGO DEL 
	//HANDLE DE ESTA CLASE, PERO DE MOMENTO NO ESTA SIENDO USADA ESTA CLASE PARA NADA.
	
	private Jugador yugi;
	private Jugador kaiba;
	
	public AlertaPartidaFinalizadaHandler(Jugador yugi, Jugador kaiba) {
	
		this.yugi = yugi;
		this.kaiba = kaiba;
		
	}
	
	public void handle(ActionEvent actionEvent) {
		
		String ganador = "Ninguno";
		if (this.yugi.estaDerrotado()) {
			ganador = kaiba.obtenerNombre();
		} else {
			ganador = yugi.obtenerNombre();
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Partida Finalizada");
		
	    alert.setHeaderText("Ha ganado el jugador " + ganador + ", el otro es malisimo");
	    String mensaje = "Pero malisimo eh, muy mal jugo";
	    alert.setContentText(mensaje);
	    alert.show();
	}

}
