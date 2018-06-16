package jugador;

import campo.*;
import cartas.*;
import exceptions.*;
import efectos.Efecto;
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
	
	public void atacar(CartaMonstruo atacante, CartaMonstruo atacado) {
		
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
		
		carta.colocarEnModoAtaque();
		this.campoPropio.colocarCarta(carta);

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
		
		carta.colocarBocaArribaEnModoDefensa();
		this.campoPropio.colocarCarta(carta);
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
		
		carta.colocarBocaAbajoEnModoDefensa();
		this.campoPropio.colocarCarta(carta);

	}

	public void colocarCartaMagicaBocaArriba(CartaMagica carta) {
		
		this.campoPropio.colocarCarta(carta);
		carta.aplicarEfecto( this.campoPropio, this.campoEnemigo);
		
	}
	
	public void colocarCartaMagicaBocaAbajo(CartaMagica carta) {
		
		this.campoPropio.colocarCarta(carta);
		
	}

	public void colocarCartaTrampaBocaArriba(CartaTrampa carta) {
		
		carta.colocarBocaArriba();
		this.campoPropio.colocarCarta(carta);
		carta.aplicarEfecto( this.campoPropio, this.campoEnemigo);
		
	}
	
	public void colocarCartaTrampaBocaAbajo(CartaTrampa carta) {
		
		carta.colocarBocaAbajo();
		this.campoPropio.colocarCarta(carta);
		
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
