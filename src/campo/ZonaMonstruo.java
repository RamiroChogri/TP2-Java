package campo;
import java.util.*;
import carta.*;
import exceptions.NoHayLugarVacioException;
import exceptions.ZonaMonstruoLlenaException;
import fiuba.algo3.tp1.Servicio;

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
			
				
		} catch (Exception NoHayLugarVacioException) {
			//throw new ZonaMonstruoLlenaException();
		}
		
		
	}
	
	public boolean hayEspacioDisponible() {	
		return (posiciones.size() < 5);
	}

	public int obtenerCantidadDeCartas() {
		return (this.posiciones.size());
	}
	
	public Collection<Carta> recolectarCartasDestruidas() {
		LinkedList<Carta>cartasDestruidas = new LinkedList<Carta>();
		LinkedList<Carta>cartasEnCampo = this.posiciones;
		Iterator<Carta> posicionesIterador = this.posiciones.iterator();		
	    Servicio servicioActual;
	    double costoTotal=costoActual;
	    while (serviciosIterador.hasNext()) {
	    	servicioActual = serviciosIterador.next();
	    	costoTotal = servicioActual.agregarCostoEnVuelos(costoActual);
	    	costoActual=costoTotal;
	    }
	    return costoTotal;
	}
}
