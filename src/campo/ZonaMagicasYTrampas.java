package campo;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.Destruible;
import cartas.Activable;
import cartas.Atacable;
import cartas.CartaMagica;
import cartas.CartaMonstruo;
import cartas.CartaTrampa;
import cartas.Colocable;
import exceptions.NoHayCartasTrampaException;
import exceptions.NoHayLugarVacioException;
import exceptions.NoHayCartasException;

public class ZonaMagicasYTrampas extends Zona{

	private LinkedList<Activable> posiciones;
	private boolean hayEspacio;
	
	public ZonaMagicasYTrampas() {
		posiciones = new LinkedList<Activable>();
		hayEspacio = true;
	}
	
	public void colocarCarta(Activable cartaAColocar) {
		hayEspacio = this.hayEspacioDisponible();
		try {
			if ( !hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			posiciones.add(cartaAColocar);
		} catch (NoHayLugarVacioException noHay) {
		//	throw new ZonaMagicaLlenaException();
		}
	}
		
	public boolean hayEspacioDisponible() {	
		return ( posiciones.size() < 5);
	}
		
	public int obtenerCantidadDeCartas() {
		return this.posiciones.size();
	}

	public LinkedList<Destruible> recolectarCartasDestruidas() {
		LinkedList<Destruible>cartasDestruidas = new LinkedList<Destruible>();
		Iterator<Activable> posicionesIterador = this.posiciones.iterator();		
		Activable cartaMagicaActual;
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
		Iterator<Activable> posicionesIterador = this.posiciones.iterator();		
		Colocable cartaActivableActual;
	    while (posicionesIterador.hasNext()) {
	    	cartaActivableActual = posicionesIterador.next();
	    	cartaActivableActual.destruirCarta();
	    }
	}

	public Activable obtenerCartaTrampa() {
		
		Iterator<Activable> posicionesIterador = this.posiciones.iterator();		
	    Activable carta = null;
	    boolean encontreCartaTrampa = false;
	   
	    while( posicionesIterador.hasNext() && !encontreCartaTrampa ) {
	    
	    	carta = posicionesIterador.next();
	    	
	    	if ( carta.esDeTrampa() ) {
	    
	    		encontreCartaTrampa = true;
	    	}
	    	
	    }	    
	    if( !encontreCartaTrampa ) { throw new NoHayCartasTrampaException(); };	    
		return carta;
		
	}

	@Override
	public void colocarCarta(Colocable cartaAColocar) {
		hayEspacio = this.hayEspacioDisponible();
		try {
			if ( !hayEspacio ) {
				throw new NoHayLugarVacioException();
			}
			posiciones.add((Activable) cartaAColocar);
		} catch (NoHayLugarVacioException noHay) {
		//	throw new ZonaMagicaLlenaException();
		}
	}

	public LinkedList<String> obtenerNombresDeCartasMagicas() {
		
		LinkedList<String> cartasMagicas = new LinkedList<String>();
		Activable cartaActual;
		
		Iterator<Activable> posicionesIterator = this.posiciones.iterator();
		while ( posicionesIterator.hasNext() ) {
			
			cartaActual = posicionesIterator.next();
			
			if(!cartaActual.esDeTrampa()) {
				cartasMagicas.add(cartaActual.obtenerNombre());
			}
		}
		
		return cartasMagicas;
	}

	
	public Activable obtenerCarta(String nombre) {
		Activable carta = null;
		boolean encontrado = false;
		Iterator<Activable> posicionesIterator = this.posiciones.iterator();
		Activable cartaActual;
	
		while( posicionesIterator.hasNext() && !encontrado ) {
	
			cartaActual = posicionesIterator.next();
	
			if( nombre.equals(cartaActual.obtenerNombre()) ) {
				carta = cartaActual;
				encontrado = true;
			}
		}
		if( !encontrado ) { throw new NoHayCartasException(); };
			return carta;
	}

	public LinkedList<Activable> obtenerCartasColocadas() {
		
		LinkedList<Activable> cartasColocadas = new LinkedList<Activable>();
		Activable cartaActual;
		Iterator<Activable> posicionesIterator = this.posiciones.iterator();
		
		while(posicionesIterator.hasNext()) {
			
			cartaActual = posicionesIterator.next();
			cartasColocadas.add(cartaActual);
		}
		
		return cartasColocadas;
	}
}
