package jugador;

import campo.*;
import cartas.*;
import exceptions.*;
import modos.*;
import efectos.Efecto;
import estadoCarta.*;

public class Jugador implements Daniable{

		private Campo campoPropio;
		private Campo campoEnemigo;
		private Mano mano;
		private int vida;
	

	public Jugador() {
		
		this.mano = new Mano();
		this.campoPropio = new Campo(this);
		this.vida = 8000;
		for(int i=0;i<5;i++) {
			this.tomarCartaDelMazo();
		}
	}
	
	public Jugador(Campo campoDelJugador) {
		this.mano = new Mano();
		this.campoPropio = campoDelJugador;
		this.vida = 8000;
		for(int i=0;i<5;i++) {
			this.tomarCartaDelMazo();
		}
	}
	
	public void enfrentarseA(Jugador jugadorEnemigo) {
		
		jugadorEnemigo.setCampoEnemigo(this.campoPropio);
	}
	
	public void atacar(Atacable atacante, Atacable atacado) {
		
		atacante.atacar(atacado);
		
		this.campoPropio.enviarCartasDestruidasAlCementerio();
		this.campoEnemigo.enviarCartasDestruidasAlCementerio();
	}
	
	public void atacar(Atacable atacante, Jugador atacado) {

		atacante.atacar(atacado);
		
		this.campoPropio.enviarCartasDestruidasAlCementerio();
		this.campoEnemigo.enviarCartasDestruidasAlCementerio();
	}
	
	
	
	//Desde el jugador no vamos a colocar genericamente la carta, desde el jugador
	//vamos a colocar la carta de la manera que quiera el jugador y despues la colocacion
	//es generica en el campo.
	
//	public void colocarCartaEnCampo(CartaMonstruo carta) {
//		
//		campoPropio.colocarMonstruoEnModoAtaque( carta );
//	}
	
	public void setCampoEnemigo(Campo campo) {
		this.campoEnemigo = campo;
	}
	
	public int obtenerCantidadDeCartasEnLaMano() {
		
		return mano.obtenerCantidadDeCartas();
	}
	
	public void tomarCartaDelMazo() {
		mano.agregarCartaEnMano(campoPropio.levantarCartaDelMazo());
	}

	public int obtenerVidaRestante() {
		
		return this.vida;
	}
/*
	public void colocar (Atacable carta, EstadoCarta estado, Modo modo) {

		carta.cambiarA(modo);
			
		if ((carta.obtenerEstrellas() > 4) && (campoPropio.obtenerCantidadDeCartasEnZonaMonstruo() > 0)) {
				
			this.campoPropio.eliminarUltimaCartaMonstruoColocada();
				
			if ((carta.obtenerEstrellas() > 6) && (campoPropio.obtenerCantidadDeCartasEnZonaMonstruo() > 0 )) {
				
				this.campoPropio.eliminarUltimaCartaMonstruoColocada();
			
			} else if (carta.obtenerEstrellas() > 6 ){
			
				throw new NoHayMonstruoParaSacrificarException();
			 
			}
				
		} else if ((carta.obtenerEstrellas() > 4)) {
			
			throw new NoHayMonstruoParaSacrificarException();
			
		}
		campoPropio.colocarCarta(carta, estado);
	}
*/	
	public void colocar(Atacable carta, EstadoCarta estado, Modo modo) {
		carta.cambiarA(modo);
		campoPropio.colocarCarta(carta, estado);
		campoPropio.enviarCartasDestruidasAlCementerio();
		
	}
	
	public void colocar(Activable carta, EstadoCarta estado) {
		campoPropio.colocarCarta(carta, estado);
		
	}
	
	public void aplicarEfectoCarta(Activable carta) {
		carta.aplicarEfecto(this.campoPropio, this.campoEnemigo);
	}
	
	public boolean tieneCartasEnCampo() {
		
		return this.campoPropio.tieneCartas();
	}

	public int obtenerCantidadCartasEnCampo() {
		
		return campoPropio.obtenerCantidadDeCartasEnJuego();
	}
	
	public int obtenerCantidadCartasEnZonaMonstruos() {
		return campoPropio.obtenerCantidadDeCartasEnZonaMonstruos();
	}
	
	public int obtenerCantidadDeCartasEnZonaMagicasYTrampas() {
		return campoPropio.obtenerCantidadDeCartasEnZonaMagicasYTrampas();
	}
	
	public int obtenerCantidadDeCartasEnCementerio() {
		return campoPropio.obtenerCantidadDeCartasEnCementerio();
	}
	
	public void enviarCartasDestruidasAlCementerio() {
		campoPropio.enviarCartasDestruidasAlCementerio();
	}

	public void recibirAtaque(Atacable cartaAtacante) {
		
		if (campoPropio.obtenerCantidadDeCartasEnZonaMonstruos() > 0) {
			throw new NoSePuedeAtacarAlJugadorDirectamenteException();
		}
		
		Puntos puntosDeDanioRecibidos = cartaAtacante.obtenerPuntosAtaque();
		this.recibirAtaque( puntosDeDanioRecibidos.obtenerPuntosActuales() );
	}
	
	public void recibirAtaque(int danioRecibido) {
		this.vida -= danioRecibido;
	}
/*
	public void atacar(Atacable cartaAtacable) {
		//Forzado
	}

	public void atacar(Daniable jugador) {
		//Forzado
	}
 */
}