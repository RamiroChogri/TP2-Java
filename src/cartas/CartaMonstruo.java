package cartas;

import estadoCarta.*;
import estrategias.*;
import exceptions.MonstruoEnModoDefensaNoPuedeAtacarException;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.ZonaMonstruoLlenaException;
import modos.*;
import campo.*;

public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private Modo modo;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	private int estrellas;
	private String nombre;
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaNoJugada(); 
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
		
	}
	
//	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar) {
//		this.estado = new EstadoCartaEnMazo();
//		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
//		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
//		this.estrellas = 3;
//		this.nombre = "MonstruoGenericoACME";
//	}
//	
//	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar, int estrellasAColocar) {
//		this.estado = new EstadoCartaEnMazo();
//		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
//		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
//		this.estrellas = estrellasAColocar;
//		this.nombre = "MonstruoGenericoACME";
//	}
//	 
//	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar, int estrellasAColocar, String nombreAColocar) {
//		this.estado = new EstadoCartaEnMazo();
//		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
//		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
//		this.estrellas = estrellasAColocar;
//		this.nombre = nombreAColocar;
//	}
//	
	
	////////////////////////////
	
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar, int estrellasAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
		this.estado = new EstadoCartaNoJugada();
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
		this.modo = new ModoAtaque(puntosDeAtaque, puntosDeDefensa);
	}
	
	public void cambiarA(Modo modoRecibido) {
		modoRecibido.asignarPuntos(this.puntosDeAtaque, this.puntosDeDefensa);
		this.modo = modoRecibido;
	}
		
	public void colocarse(ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		zonaMonstruos.colocarCarta(this);
	}
	
	
	////////////////////////////
	
	
	//Deberia comprobarse en campo si la carta que ataca esta en modo ataque.
	
	public void atacar(Atacable cartaAtacableEnemiga) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		
		cartaAtacableEnemiga.recibirAtaque(this, this.puntosDeAtaque);
	}
	
	
	public void atacar(CartaMonstruo otraCartaMonstruo) {
		
		if (otraCartaMonstruo.estaColocadaBocaAbajo() && otraCartaMonstruo.estaEnModoDefensa()) {
			otraCartaMonstruo.colocarBocaArribaEnModoDefensa();
		}
		
		otraCartaMonstruo.recibirAtaque(this, this.puntosDeAtaque);
		
	}
	
	/////////
	
	public void recibirAtaque(CartaMonstruo cartaAtacante, Puntos puntosDeAtaqueMonstruoAtacante) {
	
		this.modo.recibirAtaque(cartaAtacante, puntosDeAtaqueMonstruoAtacante, this);
	}
	
	/////////
	
	public void recibirAtaque(CartaMonstruo cartaEnemiga, int puntosDeAtaqueMonstruoEnemigo) {
		
		int danioAlJugador = 0;
		
		danioAlJugador = this.estado.recibirAtaque(puntosDeAtaqueMonstruoEnemigo);
		
		if (this.modo.estaEnModoAtaque() && (danioAlJugador <= 0)) {
			cartaEnemiga.destruirCarta(Math.abs(danioAlJugador));	
		}
		
		if ((danioAlJugador >= 0) && ((this.puntosDeDefensa.obtener() < puntosDeAtaqueMonstruoEnemigo) || (this.modo.estaEnModoAtaque()))) {
			this.destruirCarta(danioAlJugador);
		}
		
	}
	
	public void colocarEnModoAtaque() {
		this.estado = new EstadoCartaColocadaBocaArriba();
		this.modo = this.modo.colocarEnModoAtaque();
	}
	
	public void colocarBocaArribaEnModoDefensa() {
		this.estado = new EstadoCartaColocadaBocaArriba();
		this.modo = this.modo.colocarEnModoDefensa();
	}
	
	public void colocarBocaAbajoEnModoDefensa() {
		this.estado = new EstadoCartaColocadaBocaAbajo();
		this.modo = this.modo.colocarEnModoDefensa();
	}
	
//	public boolean estaColocadaEnModoAtaque() {
//		return (this.modo.estaEnModoAtaque());
//	}
//	
//	public boolean estaColocadaBocaArribaEnModoDefensa() {
//		return ( this.estado.estaBocaArriba() && this.modo.estaEnModoDefensa() );
//	}
//	
//	public boolean estaColocadaBocaAbajoEnModoDefensa() {
//		return (this.estado.estaBocaAbajo() && this.modo.estaEnModoDefensa());
//	}

	public Boolean estaColocadaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}
	public Boolean estaColocadaBocaArriba() {
		return this.estado.estaBocaArriba();
	}
	
	public Boolean estaEnModoAtaque() {
		return this.modo.estaEnModoAtaque();
	}
	
	public Boolean estaEnModoDefensa() {
		return this.modo.estaEnModoDefensa();
	}
	
	public boolean estaDestruida() {
		return this.estado.estaDestruida();
	}
	
	public void destruirCarta() {
		this.estado = new EstadoCartaDestruida();
	}
	
	public void destruirCarta(int danioAlJugador) {
		this.estado = new EstadoCartaDestruida(danioAlJugador);
	}
	
	public int obtenerEstrellas() {
		return this.estrellas;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}

	public int obtenerDanioAlHaberSidoDestruida() {
		return estado.obtenerPuntosDeDanio();
	}

	@Override
	public void recibirAtaque(Atacable atacable, int puntosAtaqueAtacable) {
		// TODO Auto-generated method stub
		
	}
 	
}