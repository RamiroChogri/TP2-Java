package campo;

import java.util.LinkedList;

import cartas.*;
import cartas.Destruible;
import estadoCarta.EstadoCarta;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.NoHayLugarVacioException;

public class Campo {

	private int vidaDelJugador;
	private ZonaMonstruos monstruos;
	private ZonaMagicasYTrampas magicasYTrampas ;
	private ZonaCampo espacioCampo;
	private Cementerio cementerio;
	private Mazo mazoDelJugador;
	
	
	public Campo() {
		//Todas las zonas se inicializan vacias y el mazo se inicializa con 40 cartas
		//ordenadas aleatoriamente
		this.vidaDelJugador = 8000;
		this.monstruos = new ZonaMonstruos();
		this.magicasYTrampas = new ZonaMagicasYTrampas();
		this.espacioCampo = new ZonaCampo();
		this.cementerio = new Cementerio();
		this.mazoDelJugador = new Mazo();
	}

	////////////////////////////////////
	
	public void colocarCarta(Colocable cartaAColocar,EstadoCarta estadoAColocar) throws NoHayLugarVacioException {
		cartaAColocar.colocarse(monstruos, magicasYTrampas, espacioCampo, estadoAColocar);
	}
	
	//////////////////////////////////
	//Seguir con la excepcion
	
	public int obtenerCantidadDeCartasEnZonaMonstruo() {
		return monstruos.obtenerCantidadDeCartas();
	}
	
	
	public int obtenerCantidadDeCartasEnZonaUtilidad() {
		return magicasYTrampas.obtenerCantidadDeCartas();
	}
	
	public int obtenerCantidadDeCartasEnZonaCampo() {
		return espacioCampo.obtenerCantidadDeCartas();
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
	
	public Colocable levantarCartaDelMazo() {
		return this.mazoDelJugador.levantarCarta();
	}
	
	public void enviarCartasDestruidasAlCementerio() {
		int danio = this.monstruos.obtenerDanioRecibido();
		LinkedList<Destruible> cartasAEnterrar = new LinkedList<Destruible>();
		cartasAEnterrar.addAll(this.monstruos.recolectarCartasDestruidas());
		cartasAEnterrar.addAll(this.magicasYTrampas.recolectarCartasDestruidas());
		// this.enterrarCartaCampo(); Error, me agrega null a la lista y para ahorrar if lo comentamos por ahora
		this.cementerio.agregarCartasAlCementerio(cartasAEnterrar);
		
		vidaDelJugador -= danio;
		
	}
	
	public void vaciarZonaMonstruos() {
		this.monstruos.vaciar();
		this.enviarCartasDestruidasAlCementerio();
	}
	
	public void eliminarUltimaCartaMonstruoColocada() {
		this.monstruos.eliminarUltimaCartaMonstruoColocada();
		this.enviarCartasDestruidasAlCementerio();
	}

	public void activarEfectoDeCampo(Campo campoEnemigo) {
		this.espacioCampo.activarEfectoDeCampo(this,campoEnemigo);
	}
	
//	public void colocarCarta(Atacable cartaMonstruoAColocar , Estrategia boca, Modo modo) {
//	try {
//		monstruos.colocarCarta(cartaMonstruoAColocar);
//	} catch (Exception zonaMonstruoLlenaException) {
//		System.out.println("No se puede invocar el monstruo, el campo esta lleno");
//		//throw new ZonaMonstruoLlenaException();
//	}
//
//}
//
//public void colocarCarta(CartaMagica cartaMagicaAColocar, Estrategia boca) {
//	try {
//		zonaUtilidad.colocarCarta(cartaMagicaAColocar);
//	} catch (Exception zonaUtilidadLlenaException) {
//		System.out.println("No se puede invocar la carta magica, el campo esta lleno");
////		throw new ZonaUtilidadLlenaException();
//	}
//}
//
//public void colocarCarta(CartaTrampa cartaTrampaAColocar) {
//	try {
//		zonaUtilidad.colocarCarta(cartaTrampaAColocar);
//	} catch (Exception zonaUtilidadLlenaException) {
//		System.out.println("No se puede invocar la carta trampa, el campo esta lleno");
//	//	throw new ZonaUtilidadLlenaException();
//	}
//}
//
//public void colocarCarta(CartaCampo cartaCampoAColocar) {
//	try {
//		zonaCampo.colocarCarta(cartaCampoAColocar);
//	} catch (Exception zonaCampoLlenaException) {
//		System.out.println("No se puede invocar la carta campo, el campo esta lleno");
//	//	throw new ZonaCampoLlenaException();
//	}
//}
	
	
// ---------------------------------------------------
	
	
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


}