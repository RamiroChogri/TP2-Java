package campo;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Destruible;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import cartas.Colocable;
import exceptions.NoHayLugarVacioException;

public class Utilidades extends Zona{

	private LinkedList<CartaMagica> posiciones;
	private boolean hayEspacio;
	
	public Utilidades() {
		posiciones = new LinkedList<CartaMagica>();
		hayEspacio = true;
	}
	
	public void colocarCarta(Colocable cartaMonstruoAColocar) {
		//MetodoForzadoPorZona
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

	public LinkedList<Destruible> recolectarCartasDestruidas() {
		LinkedList<Destruible>cartasDestruidas = new LinkedList<Destruible>();
		Iterator<CartaMagica> posicionesIterador = this.posiciones.iterator();		
	    CartaMagica cartaMagicaActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaMagicaActual = posicionesIterador.next();
	    	if(cartaMagicaActual.estaDestruida()) {
	    		Destruible cartaActual = cartaMagicaActual;
	    		cartasDestruidas.add(cartaActual);
	    		posicionesIterador.remove();
	    	}
	    }
	    return cartasDestruidas;
	}
	
	public void vaciar() {
		Iterator<CartaMagica> posicionesIterador = this.posiciones.iterator();		
	    CartaMagica cartaActivableActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaActivableActual = posicionesIterador.next();
	    	cartaActivableActual.destruirCarta();
	    }
	}

}
