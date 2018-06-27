package jugador;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.*;
import exceptions.CartaNoEncontradaException;

public class Mano {
	
	private LinkedList<Colocable> cartasEnMano;
	
	public Mano() {
		
		this.cartasEnMano = new LinkedList<Colocable>() ;
		
	}
	public void agregarCartaEnMano(Colocable carta) {
		this.cartasEnMano.add(carta);
	}
	
	public void agregarCartasEnMano(LinkedList<Colocable> cartas) {
		this.cartasEnMano.addAll( cartas );
	}

	public int obtenerCantidadDeCartas() {
		
		return this.cartasEnMano.size();
	}
	
	public boolean tieneAExodia() {
		boolean tieneAExodia = false;
		
		String exodia = "Exodia";
		int cantidadCartasExodiaEnMano = 0;
		Colocable cartaActual = null;
		String nombreCartaActual;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			nombreCartaActual = cartaActual.obtenerNombre();
			if (nombreCartaActual.contains(exodia)) {
				cantidadCartasExodiaEnMano++;
			}
		}
		
		tieneAExodia = (cantidadCartasExodiaEnMano == 5);
		return tieneAExodia;
	}

	////////////////////////////////////
	
	public Colocable obtenerCarta(String nombreCartaColocable) {
		Colocable cartaActual = null;
		String nombreCartaActual;
		Colocable cartaADevolver = null;
		boolean encontrado = false;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext() && !encontrado) {
			cartaActual = posicionesIterador.next();
			nombreCartaActual = cartaActual.obtenerNombre();
			if (nombreCartaActual.equals(nombreCartaColocable)) {
				cartaADevolver = cartaActual;
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			throw new CartaNoEncontradaException();	//No existe una carta con el nombre recibido
		}
		
		return cartaADevolver;
	}
	
	
	public LinkedList<String> obtenerNombresDeCartasAtacables() {
		LinkedList<String> listaADevolver = new LinkedList<String>();
		Colocable cartaActual = null;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			if (cartaActual.esAtacable()) {
				listaADevolver.add(cartaActual.obtenerNombre());
			}
		}
		
		return listaADevolver;
	}
	
	public LinkedList<String> obtenerNombresDeCartasActivables() {
		LinkedList<String> listaADevolver = new LinkedList<String>();
		Colocable cartaActual = null;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			if (cartaActual.esActivable()) {
				System.out.println("Encontre una carta Activable");
				listaADevolver.add(cartaActual.obtenerNombre());
			}
		}
	
		return listaADevolver;
	}

	public void eliminarCarta(String nombreCartaElegida) {
		
		Colocable cartaActual = null;
		String nombreCartaActual;
		boolean encontrado = false;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext() && !encontrado) {
			cartaActual = posicionesIterador.next();
			nombreCartaActual = cartaActual.obtenerNombre();
			if (nombreCartaActual.equals(nombreCartaElegida)) {
				this.cartasEnMano.remove(cartaActual);
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			throw new CartaNoEncontradaException();	//No existe una carta con el nombre recibido
		}
		
	}
	
}
