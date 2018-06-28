package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jugador.Jugador;
import partida.Partida;

public class EspacioCartasCampo extends GridPane{
	
	private	CajaInformacion cajaInformacion;
	private EspacioCarta espacioMosntruo1;
	private EspacioCarta espacioMosntruo2;
	private	EspacioCarta espacioMosntruo3;
	private	EspacioCarta espacioMosntruo4;
	private	EspacioCarta espacioMosntruo5;
	
	private	EspacioCartaMagica espacioMagico1;
	private	EspacioCartaMagica espacioMagico2;
	private	EspacioCartaMagica espacioMagico3;
	private	EspacioCartaMagica espacioMagico4;
	private	EspacioCartaMagica espacioMagico5;
	
	private	EspacioCementerio espacioCementerio;
	private	Rectangle espacioMazo;
	private	EspacioCartaMagica espacioCampo;
	private	Rectangle espacioRelleno;
	private Jugador jugador;
	
	
	public EspacioCartasCampo(CajaInformacion cajaInformacion, Jugador jugadorYugi) {
		
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorYugi;
		
		this.setEspaciosDeCampo(jugadorYugi);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(0, espacioCampo,espacioMosntruo1,espacioMosntruo2,espacioMosntruo3,espacioMosntruo4,espacioMosntruo5,espacioCementerio);
		this.addRow(1,espacioRelleno, espacioMagico1,espacioMagico2,espacioMagico3,espacioMagico4,espacioMagico5,espacioMazo);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public EspacioCartasCampo(int gradosDeRotacion,CajaInformacion cajaInformacion,Jugador jugadorKaiba) {
		
		this.cajaInformacion = cajaInformacion;
		this.jugador = jugadorKaiba;
		
		this.setEspaciosDeCampo(jugadorKaiba);
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(1,espacioCementerio,espacioMosntruo5,espacioMosntruo4,espacioMosntruo3,espacioMosntruo2,espacioMosntruo1,espacioCampo);
		this.addRow(0,espacioMazo,espacioMagico5,espacioMagico4,espacioMagico3,espacioMagico2,espacioMagico1,espacioRelleno);
		
		this.setAlignment(Pos.CENTER);
	}
	
	private void setEspaciosDeCampo(Jugador jugadorPerteneciente) {
		this.espacioMosntruo1 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMosntruo2 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMosntruo3 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMosntruo4 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		this.espacioMosntruo5 = new EspacioCarta(cajaInformacion,jugadorPerteneciente);
		
		this.espacioMagico1 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico2 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico3 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico4 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioMagico5 = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		
		this. espacioCementerio = new EspacioCementerio();
		this. espacioMazo = new Rectangle(60,100,Color.BROWN);
		this. espacioCampo = new EspacioCartaMagica(cajaInformacion,jugadorPerteneciente);
		this.espacioRelleno = new Rectangle(60,100,Color.BLACK);
	}

	public EspacioCarta getEspacioCartaMosntruo(int posicionDeCartaMonstruo) {
		EspacioCarta cartaBuscada = null;

	    //No hay manera de hacerlo sin if
	  if(posicionDeCartaMonstruo == 1)
		  cartaBuscada = this.espacioMosntruo1;
	  else if(posicionDeCartaMonstruo == 2)
	  	cartaBuscada = this.espacioMosntruo2;
	  else if(posicionDeCartaMonstruo == 3)
		  cartaBuscada = this.espacioMosntruo3;
	  else if(posicionDeCartaMonstruo == 4)
		  	cartaBuscada = this.espacioMosntruo4;
	  else if(posicionDeCartaMonstruo == 5)
		  	cartaBuscada = this.espacioMosntruo5;
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
	
	public EspacioCartaMagica getEspacioCartaCampo() {
		return this.espacioCampo;
	}
	
	public void limpiarCampo() {
		this.setEspaciosDeCampo(this.jugador);
	}
	
	
}
