package campo;

import java.util.LinkedList;

import cartas.Carta;

public class Cementerio {

	private LinkedList<Carta> cementerio;
	
	public Cementerio() {
		this.cementerio = new LinkedList<Carta>();
	}
	
	public void agregarCartaAlCementerio(Carta cartaDestruida) {
		this.cementerio.add(cartaDestruida);
	}
	
	public void agregarCartasAlCementerio(LinkedList<Carta> cartasAEnterrar) {
		this.cementerio.addAll(cartasAEnterrar);
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cementerio.size();
	}
}
