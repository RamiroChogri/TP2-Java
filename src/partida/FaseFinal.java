package partida;

import java.util.LinkedList;
import java.util.Scanner;
import cartas.Activable;
import jugador.Jugador;

public class FaseFinal extends Fase {

		private Scanner teclado;
		private Jugador jugadorEnTurno;
		private String nombreFase;
		
		public FaseFinal(Jugador jugadorRecibido) {
			this.teclado = new Scanner(System.in);
			this.nombreFase = "Fase Final";
			this.jugadorEnTurno = jugadorRecibido;
		}
		
		public String getNombreFase() {
			return this.nombreFase;
		}

		@Override
		public Fase obtenerFaseSiguiente() {
			Fase faseADevolver = new FasePreparacion(jugadorEnTurno.obtenerJugadorEnemigo());
			return faseADevolver;
		}
		
		@Override
		public Jugador obtenerJugadorEnTurno() {
			return this.jugadorEnTurno;
		}
		
		@Override
		public boolean esFaseFinal() {
			return true;
		}
}
