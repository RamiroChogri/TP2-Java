package partida;

import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import jugador.Jugador;

public class FaseAtaqueYTrampas extends Fase {
	
	
	@Override
	public void ejecutarFase(Jugador jugadorEnTurno) {
		
		Jugador jugadorEnemigo = jugadorEnTurno.obtenerJugadorEnemigo(); 
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Estas cartas de Monstruos estan en tu Zona de Monstruos, ingrese el nombre de la carta"); 
		System.out.println("que quiera utilizar para atacar");
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
	
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.print(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoAtacante = teclado.nextLine();
		while (!listaDeCartasAtacables.contains(nombreCartaMonstruoAtacante)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoAtacante = teclado.nextLine();
		}
		
		System.out.println("Estas cartas de Monstruos estan en la Zona de Monstruos de tu adversario, ingrese el nombre de la carta"); 
		System.out.println("a la que quiera atacar");
		LinkedList<String> listaDeCartasAdversario= jugadorEnemigo.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
	
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.print(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoAdversario = teclado.nextLine();
		while (!listaDeCartasAdversario.contains(nombreCartaMonstruoAdversario)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoAdversario = teclado.nextLine();
		}
		
		
		Atacable atacante, atacado;
		
		atacante = jugadorEnTurno.obtenerCartaDeZonaMonstruo( nombreCartaMonstruoAtacante ); 
		
		atacado = jugadorEnemigo.obtenerCartaDeZonaMonstruo( nombreCartaMonstruoAdversario ); 
		
		jugadorEnTurno.atacar( atacante , atacado );
		
		// Repetir esto hasta que el jugador decida dejar de atacar...
	}
}
