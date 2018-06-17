package campo;

import cartas.Destruible;

import java.util.LinkedList;

import cartas.CartaCampo;

public class EspacioCampo extends Zona{

	private CartaCampo cartaCampo;
	private Boolean hayCartaCampo;
	
	public EspacioCampo() {
		this.cartaCampo = new CartaCampo();
		this.hayCartaCampo = false;
	}
	
	public void activarEfectoDeCampo() {
		//this.cartaCampo.activarEfecto();
	}
	
	public void desactivarEfectoDeCampo() {
		//this.cartaCampo.activarEfecto();
	}
	
	public void colocarCarta(Destruible cartaMonstruoAColocar) {
		//MetodoForzadoPorZona
	}
	public void colocarCarta(CartaCampo cartaAColocar) {
		this.cartaCampo = cartaAColocar;
		this.hayCartaCampo = true;
	}
	
	public void destruirCarta() {
		this.cartaCampo = null;
		this.hayCartaCampo = false;
	}
	
	public int obtenerCantidadDeCartas() {
		int cantidadDeCartaCampo = hayCartaCampo ? 1 : 0;
		return cantidadDeCartaCampo;
	}

	public LinkedList<Destruible> recolectarCartasDestruidas() {
		Destruible cartaCampoADestruir = null;
		if(this.cartaCampo.estaDestruida()) {
			cartaCampoADestruir = this.cartaCampo;
			this.cartaCampo = null;
		}
		LinkedList<Destruible> cartasDestruidas = new LinkedList<Destruible>();
		cartasDestruidas.add(cartaCampoADestruir);
	    return cartasDestruidas;
	}

	public boolean hayEspacioDisponible() {
		return this.hayCartaCampo;
	}

	public void vaciar() {
		this.destruirCarta();
	}
}
