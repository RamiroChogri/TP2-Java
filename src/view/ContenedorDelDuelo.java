package view;

import java.util.LinkedList;

import cartas.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jugador.*;
import partida.Partida;
import viewSupportFiles.PathArchivos;

public class ContenedorDelDuelo extends BorderPane implements PathArchivos{

		private MenuDelDuelo barraMenu;
		private  String pathMusicaDeBatalla = pathDeMusica+"Hollow%20Knight%20OST%20-%20False%20Knight.wav";
		private CajaInformacion cajaDerecha;
		private CajaCampo cajaCentro;
		private CajaJugadores cajaIzquierda;
		Partida duelo;
		
	    public ContenedorDelDuelo(Stage stage , Partida duelo) {
	    	super();
	    	this.duelo = duelo;
	    	
	    	this.cajaDerecha = new CajaInformacion();
			this.setRight(cajaDerecha);
	    	
			this.barraMenu = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
            this.setTop(barraMenu);
            Jugador jugadorEnTurno;
            if (duelo.estaYugiEnTurno()) {
            	jugadorEnTurno = duelo.getJugadorYugi();
            } else {
            	jugadorEnTurno = duelo.getJugadorKaiba();
            }
            
            this.cajaIzquierda = new CajaJugadores(this.cajaDerecha,duelo,jugadorEnTurno, this);
	    	this.setLeft(cajaIzquierda);
            
	    	this.cajaCentro = new CajaCampo(cajaDerecha,duelo);
	    	this.setCenter(cajaCentro);
	    }
	    
	    public MenuDelDuelo getBarraDeMenu() {
			return this.barraMenu;
		}
	    
	    public MenuItem getPantallaCompletaItem() {
	    	return this.barraMenu.getPantallaCompletaItem();
	    }
	    
	    public void actualizarVistaYugiEnTurno(Jugador yugi, Jugador kaiba) {
	    	
	    	this.cajaCentro.actualizarVistaYugiEnTurno(yugi, kaiba);
	    	this.cajaIzquierda.actualizarVida(yugi, kaiba);
	    
	    }
	    
	    public void actualizarVistaKaibaEnTurno(Jugador kaiba, Jugador yugi) {
	    	
	    	this.cajaCentro.actualizarVistaKaibaEnTurno(kaiba, yugi);
	    	this.cajaIzquierda.actualizarVida(yugi, kaiba);
	    	
	    }
	    
	    public void actualizarCajas() {
	    	this.cajaCentro.actualizarCaja();
	    	this.cajaIzquierda.actualizarVida(this.duelo.getJugadorYugi(), this.duelo.getJugadorKaiba());
	    }
	    
}
