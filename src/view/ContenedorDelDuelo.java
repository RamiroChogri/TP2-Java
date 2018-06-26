package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
//	        this.setTableros();
	        this.setManos();
	    }
	    
	    public void setMenu(Stage stage) {
	            this.menuBar = new MenuDelDuelo(stage,this.pathMusicaDeBatalla);
	            this.setTop(menuBar);
	    }
	    
	    public void setPerfilJugadores() {
	    	final ImageView yugiView = new ImageView();
	    	yugiView.setFitWidth(150);
	    	yugiView.setFitHeight(150);
	    	
	    	final ImageView kaibaView = new ImageView();
	    	kaibaView.setFitWidth(125);
	    	kaibaView.setFitHeight(125);
	    	
	    	Image kaiba = new Image(pathImagenKaiba);
	    	kaibaView.setImage(kaiba);
	    	
	    	Image yugi = new Image(pathImagenYugi);
	    	yugiView.setImage(yugi);
	    	
	    	VistaJugador perfilJugador1 = new VistaJugador(yugiView);
	    	perfilJugador1.setAlignment(Pos.BOTTOM_LEFT);
	    	VistaJugador perfilJugador2 = new VistaJugador(kaibaView,true);
	    	perfilJugador2.setAlignment(Pos.TOP_RIGHT);
	    	
	    	VBox cajav = new VBox();
	    	cajav.setAlignment(Pos.TOP_LEFT);
	    	cajav.getChildren().addAll(perfilJugador2,perfilJugador1);
	    	VBox.setVgrow(perfilJugador1, Priority.ALWAYS);
	    	
	    	this.setLeft(cajav);
//	    	this.setLeft(perfilJugador1);
//	    	this.setRight(perfilJugador2);
	    }
	    
	    public void setTableros() {
//	    	VistaCampo campo = new VistaCampo();
	    	
//	    	this.setCenter(campo);
	    }
	    
	    
	    public void setManos() {
	    	ManoJugador manoJugadorPrincipal = new ManoJugador();
	    	
	    	this.setBottom(manoJugadorPrincipal);
	    	
	    }
	    
//	    public void setImageTest() {
//	    	
//	    	final ImageView imagenV = new ImageView();
//	    	imagenV.setFitWidth(200);
//	    	imagenV.setFitHeight(200);
//	    	imagenV.setPreserveRatio(true);
//	    	Image imagen = new Image("file:///C:/Users/marcelo/Documents/Desktop/Algo%203/TP2-Java/src/viewSupportFiles/yugioh%20wpp.png");
//	    	imagenV.setImage(imagen);
//	    	
//	    	VBox cajaV = new VBox();
//	    	cajaV.setAlignment(Pos.BOTTOM_LEFT);
//	    	cajaV.getChildren().add(imagenV);
//	    	this.setLeft(cajaV);
//	    }
}
