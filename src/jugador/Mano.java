package jugador;

import java.util.LinkedList;

import cartas.*;

public class Mano {
	
	private LinkedList<Destruible> cartasEnMano;
	
	public Mano() {
		
		this.cartasEnMano = new LinkedList<Destruible>() ;
		
	}
	public void agregarCartaEnMano(Destruible carta) {
		this.cartasEnMano.add(carta);
	}
	
	public void agregarCartasEnMano(LinkedList<Destruible> cartas) {
		this.cartasEnMano.addAll( cartas );
	}

	public int obtenerCantidadDeCartas() {
		
		return this.cartasEnMano.size();
	}

}
