package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import partida.Partida;

public class EspacioCartasCampo extends GridPane{
	
	private	CajaInformacion cajaInformacion;
	private EspacioCarta espacioMonstruo1;
	private EspacioCarta espacioMonstruo2;
	private	EspacioCarta espacioMonstruo3;
	private	EspacioCarta espacioMonstruo4;
	private	EspacioCarta espacioMonstruo5;
	
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
	
	
	public EspacioCartasCampo(CajaInformacion cajaInformacion, Jugador jugadorYugi) {
		
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorYugi;
		
		this.setEspaciosDeCampo(jugadorYugi);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(0, espacioCampo,espacioMonstruo1,espacioMonstruo2,espacioMonstruo3,espacioMonstruo4,espacioMonstruo5,espacioCementerio);
		this.addRow(1,espacioRelleno, espacioMagico1,espacioMagico2,espacioMagico3,espacioMagico4,espacioMagico5,espacioMazo);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public EspacioCartasCampo(int gradosDeRotacion,CajaInformacion cajaInformacion,Jugador jugadorKaiba) {
		
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorKaiba;
		
		this.setEspaciosDeCampo(jugadorKaiba);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(1,espacioCementerio,espacioMonstruo5,espacioMonstruo4,espacioMonstruo3,espacioMonstruo2,espacioMonstruo1,espacioCampo);
		this.addRow(0,espacioMazo,espacioMagico5,espacioMagico4,espacioMagico3,espacioMagico2,espacioMagico1,espacioRelleno);
		
		this.setAlignment(Pos.CENTER);
	}
	
	private void setEspaciosDeCampo(Jugador jugadorPerteneciente) {
		this.espacioMonstruo1 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMonstruo2 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMonstruo3 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMonstruo4 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMonstruo5 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		
		this.espacioMagico1 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico2 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico3 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico4 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico5 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		
		this. espacioCementerio = new EspacioCementerio();
		this. espacioMazo = new EspacioMazo(jugadorPerteneciente);
		this. espacioCampo = new EspacioCartaCampo(cajaInformacion,jugadorPerteneciente);
		this.espacioRelleno = new Rectangle(60,100,Color.BLACK);
	}

	public EspacioCarta getEspacioCartaMonstruo(int posicionDeCartaMonstruo) {
		EspacioCarta cartaBuscada = null;

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
			EspacioCarta espacioActual = this.getEspacioCartaMonstruo(i);
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
	
	
}
