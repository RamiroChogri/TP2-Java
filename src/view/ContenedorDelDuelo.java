package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import viewSupportFiles.PathArchivos;

public class ContenedorDelDuelo extends BorderPane implements PathArchivos{

		MenuDelDuelo menuBar;
	    String pathMusicaDeBatalla = pathDeMusica+"Hollow%20Knight%20OST%20-%20False%20Knight.wav";
	    String pathImagenYugi = pathDeImagenes+"yugiPerfil.png";
	    String pathImagenKaiba = pathDeImagenes+"kaiba%20perfil.png";
	    
	    public ContenedorDelDuelo(Stage stage) {
	    	super();
	    	
	        this.setMenu(stage);
	        this.setPerfilJugadores();
	        this.setCampo();
	    }
	    
	    public void setMenu(Stage stage) {
	            this.menuBar = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
	            this.setTop(menuBar);
	    }
	    
	    public void setPerfilJugadores() {
	    	CajaJugadores cajaIzquierda = new CajaJugadores();
	    	this.setLeft(cajaIzquierda);
	    }
	    
	    public void setCampo() {
	    	CajaCampo cajaCentro = new CajaCampo();
	    	this.setCenter(cajaCentro);
	    }

		public MenuDelDuelo getBarraDeMenu() {
			return this.menuBar;
		}
	    
}
