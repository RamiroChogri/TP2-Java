package view.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import view.CajaConsola;

public class BotonMaximizarConsolaHandler  implements EventHandler<ActionEvent>{
	
	private CajaConsola consola;
	private Button botonConsola;
	
	public BotonMaximizarConsolaHandler( CajaConsola consola, Button boton ) {
		
		this.consola = consola;
		this.botonConsola = boton;
	}
	
	public void handle(ActionEvent actionEvent) {
		
		consola.setPrefHeight( 150 );
		BotonMinimizarConsolaHandler minimizarConsola = new BotonMinimizarConsolaHandler( consola, botonConsola );
		botonConsola.setText( "-" );
		botonConsola.setOnAction(minimizarConsola);
		botonConsola.requestFocus();
    }
}
