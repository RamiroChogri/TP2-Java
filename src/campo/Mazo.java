package campo;

import java.util.Stack;

import cartas.Carta;
import cartas.CartaMonstruo;

public class Mazo {

	private Stack<Carta> mazo;
	
	public Mazo() {
		this.mazo = new Stack<Carta>();
		while(this.mazo.size()<40) {
			Carta cartaActual = new CartaMonstruo();
			this.mazo.add(cartaActual);
		}
	}
	
	public int obtenerCantidaDeCartas() {
		return this.mazo.size();
	}
	
	public Carta levantarCarta() {
		return this.mazo.pop();
	}
}
