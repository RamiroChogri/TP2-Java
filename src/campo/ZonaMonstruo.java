package campo;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import carta.*;

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
			
				
		} catch (NoHayLugarVacioException noHay) {
			throw new ZonaMonstruoLlenaException();
		}
		
		
	}
	
	public boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
	}

	public int obtenerCantidadDeCartas() {
		return (this.posiciones.size());
	}
}
