package modos;
import cartas.*;

public abstract class Modo {
		
		public ModoAtaque colocarEnModoAtaque() {
			return new ModoAtaque();
		}
		
		public ModoDefensa colocarEnModoDefensa() {
			return new ModoDefensa();
		}
		
		public abstract boolean estaEnModoAtaque();
		public abstract boolean estaEnModoDefensa();

		public abstract void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada);

}
