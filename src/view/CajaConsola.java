package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.handlers.BotonMaximizarConsolaHandler;

public class CajaConsola extends HBox {
	
	private TextArea areaTextoConsola;
	private Button boton;
	
	public CajaConsola() {
		
		this.prepararAreaTexto();
		this.prepararBoton();
		
		HBox.setHgrow( areaTextoConsola, Priority.ALWAYS );
		this.getChildren().addAll( boton, areaTextoConsola );
		this.setPrefSize( 15, 15 );
		
		this.agregarMensaje("comienza la partida");
		this.agregarMensaje("Es el turno de marcio");
		this.agregarMensaje("Massuh gato");
		this.agregarMensaje("Se aplico el efecto Rayo Peronizador");
		this.agregarMensaje("Ola ke ase");
	//	this.limpiar();

	}
	
	private void prepararBoton() {
		
		this.boton = new Button();
		
		boton.setMaxHeight(Double.MAX_VALUE);
		boton.setMaxWidth(Double.MAX_VALUE);
		boton.setText("+");
		boton.getStylesheets().add( "view/StyleButtonCajaJugador.css" );
		
		BotonMaximizarConsolaHandler maximizarConsola = new BotonMaximizarConsolaHandler( this, boton );
		boton.setOnAction( maximizarConsola );
	}

	public void prepararAreaTexto() {
		
		this.areaTextoConsola = new TextArea();
		
		this.areaTextoConsola.setEditable( false );
		this.areaTextoConsola.setWrapText( true );
		this.areaTextoConsola.getStylesheets().add( "view/StyleConsola.css" );
        this.areaTextoConsola.setStyle( "-fx-font-size: 20" );

	}
	
	public void agregarMensaje( String mensaje ) {
		
		this.areaTextoConsola.appendText( "-> " );
		this.areaTextoConsola.appendText( mensaje );
		this.areaTextoConsola.appendText( "\n" );
	}
	
	public void limpiar() {
		
		this.areaTextoConsola.setText("");
	}
	
}
