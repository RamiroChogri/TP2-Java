package campo;

import java.util.LinkedList;

import efectos.*;
import cartas.*;
import cartas.Destruible;
import estadoCarta.EstadoCarta;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHayMonstruoParaSacrificarException;
import jugador.Jugador;
import jugador.Mano;

public class Campo {

	private int vidaDelJugador;
	private ZonaMonstruos monstruos;
	private ZonaMagicasYTrampas magicasYTrampas ;
	private ZonaCampo espacioCampo;
	private Cementerio cementerio;
	private Mazo mazoDelJugador;
	private Mano manoDelJugador;
	
	public Campo() {
		//Todas las zonas se inicializan vacias y el mazo se inicializa con 40 cartas
		//ordenadas aleatoriamente
		this.vidaDelJugador = 8000;
		this.monstruos = new ZonaMonstruos();
		this.magicasYTrampas = new ZonaMagicasYTrampas();
		this.espacioCampo = new ZonaCampo();
		this.cementerio = new Cementerio();
		this.mazoDelJugador = new Mazo();
		this.manoDelJugador = null;
	}
	
	public Campo(Mano manoDelJugador) {
		//Todas las zonas se inicializan vacias y el mazo se inicializa con 40 cartas
		//ordenadas aleatoriamente
		this.vidaDelJugador = 8000;
		this.monstruos = new ZonaMonstruos();
		this.magicasYTrampas = new ZonaMagicasYTrampas();
		this.espacioCampo = new ZonaCampo();
		this.cementerio = new Cementerio();
		this.mazoDelJugador = new Mazo();
		this.manoDelJugador = manoDelJugador;
	}

	////////////////////////////////////
	
	public void aumentarAtaqueMonstruosPorEfectoCampo(Puntos puntosAtaque) {
		this.monstruos.aumentarAtaqueMonstruoPorEfectoCampo(puntosAtaque);
	}
	
	public void aumentarDefensaMonstruosPorEfectoCampo(Puntos puntosDefensa) {
		this.monstruos.aumentarDefensaMonstruoPorEfectoCampo(puntosDefensa);
	}
	
	public void colocarCarta(Jugador jugador, Colocable cartaAColocar,EstadoCarta estadoAColocar) throws NoHayLugarVacioException {
		cartaAColocar.colocarse(jugador, this.monstruos, this.magicasYTrampas, this.espacioCampo, this.cementerio, estadoAColocar);
	}
	
	//////////////////////////////////
	//Seguir con la excepcion
	
	public int obtenerCantidadDeCartasEnZonaMonstruos() {
		return monstruos.obtenerCantidadDeCartas();
	}
	
	
	public int obtenerCantidadDeCartasEnZonaMagicasYTrampas() {
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

		return ((this.obtenerCantidadDeCartasEnZonaMonstruos() + this.obtenerCantidadDeCartasEnZonaMagicasYTrampas() + this.obtenerCantidadDeCartasEnZonaCampo()) > 0);

	}
	
	public int obtenerCantidadDeCartasEnJuego() {
		
		return (this.obtenerCantidadDeCartasEnZonaMonstruos() + this.obtenerCantidadDeCartasEnZonaMagicasYTrampas() + this.obtenerCantidadDeCartasEnZonaCampo());
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
	
	//Para PotOfGreed	
	public void agregarCartaEnMano(Colocable cartaAColocar) {
		this.manoDelJugador.agregarCartaEnMano(cartaAColocar);
	}
	
	public Atacable obtenerCartaMonstruoConMenorAtaque() throws NoHayMonstruoParaSacrificarException {
		Atacable monstruoConMenorAtaque = this.monstruos.obtenerMonstruoConMenorAtaque();
		return monstruoConMenorAtaque;
	}
	
	public void recibirDanioDirecto(Puntos puntoDeDanioDirecto) {
		int daño = puntoDeDanioDirecto.obtener();
		this.vidaDelJugador-= daño;
	}

}