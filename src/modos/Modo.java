package modos;
import cartas.*;

public abstract class Modo {

		public abstract void asignarPuntosAtaque(Puntos puntosAtaque);
		
		public abstract void asignarPuntosDefensa(Puntos puntosDefensa);
		
	
		public ModoAtaque colocarEnModoAtaque() {
			return new ModoAtaque();
		}
		
		public ModoDefensa colocarEnModoDefensa() {
			return new ModoDefensa();
		}
	
}
