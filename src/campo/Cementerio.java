package campo;

import java.util.LinkedList;

import cartas.Destruible;

public class Cementerio {

	private LinkedList<Destruible> cementerio;
	
	public Cementerio() {
		this.cementerio = new LinkedList<Destruible>();
	}
	
	public void agregarCartaAlCementerio(Destruible cartaDestruida) {
		this.cementerio.add(cartaDestruida);
	}
	
	public void agregarCartasAlCementerio(LinkedList<Destruible> cartasAEnterrar) {
		this.cementerio.addAll(cartasAEnterrar);
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cementerio.size();
	}
}
