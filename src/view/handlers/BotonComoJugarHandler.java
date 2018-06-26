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
	        alert.setHeaderText("Este link contiene un archivo que contiene las reglas de juego.");
	        String mensaje = "https://github.com/RamiroChogri/TP2-Java/blob/master/README.md";
	        alert.setContentText(mensaje);
	        alert.show();
	    }

}
