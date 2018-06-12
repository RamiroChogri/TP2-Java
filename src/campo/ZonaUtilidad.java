package campo;

import java.util.LinkedList;

import carta.CartaMagica;

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
			throw new ZonaMagicaLlenaException();
		}
	}
		
	public boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
	}
		
	public int obtenerCantidadDeCartas() {
		return this.posiciones.size();
	}

}
