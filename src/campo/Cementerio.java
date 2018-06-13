package campo;

import java.util.LinkedList;
import carta.Carta;

public class Cementerio {

	private LinkedList<Carta> cementerio;
	
	public Cementerio() {
		this.cementerio = new LinkedList<Carta>();
	}
	
	public void agregarCartaAlCementerio(Carta cartaDestruida) {
		this.cementerio.add(cartaDestruida);
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cementerio.size();
	}
}
