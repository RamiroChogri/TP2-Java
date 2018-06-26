package jugador;

import java.util.Iterator;
import java.util.LinkedList;

import cartas.*;

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
	
	public Colocable obtenerCarta(String nombreCartaActivable) {
		Colocable cartaActual = null;
		Colocable cartaADevolver = null;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			if (cartaActual.obtenerNombre() == nombreCartaActivable) {
				cartaADevolver = cartaActual;
			}
		}
		return cartaADevolver;
	}
	
	
	public LinkedList<String> obtenerNombresDeCartasAtacables() {
		LinkedList<String> listaADevolver = new LinkedList<String>();
		//COMO CARAJO DISTINGO ENTRE ACTIVABLES Y ATACABLES EN LISTA DE COLOCABLES?
		
		return listaADevolver;
	}
	
	public LinkedList<String> obtenerNombresDeCartasActivables() {
		LinkedList<String> listaADevolver = new LinkedList<String>();
		
		
		return listaADevolver;
	}
}
