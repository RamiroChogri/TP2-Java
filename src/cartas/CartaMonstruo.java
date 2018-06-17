package cartas;

import estadoCarta.*;
import estrategias.*;
import modos.*;

public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	private int estrellas;
	private String nombre;
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaEnMazo(); 
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
		
	}
	
	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar) {
		this.estado = new EstadoCartaEnMazo();
		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
	}
	
	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar, int estrellasAColocar) {
		this.estado = new EstadoCartaEnMazo();
		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
	}
	 
	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar, int estrellasAColocar, String nombreAColocar) {
		this.estado = new EstadoCartaEnMazo();
		this.puntosDeAtaque = new Puntos(puntosDeAtaqueAColocar);
		this.puntosDeDefensa = new Puntos(puntosDeDefensaAColocar);
		this.estrellas = estrellasAColocar;
		this.nombre = nombreAColocar;
	}
	
	//Deberia comprobarse en campo si la carta que ataca esta en modo ataque.
	
	public void atacar(Atacable cartaAtacableEnemiga) {
		cartaAtacableEnemiga.recibirAtaque(this, this.puntosDeAtaque.obtener());
	}
	
	
	public void atacar(CartaMonstruo otraCartaMonstruo) {
		
		if (otraCartaMonstruo.estaColocadaBocaAbajoEnModoDefensa()) {
			otraCartaMonstruo.colocarBocaArribaEnModoDefensa();
		}
		
		otraCartaMonstruo.recibirAtaque(this, this.puntosDeAtaque.obtener());
		
	}
	
	public void recibirAtaque(CartaMonstruo cartaEnemiga, int puntosDeAtaqueMonstruoEnemigo) {
		
		int danioAlJugador = 0;
		
		danioAlJugador = this.estado.recibirAtaque(puntosDeAtaqueMonstruoEnemigo);
		
		if (this.estado.estaEnModoAtaque() && (danioAlJugador <= 0)) {
			cartaEnemiga.destruirCarta(Math.abs(danioAlJugador));	
		}
		
		if ((danioAlJugador >= 0) && ((this.puntosDeDefensa.obtener() < puntosDeAtaqueMonstruoEnemigo) || (this.estado.estaEnModoAtaque()))) {
			this.destruirCarta(danioAlJugador);
		}
		
	}
	
	/////////////////////////////
	
	public void colocar(Estrategia boca, Modo modo) {
		
		modo.asignarPuntosAtaque(this.puntosDeAtaque);
		modo.asignarPuntosDefensa(this.puntosDeDefensa);
		
		this.estado = new EstadoCartaInvocada(boca, modo);
	
	}
	
	////////////////////////////
	
	public void colocarEnModoAtaque() {
		this.estado = new EstadoCartaEnModoAtaque(this.puntosDeAtaque.obtener());
	}
	
	public void colocarBocaArribaEnModoDefensa() {
		this.estado = new EstadoCartaBocaArribaEnModoDefensa();
	}
	
	public void colocarBocaAbajoEnModoDefensa() {
		this.estado = new EstadoCartaBocaAbajoEnModoDefensa();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (this.estado.estaEnModoAtaque());
	}
	
	public boolean estaColocadaBocaArribaEnModoDefensa() {
		return ( this.estado.estaBocaArribaEnModoDefensa() );
	}
	
	public boolean estaColocadaBocaAbajoEnModoDefensa() {
		return (this.estado.estaBocaAbajoEnModoDefensa() );
	}

	public boolean estaDestruida() {
		return this.estado.estaEnCementerio();
	}
	
	public void destruirCarta() {
		this.estado = new EstadoCartaEnCementerio();
	}
	
	public void destruirCarta(int danioAlJugador) {
		this.estado = new EstadoCartaEnCementerio(danioAlJugador);
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
 	
}