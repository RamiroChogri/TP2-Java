package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import viewSupportFiles.PathArchivos;

public class ContenedorDelDuelo extends BorderPane implements PathArchivos{

		MenuDelDuelo menuBar;
	    String pathMusicaDeBatalla = pathDeMusica+"Hollow%20Knight%20OST%20-%20False%20Knight.mp3";
	    
	    public ContenedorDelDuelo(Stage stage) {
	    	super();
	    	
	        this.setMenu(stage);
	    }
	    
	    public void setMenu(Stage stage) {
	            this.menuBar = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
	            this.setTop(menuBar);
	    }
}
