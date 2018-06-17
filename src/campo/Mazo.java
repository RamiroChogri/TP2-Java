package campo;

import java.util.Stack;

import cartas.Destruible;
import cartas.CartaMonstruo;

public class Mazo {

	private Stack<Destruible> mazo;
	
	public Mazo() {
		this.mazo = new Stack<Destruible>();
		while(this.mazo.size()<40) {
			Destruible cartaActual = new CartaMonstruo();
			this.mazo.add(cartaActual);
		}
	}
	
	public int obtenerCantidaDeCartas() {
		return this.mazo.size();
	}
	
	public Destruible levantarCarta() {
		return this.mazo.pop();
	}
}
