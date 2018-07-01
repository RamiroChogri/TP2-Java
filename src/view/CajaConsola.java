package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import view.handlers.BotonMaximizarConsolaHandler;

public class CajaConsola extends HBox {
	
	private static TextArea areaTextoConsola;
	private Button boton;
	
	public CajaConsola() {
		
		this.prepararAreaTexto();
		this.prepararBoton();
		
		HBox.setHgrow( areaTextoConsola, Priority.ALWAYS );
		this.getChildren().addAll( boton, areaTextoConsola );
		this.setPrefSize( 5, 5 );
		
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

	private void prepararAreaTexto() {
		
		areaTextoConsola = new TextArea();
		areaTextoConsola.setPrefSize(5, 5);
		areaTextoConsola.setEditable( false );
		areaTextoConsola.setWrapText( true );
		areaTextoConsola.getStylesheets().add( "view/StyleConsola.css" );
        areaTextoConsola.setStyle( "-fx-font-size: 20" );

	}
	
	public static void agregarMensaje( String mensaje ) {
		
		areaTextoConsola.appendText( "-> " );
		areaTextoConsola.appendText( mensaje );
		areaTextoConsola.appendText( "\n" );
	}
	
	public void limpiar() {
		
		areaTextoConsola.setText("");
	}
	
	public void actualizarLineaAlMinimizar() {
		areaTextoConsola.positionCaret( areaTextoConsola.getText().length() );
	}
	
}
