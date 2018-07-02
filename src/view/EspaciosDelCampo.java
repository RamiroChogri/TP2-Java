package view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import partida.Partida;
import viewSupportFiles.PathArchivos;

public class EspaciosDelCampo extends GridPane implements PathArchivos{
	
	private	CajaInformacion cajaInformacion;
	private EspacioCartaMonstruo espacioMonstruo1;
	private EspacioCartaMonstruo espacioMonstruo2;
	private	EspacioCartaMonstruo espacioMonstruo3;
	private	EspacioCartaMonstruo espacioMonstruo4;
	private	EspacioCartaMonstruo espacioMonstruo5;
	
	private	EspacioCartaMagica espacioMagico1;
	private	EspacioCartaMagica espacioMagico2;
	private	EspacioCartaMagica espacioMagico3;
	private	EspacioCartaMagica espacioMagico4;
	private	EspacioCartaMagica espacioMagico5;
	
	private	EspacioCementerio espacioCementerio;
	private	EspacioMazo espacioMazo;
	private	EspacioCartaCampo espacioCampo;
	private	Rectangle espacioRelleno;
	private Jugador jugador;
	private ContenedorDelDuelo cajaDuelo;
	private Partida duelo;
	
	public EspaciosDelCampo(CajaInformacion cajaInformacion, Partida duelo, Jugador jugadorYugi, ContenedorDelDuelo cajaDueloRecibida) {
		
		this.duelo = duelo;
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorYugi;
		this.cajaDuelo = cajaDueloRecibida;
		
		this.setEspaciosDeCampo(jugadorYugi);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(0, espacioCampo,espacioMonstruo1,espacioMonstruo2,espacioMonstruo3,espacioMonstruo4,espacioMonstruo5,espacioCementerio);
		this.addRow(1,espacioRelleno, espacioMagico1,espacioMagico2,espacioMagico3,espacioMagico4,espacioMagico5,espacioMazo);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public EspaciosDelCampo(int gradosDeRotacion,CajaInformacion cajaInformacion, Partida duelo, Jugador jugadorKaiba, ContenedorDelDuelo cajaDueloRecibida) {
		
		this.duelo = duelo;
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorKaiba;
		this.cajaDuelo = cajaDueloRecibida;
		
		this.setEspaciosDeCampo(jugadorKaiba);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(1,espacioCementerio,espacioMonstruo5,espacioMonstruo4,espacioMonstruo3,espacioMonstruo2,espacioMonstruo1,espacioCampo);
		this.addRow(0,espacioMazo,espacioMagico5,espacioMagico4,espacioMagico3,espacioMagico2,espacioMagico1,espacioRelleno);
		
		this.setAlignment(Pos.CENTER);
	}
	
	private void setEspaciosDeCampo(Jugador jugadorPerteneciente) {
		this.espacioMonstruo1 = new EspacioCartaMonstruo(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMonstruo2 = new EspacioCartaMonstruo(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMonstruo3 = new EspacioCartaMonstruo(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMonstruo4 = new EspacioCartaMonstruo(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMonstruo5 = new EspacioCartaMonstruo(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		
		this.espacioMagico1 = new EspacioCartaMagica(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMagico2 = new EspacioCartaMagica(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMagico3 = new EspacioCartaMagica(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMagico4 = new EspacioCartaMagica(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		this.espacioMagico5 = new EspacioCartaMagica(this.cajaInformacion,this.duelo,jugadorPerteneciente, this.cajaDuelo);
		
		this. espacioCementerio = new EspacioCementerio();
		this. espacioMazo = new EspacioMazo(jugadorPerteneciente);
		this. espacioCampo = new EspacioCartaCampo(cajaInformacion,jugadorPerteneciente);
		this.espacioRelleno = new Rectangle(60,100,Color.BLACK);
	}

	public EspacioCartaMonstruo getEspacioCartaMonstruo(int posicionDeCartaMonstruo) {
		EspacioCartaMonstruo cartaBuscada = null;

	    //No hay manera de hacerlo sin if
	  if(posicionDeCartaMonstruo == 1)
		  cartaBuscada = this.espacioMonstruo1;
	  else if(posicionDeCartaMonstruo == 2)
	  	cartaBuscada = this.espacioMonstruo2;
	  else if(posicionDeCartaMonstruo == 3)
		  cartaBuscada = this.espacioMonstruo3;
	  else if(posicionDeCartaMonstruo == 4)
		  	cartaBuscada = this.espacioMonstruo4;
	  else if(posicionDeCartaMonstruo == 5)
		  	cartaBuscada = this.espacioMonstruo5;
	  else
		  cartaBuscada = null;

	    return cartaBuscada;
	}
	
	public EspacioCementerio getCementerio() {
		return this.espacioCementerio;
	}

	public EspacioCartaMagica getEspacioCartaMagica(int posicionDeCartaMagica) {
		EspacioCartaMagica cartaBuscada = null;

	    //No hay manera de hacerlo sin if
	  if(posicionDeCartaMagica == 1)
		  cartaBuscada = this.espacioMagico1;
	  else if(posicionDeCartaMagica == 2)
	  	cartaBuscada = this.espacioMagico2;
	  else if(posicionDeCartaMagica == 3)
		  cartaBuscada = this.espacioMagico3;
	  else if(posicionDeCartaMagica == 4)
		  	cartaBuscada = this.espacioMagico4;
	  else if(posicionDeCartaMagica == 5)
		  	cartaBuscada = this.espacioMagico5;
	  else
		  cartaBuscada = null;

	    return cartaBuscada;
	}
	
	public EspacioCartaCampo getEspacioCartaCampo() {
		return this.espacioCampo;
	}
	
	public void limpiarCampo() {
		for(int i = 1; i<=5;i++) {
			EspacioCartaMonstruo espacioActual = this.getEspacioCartaMonstruo(i);
			espacioActual.limpiar();
		}
		for(int i = 1; i<=5;i++) {
			EspacioCartaMagica espacioActual = this.getEspacioCartaMagica(i);
			espacioActual.limpiar();
		}
	}
	
	public void actualizarCantidadDeCartasEnMazo() {
		this.espacioMazo.actualizarCartasEnMazo();
	}

	public void actualizarCementerio() {
		if(jugador.obtenerCantidadDeCartasEnCementerio() >0) {
		String ultimaCartaCementerio = jugador.obtenerNombreDeLaImagenDeLaUltimaCartaDelCementerio();
		ImageView imagenUltimaCartaEnCementerio = new ImageView(new Image(pathDePackCartas + ultimaCartaCementerio));
		imagenUltimaCartaEnCementerio.setFitWidth(60);
		imagenUltimaCartaEnCementerio.setFitHeight(100);
		this.espacioCementerio.recibirCarta(imagenUltimaCartaEnCementerio);
		}
	}
	
	
}
