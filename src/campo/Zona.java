package campo;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Destruible;
import exceptions.NoHayLugarVacioException;

public abstract class Zona {

	protected LinkedList<Destruible> posiciones;
	protected boolean hayEspacio;
	
	protected Zona() {
		posiciones = new LinkedList<Destruible>();
		hayEspacio = true;
	}
	
	protected void colocarCarta(Destruible cartaMonstruoAColocar) {
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
	
	protected boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
	}

	protected int obtenerCantidadDeCartas() {
		return (this.posiciones.size());
	}
	
	protected LinkedList<Destruible> recolectarCartasDestruidas() {
		LinkedList<Destruible>cartasDestruidas = new LinkedList<Destruible>();
		Iterator<Destruible> posicionesIterador = this.posiciones.iterator();		
	    Destruible cartaActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaActual = posicionesIterador.next();
	    	if(cartaActual.estaDestruida()) {
	    		cartasDestruidas.add(cartaActual);
	    		posicionesIterador.remove();
	    	
	    	}
	    }
	    return cartasDestruidas;
	}

	protected void vaciar() {
		Iterator<Destruible> posicionesIterador = this.posiciones.iterator();		
	   Destruible cartaActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaActual = posicionesIterador.next();
	    	cartaActual.destruirCarta();
	    }
	}
}
