package modos;
import cartas.*;

public abstract class Modo {

		private Puntos puntosDeAtaque;
		private Puntos puntosDeDefensa;
	
		public abstract void asignarPuntos(Puntos puntosAtaque, Puntos puntosDefensa);
		
		public ModoAtaque colocarEnModoAtaque() {
			return new ModoAtaque(this.puntosDeAtaque, this.puntosDeDefensa);
		}
		
		public ModoDefensa colocarEnModoDefensa() {
			return new ModoDefensa(this.puntosDeAtaque, this.puntosDeDefensa);
		}
	
}
