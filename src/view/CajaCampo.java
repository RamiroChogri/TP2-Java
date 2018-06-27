package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import viewSupportFiles.PathArchivos;

public class CajaCampo extends VBox implements PathArchivos{

	CajaInformacion cajaInformacion;
	
	EspacioCartasCampo campoJ1;
	EspacioCartasCampo campoJ2;
	ManoJugador manoJugador1;
	ManoJugador manoJugador2;
	
	public CajaCampo(CajaInformacion cajaInformacion) {
		
		this.cajaInformacion = cajaInformacion;
		
		this.manoJugador1 = new ManoJugador();
		this.manoJugador1.setAlignment(Pos.BOTTOM_CENTER);
		
		this.manoJugador2 = new ManoJugador();
		this.manoJugador2.setAlignment(Pos.TOP_CENTER);
		
		this.campoJ1 = new EspacioCartasCampo(cajaInformacion);
		this.campoJ2 = new EspacioCartasCampo(180,cajaInformacion);
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		VBox.setVgrow(manoJugador2, Priority.ALWAYS);
		VBox.setVgrow(manoJugador1, Priority.ALWAYS);
		
		this.getChildren().addAll(manoJugador2,campoJ2,campoJ1,manoJugador1);
		
		this.setStyle("-fx-background-color: BLACK");
		
		this.pintarCartaMonstruoEnCampoJugador1(1);
//		this.enviarCartaMonstruoAlCementerio(1); //NO LLamar a este metodo x ahora
	}
	
	public void pintarCartaMonstruoEnCampoJugador1(int posicionDeCartaMonstruo) {
		Image imagen= new Image(pathDePackCartas +"bueyDeBatalla.jpg");
		this.campoJ1.getEspacioCartaMosntruo(1).pintarCartaEnModoAtaque(imagen);
	}
	
	public void enviarCartaMonstruoAlCementerio(int posicionDeCartaMonstruo) {
		EspacioCementerio cementerio = this.campoJ1.getCementerio();
		this.campoJ1.getEspacioCartaMosntruo(1).enviarAl(cementerio);
		
	}
}
