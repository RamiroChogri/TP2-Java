package campo;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import cartas.Carta;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import exceptions.NoHayLugarVacioException;

public class ZonaUtilidad {

	private LinkedList<CartaMagica> posiciones;
	private boolean hayEspacio;
	
	public ZonaUtilidad() {
		posiciones = new LinkedList<CartaMagica>();
		hayEspacio = true;
	}
	
	public void colocarCarta(CartaMagica cartaMonstruoAColocar) {
		hayEspacio = this.hayEspacioDisponible();
		try {
			if ( !hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			posiciones.add(cartaMonstruoAColocar);
		} catch (NoHayLugarVacioException noHay) {
		//	throw new ZonaMagicaLlenaException();
		}
	}
		
	public boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
	}
		
	public int obtenerCantidadDeCartas() {
		return this.posiciones.size();
	}

	public LinkedList<Carta> recolectarCartasDestruidas() {
		LinkedList<Carta>cartasDestruidas = new LinkedList<Carta>();
		Iterator<CartaMagica> posicionesIterador = this.posiciones.iterator();		
	    CartaMagica cartaMagicaActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMagicaActual = posicionesIterador.next();
	    	if(cartaMagicaActual.estaDestruida()) {
	    		Carta cartaActual = cartaMagicaActual;
	    		cartasDestruidas.add(cartaActual);
	    		posicionesIterador.remove();
	    	}
	    }
	    return cartasDestruidas;
	}

}
