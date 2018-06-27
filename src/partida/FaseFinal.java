package partida;

import java.util.LinkedList;
import java.util.Scanner;
import cartas.Activable;
import jugador.Jugador;

public class FaseFinal extends Fase {

		private Scanner teclado;
		private Fase faseSiguiente;
		
		public FaseFinal() {
			this.teclado = new Scanner(System.in);
			this.faseSiguiente = null;
		}
	
		@Override
		public EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaRecibido) {
			
			LinkedList<String> magicasActivables = jugadorEnTurno.obtenerNombresDeCartasMagicasEnCampoPropio();
			EstadoPartida estadoPartidaADevolver = estadoPartidaRecibido;
			
			this.activarCartasMagicas(jugadorEnTurno , magicasActivables);
			
			if ((jugadorEnTurno.estaDerrotado()) || (jugadorEnTurno.obtenerJugadorEnemigo()).estaDerrotado()) {
				estadoPartidaADevolver = new EstadoPartidaTerminada();
			}
				
			return estadoPartidaADevolver;
			
		}
		
		public void activarCartasMagicas(Jugador jugadorEnTurno , LinkedList<String> cartasMagicas) {
			
			String nombreCartaElegida = " ";
			while (!(cartasMagicas.isEmpty()) && (!nombreCartaElegida.equals("no"))) {
			
				nombreCartaElegida = this.pedirNombreCartaMagicaAActivar(cartasMagicas);
			
				if (cartasMagicas.contains(nombreCartaElegida)) {
					Activable cartaMagica = jugadorEnTurno.obtenerCartaDeZonaMagicasYTrampas(nombreCartaElegida);
					jugadorEnTurno.voltearCarta(cartaMagica);
				}
			
			}
			
		}
		
		public String pedirNombreCartaMagicaAActivar(LinkedList<String> cartasMagicas) {
			
			System.out.println("Estas son las cartas Magicas boca abajo, ingrese el nombre de la carta ");
			System.out.println("que quiera activar o ingrese 'no' para no activar ninguna carta");
			for (int i=0; i<cartasMagicas.size(); i++) {
				System.out.println(cartasMagicas.get(i));
			}
			
			String nombreCartaElegida = this.teclado.nextLine();
			while (!(cartasMagicas.contains(nombreCartaElegida)) && (!nombreCartaElegida.equals("no"))) {
				
				System.out.println("Ingrese el nombre de una carta valida");
				nombreCartaElegida = this.teclado.nextLine();
			
			}
			
			return nombreCartaElegida;
		}
		
		@Override
		public void setFaseSiguiente(Fase faseSiguienteAColocar) {
			this.faseSiguiente = faseSiguienteAColocar;
		}

		@Override
		public Fase obtenerFaseSiguiente() {
			return this.faseSiguiente;
		}
}
