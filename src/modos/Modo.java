package modos;

public abstract class Modo {

		public ModoAtaque colocarEnModoAtaque() {
			return new ModoAtaque();
		}
		
		public ModoDefensa colocarEnModoDefensa() {
			return new ModoDefensa();
		}
	
}
