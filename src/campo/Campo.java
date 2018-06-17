package campo;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Destruible;
import cartas.CartaCampo;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import cartas.CartaTrampa;
import exceptions.*;

public class Campo {

	private int vidaDelJugador;
	private ZonaMonstruo zonaMonstruo;
	private ZonaUtilidad zonaUtilidad;
	private ZonaCampo zonaCampo;
	private Cementerio cementerio;
	private Mazo mazoDelJugador;
	
	
	public Campo() {
		//Todas las zonas se inicializan vacias y el mazo se inicializa con 40 cartas
		//ordenadas aleatoriamente
		this.vidaDelJugador = 8000;
		this.zonaMonstruo = new ZonaMonstruo();
		this.zonaUtilidad = new ZonaUtilidad();
		this.zonaCampo = new ZonaCampo();
		this.cementerio = new Cementerio();
		this.mazoDelJugador = new Mazo();
	}

	//Seguir con la excepcion
	
	public void colocarCarta(CartaMonstruo cartaMonstruoAColocar) {
		try {
			zonaMonstruo.colocarCarta(cartaMonstruoAColocar);
		} catch (Exception zonaMonstruoLlenaException) {
			System.out.println("No se puede invocar el monstruo, el campo esta lleno");
			//throw new ZonaMonstruoLlenaException();
		}
	
	}
	
	public void colocarCarta(CartaMagica cartaMagicaAColocar) {
		try {
			zonaUtilidad.colocarCarta(cartaMagicaAColocar);
		} catch (Exception zonaUtilidadLlenaException) {
			System.out.println("No se puede invocar la carta magica, el campo esta lleno");
	//		throw new ZonaUtilidadLlenaException();
		}
	}
	
	public void colocarCarta(CartaTrampa cartaTrampaAColocar) {
		try {
			zonaUtilidad.colocarCarta(cartaTrampaAColocar);
		} catch (Exception zonaUtilidadLlenaException) {
			System.out.println("No se puede invocar la carta trampa, el campo esta lleno");
		//	throw new ZonaUtilidadLlenaException();
		}
	}
	
	public void colocarCarta(CartaCampo cartaCampoAColocar) {
		try {
			zonaCampo.colocarCarta(cartaCampoAColocar);
		} catch (Exception zonaCampoLlenaException) {
			System.out.println("No se puede invocar la carta campo, el campo esta lleno");
		//	throw new ZonaCampoLlenaException();
		}
	}
	
	public int obtenerCantidadDeCartasEnZonaMonstruo() {
		return zonaMonstruo.obtenerCantidadDeCartas();
	}
	
	
	public int obtenerCantidadDeCartasEnZonaUtilidad() {
		return zonaUtilidad.obtenerCantidadDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnZonaCampo() {
		return zonaCampo.obtenerCantidadDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnMazo() {
		return mazoDelJugador.obtenerCantidaDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnCementerio() {
		return cementerio.obtenerCantidadDeCartas();
	}
	
	
	public boolean tieneCartas() {

		return ((this.obtenerCantidadDeCartasEnZonaMonstruo() + this.obtenerCantidadDeCartasEnZonaUtilidad() + this.obtenerCantidadDeCartasEnZonaCampo()) > 0);

	}
	
	public int obtenerCantidadDeCartasEnJuego() {
		
		return (this.obtenerCantidadDeCartasEnZonaMonstruo() + this.obtenerCantidadDeCartasEnZonaUtilidad() + this.obtenerCantidadDeCartasEnZonaCampo());
	}
	
	public int obtenerVidaRestante() {
		
		return this.vidaDelJugador;
	}
	
	public Destruible levantarCartaDelMazo() {
		return this.mazoDelJugador.levantarCarta();
	}
	
//	public void colocarMonstruoEnModoAtaque(CartaMonstruo cartaAColocar) {
//		
//		cartaAColocar.colocarEnModoAtaque();
//		this.colocarCarta(cartaAColocar);
//	}
//
//	public void colocarMonstruoBocaArribaEnModoDefensa(CartaMonstruo cartaAColocar) {
//		
//		cartaAColocar.colocarBocaArribaEnModoDefensa();
//		this.colocarCarta(cartaAColocar);
//		
//	}
//
//	public void colocarMonstruoBocaAbajoEnModoDefensa(CartaMonstruo cartaAColocar) {
//		
//		cartaAColocar.colocarBocaAbajoEnModoDefensa();
//		this.colocarCarta(cartaAColocar);
//		
//	}
//
//	public void colocarCartaMagicaBocaAbajo(CartaMagica cartaAColocar) {
//		
//		cartaAColocar.colocarBocaAbajo();
//		this.colocarCarta(cartaAColocar);
//		
//	}
//	
//	public void colocarCartaMagicaBocaArriba(CartaMagica cartaAColocar) {
//		
//		cartaAColocar.colocarBocaArriba();
//		this.colocarCarta(cartaAColocar);
//		
//	}
//
//	public void colocarCartaTrampaBocaAbajo(CartaTrampa cartaAColocar) {
//		
//		cartaAColocar.colocarBocaAbajo();
//		this.colocarCarta(cartaAColocar);
//		
//	}
//
//	public void colocarCartaTrampaBocaArriba(CartaTrampa cartaAColocar) {
//		
//		cartaAColocar.colocarBocaArriba();
//		this.colocarCarta(cartaAColocar);
//		
//	}

	public void enviarCartasDestruidasAlCementerio() {
		int danio = this.zonaMonstruo.obtenerDanioRecibido();
		LinkedList<Destruible> cartasAEnterrar = new LinkedList<Destruible>();
		cartasAEnterrar.addAll(this.zonaMonstruo.recolectarCartasDestruidas());
		cartasAEnterrar.addAll(this.zonaUtilidad.recolectarCartasDestruidas());
		// this.enterrarCartaCampo(); Error, me agrega null a la lista y para ahorrar if lo comentamos por ahora
		this.cementerio.agregarCartasAlCementerio(cartasAEnterrar);
		
		vidaDelJugador -= danio;
		
	}
	
	public void vaciarZonaMonstruos() {
		this.zonaMonstruo.vaciar();
		this.enviarCartasDestruidasAlCementerio();
	}
	
	public void eliminarUltimaCartaMonstruoColocada() {
		this.zonaMonstruo.eliminarUltimaCartaMonstruoColocada();
		this.enviarCartasDestruidasAlCementerio();
	}

}