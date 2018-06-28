package view;

import java.util.LinkedList;

import cartas.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jugador.*;
import viewSupportFiles.PathArchivos;

public class ContenedorDelDuelo extends BorderPane implements PathArchivos{

		private MenuDelDuelo barraMenu;
		private  String pathMusicaDeBatalla = pathDeMusica+"Hollow%20Knight%20OST%20-%20False%20Knight.wav";
		private CajaInformacion cajaDerecha;
		private CajaCampo cajaCentro;
		private CajaJugadores cajaIzquierda;
		
	    public ContenedorDelDuelo(Stage stage) {
	    	super();
	    	
	    	this.cajaCentro=null;
	    	this.cajaDerecha=null;
	    	this.cajaIzquierda=null;
	    	
	    	this.cajaDerecha = new CajaInformacion();
			this.setRight(cajaDerecha);
	    	
			this.barraMenu = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
            this.setTop(barraMenu);
            
            this.cajaIzquierda = new CajaJugadores(this.cajaDerecha);
	    	this.setLeft(cajaIzquierda);
            
	    	this.cajaCentro = new CajaCampo(cajaDerecha);
	    	this.setCenter(cajaCentro);
	    }
	    
	    public MenuDelDuelo getBarraDeMenu() {
			return this.barraMenu;
		}
	    
	    public MenuItem getPantallaCompletaItem() {
	    	return this.barraMenu.getPantallaCompletaItem();
	    }
	    
	    public void actualizarVistaYugi(Jugador yugi, Jugador Kaiba) {
	    	
	    	
	    	
	    	
	    }
	    
}
