package jugador;

import java.util.LinkedList;

import cartas.*;

public class Mano {
	
	private LinkedList<Carta> cartasEnMano;
	
	public Mano() {
		
		this.cartasEnMano = new LinkedList<Carta>() ;
		
	}
	public void agregarCartaEnMano(Carta carta) {
		this.cartasEnMano.add(carta);
	}
	
	public void agregarCartasEnMano(LinkedList<Carta> cartas) {
		this.cartasEnMano.addAll( cartas );
	}

	public int obtenerCantidadDeCartas() {
		
		return this.cartasEnMano.size();
	}

}
