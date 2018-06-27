package partida;

import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import jugador.Jugador;

public class FaseAtaqueYTrampas extends Fase {
	
	private Scanner teclado;

	public FaseAtaqueYTrampas() {
		Scanner teclado = new Scanner(System.in);
	}
	
	@Override
	public void ejecutarFase(Jugador jugadorEnTurno) {
		String respuesta;
		
		do {
			System.out.print("Desea atacar? (si/no)");
			respuesta = teclado.nextLine();
			
			Jugador jugadorEnemigo = jugadorEnTurno.obtenerJugadorEnemigo(); 
		
			String nombreAtacante = this.pedirNombreCartaAtacante(jugadorEnTurno); 
			String nombreAtacado = this.pedirNombreCartaAdversario(jugadorEnemigo);
		
			Atacable atacante, atacado;
		
			atacante = jugadorEnTurno.obtenerCartaDeZonaMonstruo( nombreAtacante ); 
		
			atacado = jugadorEnemigo.obtenerCartaDeZonaMonstruo( nombreAtacado ); 
		
			jugadorEnTurno.atacar( atacante , atacado );
			
		} while ( respuesta == "si" );
		
	}
	
	
	public String pedirNombreCartaAtacante( Jugador jugadorEnTurno ) {
		
		System.out.println("Estas cartas de Monstruos estan en tu Zona de Monstruos, ingrese el nombre de la carta"); 
		System.out.println("que quiera utilizar para atacar");
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
	
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.print(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoAtacante = this.teclado.nextLine();
		while (!listaDeCartasAtacables.contains(nombreCartaMonstruoAtacante)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoAtacante = this.teclado.nextLine();
		}
		
		return 	nombreCartaMonstruoAtacante;
	}

	public String pedirNombreCartaAdversario( Jugador jugadorEnemigo ) {
		
		System.out.println("Estas cartas de Monstruos estan en la Zona de Monstruos de tu adversario, ingrese el nombre de la carta"); 
		System.out.println("a la que quiera atacar");
		LinkedList<String> listaDeCartasAdversario= jugadorEnemigo.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
	
		for (int i=0; i<listaDeCartasAdversario.size(); i++) {
			System.out.print(listaDeCartasAdversario.get(i));
		}
		
		String nombreCartaMonstruoAdversario = teclado.nextLine();
		while (!listaDeCartasAdversario.contains(nombreCartaMonstruoAdversario)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoAdversario = teclado.nextLine();
		}
		
		return nombreCartaMonstruoAdversario;
	}
	
}
