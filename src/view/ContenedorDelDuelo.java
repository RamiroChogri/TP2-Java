package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import viewSupportFiles.PathArchivos;

public class ContenedorDelDuelo extends BorderPane implements PathArchivos{

		private MenuDelDuelo menuBar;
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
	    	
			this.menuBar = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
            this.setTop(menuBar);
            
            this.cajaIzquierda = new CajaJugadores(this.cajaDerecha);
	    	this.setLeft(cajaIzquierda);
            
	    	this.cajaCentro = new CajaCampo();
	    	this.setCenter(cajaCentro);
//	    	this.setZoomCartaHover();
//	        this.setMenu(stage);
//	        this.setPerfilJugadores();
//	        this.setCampo();
	    }
	    
	    public MenuDelDuelo getBarraDeMenu() {
			return this.menuBar;
		}
	    
	    
//	    public void setZoomCartaHover() {
//			CajaInformacion cajaDerecha = new CajaInformacion();
//			this.setRight(cajaDerecha);
//		}
//	    
//	    public void setMenu(Stage stage) {
//	            this.menuBar = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
//	            this.setTop(menuBar);
//	    }
//	    
//	    public void setPerfilJugadores() {
//	    	CajaJugadores cajaIzquierda = new CajaJugadores(this.cajaDerecha);
//	    	this.setLeft(cajaIzquierda);
//	    }
//	    
//	    public void setCampo() {
//	    	CajaCampo cajaCentro = new CajaCampo();
//	    	this.setCenter(cajaCentro);
//	    }
//
}
