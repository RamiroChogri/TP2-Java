package jugador;

import campo.*;
import cartas.*;
import exceptions.*;
import modos.*;
import efectos.Efecto;
import estadoCarta.*;
public class Jugador {

		private Campo campoPropio;
		private Campo campoEnemigo;
		private Mano mano;
	

	public Jugador() {
		
		this.campoPropio = new Campo();
		this.mano = new Mano();	
	}
	
	public void enfrentarseA(Jugador jugadorEnemigo) {
		
		jugadorEnemigo.setCampoEnemigo(this.campoPropio);
	}
	
	public void atacar(Atacable atacante, Atacable atacado) {
		
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

	public Object obtenerVidaRestante() {
		
		return campoPropio.obtenerVidaRestante();
	}

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
	public void colocarMonstruo (Atacable carta, EstadoCarta estado, Modo modo) {
		campoPropio.colocarCarta(carta, estado);
		carta.cambiarA(modo);
	}
	
	public void colocar(Activable carta, EstadoCarta estado) {
		campoPropio.colocarCarta(carta, estado);
		
	}
	
	public void colocarMonstruoEnModoAtaque(CartaMonstruo carta) {
		
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
		EstadoCarta nuevoEstado = new EstadoCartaColocadaBocaArriba();
		Modo nuevoModo = new ModoAtaque();
		carta.cambiarA(nuevoModo);
		
		Colocable cartaAColocar = carta;
		this.campoPropio.colocarCarta(cartaAColocar, nuevoEstado);

	}
	
	public void colocarMonstruoBocaArribaEnModoDefensa(CartaMonstruo carta) {
				
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
		
		EstadoCarta nuevoEstado = new EstadoCartaColocadaBocaArriba();
		Modo nuevoModo = new ModoDefensa();
		carta.cambiarA(nuevoModo);
		
		Colocable cartaAColocar = carta;
		this.campoPropio.colocarCarta(cartaAColocar, nuevoEstado);
	}
	
	public void colocarMonstruoBocaAbajoEnModoDefensa(CartaMonstruo carta) {
		
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
		
		
		EstadoCarta nuevoEstado = new EstadoCartaColocadaBocaAbajo();
		Modo nuevoModo = new ModoDefensa();
		carta.cambiarA(nuevoModo);
		
		Colocable cartaAColocar = carta;
		this.campoPropio.colocarCarta(cartaAColocar, nuevoEstado);

	}

	public void colocarCartaMagicaBocaArriba(CartaMagica carta) {
		
		EstadoCarta nuevoEstado = new EstadoCartaColocadaBocaArriba();
		Colocable cartaAColocar = carta;
		
		this.campoPropio.colocarCarta(cartaAColocar , nuevoEstado );
		carta.aplicarEfecto( this.campoPropio, this.campoEnemigo);
		
	}
	
	public void colocarCartaMagicaBocaAbajo(CartaMagica carta) {
		EstadoCarta nuevoEstado= new EstadoCartaColocadaBocaAbajo();
		Colocable cartaAColocar = carta;
		
		this.campoPropio.colocarCarta(cartaAColocar, nuevoEstado);
	}

	public void colocarCartaTrampaBocaAbajo(CartaTrampa carta) {
		
		EstadoCarta nuevoEstado = new EstadoCartaColocadaBocaAbajo();
		Colocable cartaAColocar = carta;
		
		this.campoPropio.colocarCarta(cartaAColocar , nuevoEstado);
		carta.aplicarEfecto( this.campoPropio, this.campoEnemigo);	
	}
	

	//No funciona con metodo generico que recibe cualquier tipo de carta
//
//	private void colocarCarta (Carta carta) {
//		this.campoPropio.colocarCarta(carta);
//	}
//	
	public boolean tieneCartasEnCampo() {
		
		return this.campoPropio.tieneCartas();
	}

	public int obtenerCantidadCartasEnCampo() {
	
		return campoPropio.obtenerCantidadDeCartasEnJuego();
	}
	
 
}
