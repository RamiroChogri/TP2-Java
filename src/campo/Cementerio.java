package campo;

import java.util.LinkedList;

import cartas.Colocable;
import cartas.Destruible;

public class Cementerio {

	private LinkedList<Destruible> cementerio;
	
	public Cementerio() {
		this.cementerio = new LinkedList<Destruible>();
	}
	
	public void agregarCarta(Destruible cartaDestruida) {
		this.cementerio.add(cartaDestruida);
	}
	
	public void agregarCartas(LinkedList<Destruible> cartasAEnterrar) {
		this.cementerio.addAll(cartasAEnterrar);
	}
	
	public int obtenerCantidadDeCartas() {
		return this.cementerio.size();
	}

	public String obtenerNombreDeLaImagenDeLaUltimaCarta() {
		
		return this.cementerio.getLast().getNombreDeLaImagen();
	}
}
