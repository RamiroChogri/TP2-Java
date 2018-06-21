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
		
		String nombreCabeza = "Cabeza de Exodia";
		String nombreBrazoIzquierdo = "Brazo izquierdo de Exodia";
		String nombreBrazoDerecho = "Brazo derecho de Exodia";
		String nombrePiernaIzquierda = "Pierna izquierda de Exodia";
		String nombrePiernaDerecha = "Pierna derecha de Exodia";
		
		boolean tieneCabeza = false;
		boolean tieneBrazoIzquierdo = false;
		boolean tieneBrazoDerecho = false;
		boolean tienePiernaIzquierda = false;
		boolean tienePiernaDerecha = false;
		
		String nombreCartaActual;
		Colocable cartaActual = null;
		
		Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
		while(posicionesIterador.hasNext()) {
			cartaActual = posicionesIterador.next();
			nombreCartaActual = cartaActual.obtenerNombre();
			if (nombreCartaActual == nombreCabeza) {
				tieneCabeza = true;
			}
			if (nombreCartaActual == nombreBrazoIzquierdo) {
				tieneBrazoIzquierdo = true;
			}
			if (nombreCartaActual == nombreBrazoDerecho) {
				tieneBrazoDerecho = true;
			}
			if (nombreCartaActual == nombrePiernaIzquierda) {
				tienePiernaIzquierda = true;
			}
			if (nombreCartaActual == nombrePiernaDerecha) {
				tienePiernaDerecha = true;
			}
		}
		
		if (tieneCabeza && tieneBrazoIzquierdo && tieneBrazoDerecho && tienePiernaIzquierda && tienePiernaDerecha) {
			tieneAExodia = true;
		}
		
		return tieneAExodia;
	}

}
