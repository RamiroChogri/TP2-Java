package view.handlers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import viewSupportFiles.PathArchivos;

public class BotonComoJugarHandler implements EventHandler<ActionEvent> , PathArchivos{

	 public void handle(ActionEvent actionEvent) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Como Jugar");
	        alert.setHeaderText("Pulse el boton secundario del raton para interactuar con las cartas en la fase que corresponda.\n"
	        		+ "-En la fase de preparacion se pueden colocar cartas de la mano y rotar los monstruos colocados.\n"
	        		+ "(Aclaracion: Solo se puede jugar una carta monstruo por turno y no se puede rotar en el turno en que se coloca)\n"
	        		+ "-En la fase de ataques y trampas se puede atacar al enemigo (Y se activaran las trampas en caso de que corresponda).\n"
	        		+ "(Aclaracion: No se puede atacar en el primer turno y los monstruos solo pueden atacar una vez por turno)\n"
	        		+ "-En la fase final se pueden voltear y activar las cartas magicas boca abajo.\n"
	        		+ "Gana el primer jugador que logre que su contrincate pierda sus 8000 puntos de vida.");
	        String mensaje = "El jugador que tenga a la vez todas las partes de exodia en la mano gana automaticamente.";
	        alert.setContentText(mensaje);
	        alert.show();
	    }

}
