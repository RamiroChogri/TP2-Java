package campo;
import java.util.*;
import carta.*;
import exceptions.NoHayLugarVacioException;
import exceptions.ZonaMonstruoLlenaException;

public class ZonaMonstruo {
	
	private LinkedList<CartaMonstruo> posiciones;
	private boolean hayEspacio;
	
	public ZonaMonstruo() {
		posiciones = new LinkedList<CartaMonstruo>();
		hayEspacio = true;
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
	
	public LinkedList<Carta> recolectarCartasDestruidas() {
		LinkedList<Carta>cartasDestruidas = new LinkedList<Carta>();
		Iterator<CartaMonstruo> posicionesIterador = this.posiciones.iterator();		
	    CartaMonstruo cartaMonstruoActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMonstruoActual = posicionesIterador.next();
	    	if(cartaMonstruoActual.estaDestruida()) {
	    		Carta cartaActual = cartaMonstruoActual;
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
}
