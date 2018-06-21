package campo;

import java.util.EmptyStackException;
import java.util.Stack;

import cartas.Colocable;
import exceptions.NoQuedanCartasEnElMazoException;
import cartas.CartaMonstruo;

public class Mazo {

	private Stack<Colocable> mazo;
	
	public Mazo() {
		this.mazo = new Stack<Colocable>();
		while(this.mazo.size()<40) {
			Colocable cartaActual = new CartaMonstruo();
			this.mazo.add(cartaActual);
		}
	}
	
	public int obtenerCantidaDeCartas() {
		return this.mazo.size();
	}
	
	public Colocable levantarCarta() {
		Colocable cartaADevolver;
		try {
			cartaADevolver =  this.mazo.pop();
		} catch (EmptyStackException error) {
			throw new NoQuedanCartasEnElMazoException();
		}

		return cartaADevolver;
	}
}
