package cartas;

import estadoCarta.*;
import estrategias.*;
import exceptions.MonstruoEnModoDefensaNoPuedeAtacarException;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.ZonaMonstruoLlenaException;
import modos.*;
import InvocacionStrategy.*;
import campo.*;

public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private Modo modo;
	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	private int estrellas;
	private String nombre;
	private ReglaDeInvocacionStrategy regla;
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaNoJugada(); 
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
		this.regla = new ReglaDeMonstruoChicoStrategy();
		
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
		this.modo = new ModoAtaque();
		this.regla = new ReglaDeMonstruoChicoStrategy();
	}
	
	///////constructor que recibe la regla para colocarse ////////
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar,
				int estrellasAColocar, ReglaDeInvocacionStrategy reglaDeInvocacion) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
		this.estado = new EstadoCartaNoJugada();
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
		this.modo = new ModoAtaque();
		this.regla = reglaDeInvocacion;	
	}
	
	public void setNombre(String nombreDeLaCarta) {
		
		this.nombre = nombreDeLaCarta;
	}
	
	
	public void cambiarA(Modo modoRecibido) {
		this.modo = modoRecibido;
	}
		
	public void colocarse(ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		regla.colocarCarta( zonaMonstruos, this);
	}
	
	
	////////////////////////////
	
	
	//Deberia comprobarse en campo si la carta que ataca esta en modo ataque.
	
	public void atacar(Atacable cartaAtacableEnemiga) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		
		cartaAtacableEnemiga.recibirAtaque(this);
	}
	

	/////////
	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante) {
	
		this.modo.recibirAtaque(cartaAtacante, this);
	}
	
	/////////
	
	
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

	public boolean estaColocadaBocaAbajo() {
		return this.estado.estaBocaAbajo();
	}
	public boolean estaColocadaBocaArriba() {
		return this.estado.estaBocaArriba();
	}
	
	public boolean estaEnModoAtaque() {
		return this.modo.estaEnModoAtaque();
	}
	
	public boolean estaEnModoDefensa() {
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



	public Puntos obtenerPuntosAtaque() {
		
		return this.puntosDeAtaque;
	}


	public Puntos obtenerPuntosDefensa() {
	
		return this.puntosDeDefensa;
	}

	
 	
}