package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import jugador.Jugador;
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
		
		//esto es para probar si se pintan las zonas
		this.pintarCartaMagicaBocaAbajoEnCampoJugador1(2);
		this.pintarCartaMagicaBocaArribaEnCampoJugador2(3);
	}
	
	public void pintarCartaMonstruoEnCampoJugador1(int posicionDeCartaMonstruo) {
		Image imagen= new Image(pathDePackCartas +"bueyDeBatalla.jpg");
		this.campoJ1.getEspacioCartaMosntruo(1).pintarCartaEnModoAtaque(imagen);
	}
	
	public void enviarCartaMonstruoAlCementerio(int posicionDeCartaMonstruo) {
		EspacioCementerio cementerio = this.campoJ1.getCementerio();
		this.campoJ1.getEspacioCartaMosntruo(1).enviarAl(cementerio);
		
	}
	
	public void actualizarVistaYugiEnTurno(Jugador yugi, Jugador kaiba) {
		
		this.actualizarCartasEnCampoCentral(yugi, kaiba);
		
		this.manoJugador1.pintarCartasEnManoJugador(cajaInformacion, yugi.obtenerCartasEnMano());
		this.manoJugador2.darVueltaCartasEnManoJugador(this.cajaInformacion, kaiba.obtenerCartasEnMano());
		
	}
	
	public void actualizarVistaKaibaEnTurno(Jugador kaiba, Jugador yugi) {
		
		this.actualizarCartasEnCampoCentral(yugi, kaiba);
		
		this.manoJugador1.darVueltaCartasEnManoJugador(this.cajaInformacion, yugi.obtenerCartasEnMano());
		this.manoJugador2.pintarCartasEnManoJugador(cajaInformacion, kaiba.obtenerCartasEnMano());
		
		
	}

	public void actualizarCartasEnCampoCentral(Jugador yugi, Jugador kaiba) {
		
		this.campoJ1.pintarCartasEnZonaMonstruos(this.cajaInformacion, yugi.obtenerCartasEnZonaMonstruo());
		this.campoJ2.pintarCartasEnZonaMonstruos(this.cajaInformacion, kaiba.obtenerCartasEnZonaMonstruo());
		
		this.campoJ1.pintarCartasEnZonaMagicasYTrampas(this.cajaInformacion, yugi.obtenerCartasEnZonaMagiasYTrampas());
		this.campoJ2.pintarCartasEnZonaMagicasYTrampas(this.cajaInformacion, yugi.obtenerCartasEnZonaMagiasYTrampas());
		
		this.campoJ1.pintarCartaZonaCampo(this.cajaInformacion, yugi.obtenerCartaEnZonaCampo);
		this.campoJ2.pintarCartaZonaCampo(this.cajaInformacion, kaiba.obtenerCartaEnZonaCampo);
		
	}
	
	//ESTOS METODOS SON DE PRUEBA, SOLO PINTAN UNA CARTA ESPECIFICA QUE HARDCODIE
	public void pintarCartaMagicaBocaAbajoEnCampoJugador1(int posicionDeCartaMagica) {
		Image imagen = new Image(pathDePackCartas + "fisura.jpg");
		
		this.campoJ1.getEspacioCartaMagica(posicionDeCartaMagica).pintarCartaBocaAbajo(imagen);
	}
	
	public void pintarCartaMagicaBocaArribaEnCampoJugador2(int posicionDeCartaMagica) {
		Image imagen = new Image(pathDePackCartas + "fisura.jpg");
		
		this.campoJ2.getEspacioCartaMagica(posicionDeCartaMagica).pintarCartaBocaArriba(imagen);
	}
}
