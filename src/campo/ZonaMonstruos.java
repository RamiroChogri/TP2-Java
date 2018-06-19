package campo;
import java.util.*;

import cartas.*;
import exceptions.NoHayLugarVacioException;
import exceptions.ZonaMonstruoLlenaException;

public class ZonaMonstruos extends Zona {
	
	private LinkedList<CartaMonstruo> posiciones;
	private boolean hayEspacio;
	private Puntos puntosDeAtaqueExtra;
	private Puntos puntosDeDefensaExtra;
	
	public ZonaMonstruos() {
		this.posiciones = new LinkedList<CartaMonstruo>();
		this.hayEspacio = true;
		this.puntosDeAtaqueExtra = new Puntos(0);
		this.puntosDeDefensaExtra = new Puntos(0);
	}
	
	public void colocarCarta(Colocable cartaMonstruoAColocar) {
		//MetodoForzadoPorZona
	}
	
	public void colocarCarta(CartaMonstruo cartaMonstruoAColocar) {
		this.hayEspacio = this.hayEspacioDisponible();
			if ( !this.hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			cartaMonstruoAColocar.aumentarAtaqueEn(this.puntosDeAtaqueExtra);
			cartaMonstruoAColocar.aumentarDefensaEn(this.puntosDeDefensaExtra);
			this.posiciones.add(cartaMonstruoAColocar);
		
	}
	
	public boolean hayEspacioDisponible() {	
		return (this.posiciones.size() < 5);
	}

	public int obtenerCantidadDeCartas() {
		return (this.posiciones.size());
	}
	
	public LinkedList<Destruible> recolectarCartasDestruidas() {
		LinkedList<Destruible>cartasDestruidas = new LinkedList<Destruible>();
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	if(cartaMonstruoActual.estaDestruida()) {
	    	
	    		Destruible cartaActual = cartaMonstruoActual;
	    		cartasDestruidas.add(cartaActual);
	    		posicionesIterador.remove();
	    	
	    	}
	    }
	    return cartasDestruidas;
	}

	public void vaciar() {
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.destruirCarta();
	    }
	}

	public int obtenerDanioRecibido() {
		int danio = 0;
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	danio += cartaMonstruoActual.obtenerDanioAlHaberSidoDestruida(); 
	    	
	    }
	    
		return danio;
	}
	
	public void eliminarUltimaCartaMonstruoColocada() {
		try {
			posiciones.getLast().destruirCarta();
		} catch (NoSuchElementException noHayMonstruoParaBorrar) {
			//No se elimina nada
		}
	}

	public boolean tieneMonstruosColocados(int cantidadDeMonstruosBuscados) {
		
		return ( posiciones.size() >= cantidadDeMonstruosBuscados );
	}
	
	public void aumentarAtaqueMonstruoPorEfectoCampo(Puntos puntosAtaqueAColocar) {
		this.puntosDeAtaqueExtra = puntosAtaqueAColocar;
		this.puntosDeDefensaExtra = new Puntos(0);
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.eliminarModificadorDeAtaque();
	    	cartaMonstruoActual.eliminarModificadorDeDefensa();
	    	cartaMonstruoActual.aumentarAtaqueEn(this.puntosDeAtaqueExtra);
	    }
	}
	
	public void aumentarDefensaMonstruoPorEfectoCampo(Puntos puntosDefensaAColocar) {
		this.puntosDeAtaqueExtra = new Puntos(0);
		this.puntosDeDefensaExtra = puntosDefensaAColocar;
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	cartaMonstruoActual.eliminarModificadorDeAtaque();
	    	cartaMonstruoActual.eliminarModificadorDeDefensa();
	    	cartaMonstruoActual.aumentarDefensaEn(this.puntosDeDefensaExtra);
	    }
	}
	
	
}
