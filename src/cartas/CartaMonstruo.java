package cartas;

import estadoCarta.*;
import estrategias.*;
import exceptions.MonstruoEnModoDefensaNoPuedeAtacarException;
import exceptions.NoHayEspacioEnElCampoException;
import exceptions.ZonaMonstruoLlenaException;
import invocacionStrategy.*;
import jugador.Jugador;
import modos.*;

import java.util.LinkedList;

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
	//Constructor que recibe todo lo anterior + el nombre
	public CartaMonstruo(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar,
			int estrellasAColocar, ReglaDeInvocacionStrategy reglaDeInvocacion, String nombreAColocar) {
	this.puntosDeAtaque = puntosDeAtaqueAColocar;
	this.puntosDeDefensa = puntosDeDefensaAColocar;
	this.estado = new EstadoCartaNoJugada();
	this.estrellas = estrellasAColocar;
	this.nombre = nombreAColocar;
	this.modo = new ModoAtaque();
	this.regla = reglaDeInvocacion;	
	
	}
	
	public void setNombre(String nombreDeLaCarta) {
		
		this.nombre = nombreDeLaCarta;
	}
	
	public void ponerEn(EstadoCarta estadoRecibido) {
		this.estado = estadoRecibido;
	}
	
	public void cambiarA(Modo modoRecibido) {
		this.modo = modoRecibido;
	}
		
	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		monstruosSacrificados = regla.colocarCarta( zonaMonstruos, this);
		
		 cementerio.agregarCartas(monstruosSacrificados);
	}
	
	
	public void atacar(Atacable cartaAtacableEnemiga) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		
		cartaAtacableEnemiga.recibirAtaque(this);
	}
	
	public void atacar(Jugador jugador) {
		if (this.estaEnModoDefensa()) {
			throw new MonstruoEnModoDefensaNoPuedeAtacarException();
		}
		
		jugador.recibirAtaque(this);
	}

	public void recibirAtaque(Atacable cartaAtacante) {
	
		if (estaColocadaBocaAbajo()) {
			this.estado = new EstadoCartaColocadaBocaArriba();
		}
		this.modo.recibirAtaque(cartaAtacante, this);
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
	
	public void eliminarModificadorDeAtaque() {
		this.puntosDeAtaque.eliminarModificadores();
	}
	
	public void eliminarModificadorDeDefensa() {
		this.puntosDeDefensa.eliminarModificadores();
	}
	
	public void aumentarAtaqueEn(Puntos puntosDeAtaqueExtra) {
		this.puntosDeAtaque.aumentar(puntosDeAtaqueExtra);
	}
	
	public void aumentarDefensaEn(Puntos puntosDeDefensaExtra) {
		this.puntosDeDefensa.aumentar(puntosDeDefensaExtra);
	}

	public boolean tieneMasPuntosDeAtaqueQue(Atacable carta) {
		
		return puntosDeAtaque.sonMayoresA(carta.obtenerPuntosAtaque());
	}

	public int diferenciaDeAtaqueCon(Atacable carta) {
		
		return puntosDeAtaque.obtenerDiferenciaCon(carta.obtenerPuntosAtaque());
	}

	public Modo obtenerModo() {

		return this.modo;
	}
 	
}