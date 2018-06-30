package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import view.CajaConsola;

public class BotonMinimizarConsolaHandler implements EventHandler<ActionEvent> {

	private CajaConsola consola;
	private Button botonConsola;
	
	public BotonMinimizarConsolaHandler( CajaConsola consola, Button boton ) {
		
		this.consola = consola;
		this.botonConsola = boton;
	}
	
	public void handle(ActionEvent actionEvent) {
		
		consola.setPrefHeight( 15 );
		BotonMaximizarConsolaHandler maximizarConsola = new BotonMaximizarConsolaHandler( consola, botonConsola );
		botonConsola.setText( "+" );
		botonConsola.setOnAction(maximizarConsola);
    }
}

