package partida;

import java.util.LinkedList;
import java.util.Scanner;
import cartas.Activable;
import jugador.Jugador;

public class FaseFinal extends Fase {

		private Scanner teclado;
		
		public FaseFinal() {
			this.teclado = new Scanner(System.in);
		}
	
		@Override
		public void ejecutarFase(Jugador jugadorEnTurno) {
			
			LinkedList<String> magicasActivables = jugadorEnTurno.obtenerNombresDeCartasMagicasEnCampoPropio();
			
			this.activarCartasMagicas(jugadorEnTurno , magicasActivables);
			
		}
		
		public void activarCartasMagicas(Jugador jugadorEnTurno , LinkedList<String> cartasMagicas) {
			
			String nombreCartaElegida = null;
			while (!(cartasMagicas.isEmpty()) && (nombreCartaElegida != "no")) {
			
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
			while (!(cartasMagicas.contains(nombreCartaElegida)) && (nombreCartaElegida != "no")) {
				
				System.out.println("Ingrese el nombre de una carta valida");
				nombreCartaElegida = this.teclado.nextLine();
			
			}
			
			return nombreCartaElegida;
		}
}
