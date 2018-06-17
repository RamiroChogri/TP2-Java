package campo;
import java.util.*;

import cartas.*;
import exceptions.NoHayLugarVacioException;
import exceptions.ZonaMonstruoLlenaException;

public class Criaturas extends Zona {
	
	private LinkedList<CartaMonstruo> posiciones;
	private boolean hayEspacio;
	
	public Criaturas() {
		posiciones = new LinkedList<CartaMonstruo>();
		hayEspacio = true;
	}
	
	public void colocarCarta(Destruible cartaMonstruoAColocar) {
		//MetodoForzadoPorZona
	}
	
	public void colocarCarta(CartaMonstruo cartaMonstruoAColocar) {
		hayEspacio = this.hayEspacioDisponible();
		try {
			if ( !hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			
			posiciones.add(cartaMonstruoAColocar);
			
				
		} catch (Exception NoHayLugarVacioException) {
			//throw new ZonaMonstruoLlenaException();
		}
		
		
	}
	
	public boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
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
			posiciones.getLast().destruirCarta();;
		} catch (NoSuchElementException noHayMonstruoParaBorrar) {
			//No se elimina nada
		}
	}
}
