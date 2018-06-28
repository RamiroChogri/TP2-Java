package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EspacioCartasCampo extends GridPane{
	
	CajaInformacion cajaInformacion;
	EspacioCarta espacioMosntruo1;
	EspacioCarta espacioMosntruo2;
	EspacioCarta espacioMosntruo3;
	EspacioCarta espacioMosntruo4;
	EspacioCarta espacioMosntruo5;
	
	EspacioCartaMagica espacioMagico1;
	EspacioCartaMagica espacioMagico2;
	EspacioCartaMagica espacioMagico3;
	EspacioCartaMagica espacioMagico4;
	EspacioCartaMagica espacioMagico5;
	
	EspacioCementerio espacioCementerio;
	Rectangle espacioMazo;
	Rectangle espacioCampo;
	Rectangle espacioRelleno;
	
	public EspacioCartasCampo(CajaInformacion cajaInformacion) {
		
		this.cajaInformacion = cajaInformacion;
		
		this.setEspaciosDeCampo();
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(0, espacioCampo,espacioMosntruo1,espacioMosntruo2,espacioMosntruo3,espacioMosntruo4,espacioMosntruo5,espacioCementerio);
		this.addRow(1,espacioRelleno, espacioMagico1,espacioMagico2,espacioMagico3,espacioMagico4,espacioMagico5,espacioMazo);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public EspacioCartasCampo(int gradosDeRotacion,CajaInformacion cajaInformacion) {
		
		this.cajaInformacion = cajaInformacion;
		
		this.setEspaciosDeCampo();
		
		this.setHgap(10);
		this.setVgap(10);
		this.addRow(1,espacioCementerio,espacioMosntruo5,espacioMosntruo4,espacioMosntruo3,espacioMosntruo2,espacioMosntruo1,espacioCampo);
		this.addRow(0,espacioMazo,espacioMagico5,espacioMagico4,espacioMagico3,espacioMagico2,espacioMagico1,espacioRelleno);
		
		this.setAlignment(Pos.CENTER);
	}
	
	private void setEspaciosDeCampo() {
		this.espacioMosntruo1 = new EspacioCarta(cajaInformacion);
		this.espacioMosntruo2 = new EspacioCarta(cajaInformacion);
		this.espacioMosntruo3 = new EspacioCarta(cajaInformacion);
		this.espacioMosntruo4 = new EspacioCarta(cajaInformacion);
		this.espacioMosntruo5 = new EspacioCarta(cajaInformacion);
		
		this.espacioMagico1 = new EspacioCartaMagica(cajaInformacion);
		this.espacioMagico2 = new EspacioCartaMagica(cajaInformacion);
		this.espacioMagico3 = new EspacioCartaMagica(cajaInformacion);
		this.espacioMagico4 = new EspacioCartaMagica(cajaInformacion);
		this.espacioMagico5 = new EspacioCartaMagica(cajaInformacion);
		
		this. espacioCementerio = new EspacioCementerio();
		this. espacioMazo = new Rectangle(60,100,Color.BROWN);
		this. espacioCampo = new Rectangle(60,100,Color.GREEN);
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
	
	public void limpiarCampo() {
		this.setEspaciosDeCampo();
	}
	
	
}
