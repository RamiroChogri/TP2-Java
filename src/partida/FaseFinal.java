package partida;

import java.util.LinkedList;

import cartas.Activable;
import jugador.Jugador;

public class FaseFinal extends Fase {

		@Override
		public void ejecutarFase(Jugador jugadorDeTurno) {
			
			LinkedList<Activable> magicasActivables = jugadorDeTurno.verCartasMagicasActivables();
			
			this.activarCartasMagicas(jugadorDeTurno , magicasActivables);
			
		}
		
		public void activarCartasMagicas(Jugador jugadorDeTurno , LinkedList<Activable> cartasMagicas) {
			System.out.println("estas son las cartas Magicas boca abajo, elija si quiere activar alguna");
			for (int i=0; i<cartasMagicas.size(); i++) {
				System.out.println(cartasMagicas.get(i).obtenerNombre());
			}
		}
}
