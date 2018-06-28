package view;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Activable;
import cartas.Atacable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import jugador.Jugador;
import partida.Partida;
import viewSupportFiles.PathArchivos;

public class CajaCampo extends VBox implements PathArchivos{

	CajaInformacion cajaInformacion;
	
	EspacioCartasCampo campoJ1;
	EspacioCartasCampo campoJ2;
	ManoJugador manoYugi;
	ManoJugador manoKaiba;
	
	public CajaCampo(CajaInformacion cajaInformacion,Partida duelo) {
		
		this.cajaInformacion = cajaInformacion;
		
		this.manoYugi = new ManoJugador(duelo,duelo.getJugadorYugi());
		this.manoYugi.setAlignment(Pos.BOTTOM_CENTER);
		
		this.manoKaiba = new ManoJugador(duelo,duelo.getJugadorKaiba());
		this.manoKaiba.setAlignment(Pos.TOP_CENTER);
		
		this.campoJ1 = new EspacioCartasCampo(cajaInformacion,duelo);
		this.campoJ2 = new EspacioCartasCampo(180,cajaInformacion,duelo);
		
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		VBox.setVgrow(manoKaiba, Priority.ALWAYS);
		VBox.setVgrow(manoYugi, Priority.ALWAYS);
		
		this.getChildren().addAll(manoKaiba,campoJ2,campoJ1,manoYugi);
		
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
	
	public void actualizarVistaYugiEnTurno(Jugador yugi, Jugador kaiba) {
		
		this.actualizarCartasEnCampoCentral(yugi, kaiba);
		
		this.manoYugi.pintarCartasEnManoJugador(cajaInformacion);
		this.manoKaiba.darVueltaCartasEnManoJugador(this.cajaInformacion);
		
	}
	
	public void actualizarVistaKaibaEnTurno(Jugador kaiba, Jugador yugi) {
		
		this.actualizarCartasEnCampoCentral(yugi, kaiba);
		
		this.manoYugi.darVueltaCartasEnManoJugador(this.cajaInformacion);
		this.manoKaiba.pintarCartasEnManoJugador(cajaInformacion);
		
		
	}

	public void actualizarCartasEnCampoCentral(Jugador yugi, Jugador kaiba) {
		
		this.campoJ1.limpiarCampo();
		this.pintarCartasEnZonaMonstruosJugador1(yugi.obtenerMonstruosColocados());
		this.pintarCartasEnZonaMonstruosJugador2(kaiba.obtenerMonstruosColocados());
		
		this.pintarCartasEnZonaMagicasYTrampasJugador1(yugi.obtenerMagicasYTrampasColocadas());
		this.pintarCartasEnZonaMagicasYTrampasJugador2(kaiba.obtenerMagicasYTrampasColocadas());
		
		this.pintarCartaZonaCampoJugador1(yugi.obtenerCartaCampoColocada());
		this.pintarCartaZonaCampoJugador2(kaiba.obtenerCartaCampoColocada());
		
	}
	
	public void pintarCartasEnZonaMonstruosJugador1(LinkedList<Atacable> monstruosYugi) {
		
		Iterator<Atacable> posicionesIterador = monstruosYugi.iterator();
		int posicionActual = 0;
		Atacable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
		
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			if (cartaActual.estaColocadaBocaAbajo()) {
				campoJ1.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoDefensaBocaAbajo(imagen);
			} else if (cartaActual.estaEnModoAtaque()) {
				campoJ1.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoAtaque(imagen);
			} else {
				campoJ1.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoDefensaBocaArriba(imagen);
			}
		
		}
	}
	
	
	public void pintarCartasEnZonaMonstruosJugador2(LinkedList<Atacable> monstruosKaiba) {
		
		Iterator<Atacable> posicionesIterador = monstruosKaiba.iterator();
		int posicionActual = 0;
		Atacable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
		
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			if (cartaActual.estaColocadaBocaAbajo()) {
				campoJ2.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoDefensaBocaAbajo(imagen);
			} else if (cartaActual.estaEnModoAtaque()) {
				campoJ2.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoAtaque(imagen);
			} else {
				campoJ2.getEspacioCartaMosntruo(posicionActual).pintarCartaEnModoDefensaBocaArriba(imagen);
			}
		
		}
	}
	
	public void pintarCartasEnZonaMagicasYTrampasJugador1(LinkedList<Activable> activablesYugi) {
		
		Iterator<Activable> posicionesIterador = activablesYugi.iterator();
		int posicionActual = 0;
		Activable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
		
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			if (cartaActual.estaColocadaBocaAbajo()) {
				campoJ1.getEspacioCartaMagica(posicionActual).pintarCartaBocaAbajo(imagen);
			} else {
				campoJ1.getEspacioCartaMagica(posicionActual).pintarCartaBocaArriba(imagen);
			}
		
		}
	}
	
	public void pintarCartasEnZonaMagicasYTrampasJugador2(LinkedList<Activable> activablesKaiba) {
		
		Iterator<Activable> posicionesIterador = activablesKaiba.iterator();
		int posicionActual = 0;
		Activable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
		
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			if (cartaActual.estaColocadaBocaAbajo()) {
				campoJ2.getEspacioCartaMagica(posicionActual).pintarCartaBocaAbajo(imagen);
			} else {
				campoJ2.getEspacioCartaMagica(posicionActual).pintarCartaBocaArriba(imagen);
			}
		
		}
	}
	
	public void pintarCartaZonaCampoJugador1(LinkedList<Activable> activableYugi) {
		Iterator<Activable> posicionesIterador = activableYugi.iterator();
		int posicionActual = 0;
		Activable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			campoJ1.getEspacioCartaMagica(posicionActual).pintarCartaBocaArriba(imagen);
		}
	}
	
	public void pintarCartaZonaCampoJugador2(LinkedList<Activable> activableKaiba) {
		Iterator<Activable> posicionesIterador = activableKaiba.iterator();
		int posicionActual = 0;
		Activable cartaActual;
		Image imagen;
		while(posicionesIterador.hasNext()) {
			posicionActual++;
			cartaActual = posicionesIterador.next();
			imagen = new Image(pathDePackCartas + cartaActual.getNombreDeLaImagen());
			campoJ2.getEspacioCartaMagica(posicionActual).pintarCartaBocaArriba(imagen);
		}
	}
	
	

}
