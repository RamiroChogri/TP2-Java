package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.handlers.BotonComoJugarHandler;
import view.handlers.BotonPantallaCompletaHandler;
import view.handlers.BotonPausaMusicaDeFondoHandler;
import view.handlers.BotonPlayMusicaDeFondoHandler;
import view.handlers.BotonSalirHandler;
import view.handlers.BotonStopMusicaDeFondoHandler;

public class MenuDelDuelo extends MenuBar {
	
		private MenuItem botonPantallaCompleta = new MenuItem("Pantalla completa");
		private Media musicaDeBatalla;
		private MediaPlayer reproductor;

	    public MenuDelDuelo(Stage stage,String pathMusicaBatalla) {
	    	
	    	super();
	    	
	    	this.musicaDeBatalla = new Media(pathMusicaBatalla);
	    	this.reproductor = new MediaPlayer(this.musicaDeBatalla);
	    	this.reproductor.setVolume(0.2);
	    	
	    	
	        Menu menuPantalla = new Menu("Pantalla");
	        Menu menuJuego = new Menu("Juego");
	        Menu menuMusica = new Menu("Musica");
	        		
	        MenuItem botonSalir = new MenuItem("Salir");
	        MenuItem botonComoJugar = new MenuItem("Como jugar");
	        
	        MenuItem botonPlay = new MenuItem("Play");
	        BotonPlayMusicaDeFondoHandler playMusica = new BotonPlayMusicaDeFondoHandler(this.musicaDeBatalla,this.reproductor);
	        botonPlay.setOnAction(playMusica);

	        MenuItem botonPausa = new MenuItem("Pausa");
	        BotonPausaMusicaDeFondoHandler pausarMusica = new BotonPausaMusicaDeFondoHandler(this.musicaDeBatalla,this.reproductor);
	        botonPausa.setOnAction(pausarMusica);
	        
	        MenuItem botonStop = new MenuItem("Stop");
	        BotonStopMusicaDeFondoHandler stopMusica = new BotonStopMusicaDeFondoHandler(this.musicaDeBatalla,this.reproductor);
	        botonStop.setOnAction(stopMusica);
	        
	        BotonSalirHandler salir = new BotonSalirHandler();
	        botonSalir.setOnAction(salir);

	        BotonComoJugarHandler abrirTutorial = new BotonComoJugarHandler();
	        botonComoJugar.setOnAction(abrirTutorial);

	        BotonPantallaCompletaHandler opcionPantallaCompletaHandler = new BotonPantallaCompletaHandler(stage, botonPantallaCompleta);
	        botonPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);


	        menuJuego.getItems().addAll(botonComoJugar,new SeparatorMenuItem(), botonSalir);
	        menuPantalla.getItems().addAll(botonPantallaCompleta);
	        menuMusica.getItems().addAll(botonPlay,new SeparatorMenuItem(),botonPausa,new SeparatorMenuItem(),botonStop);

	        this.getMenus().addAll(menuJuego, menuPantalla,menuMusica);
	    }

	    public void aplicacionMaximizada() {
	    	botonPantallaCompleta.setDisable(false);

	    }
}
