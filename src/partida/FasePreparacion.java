package partida;

import java.util.LinkedList;
import java.util.Scanner;

import jugador.*;

public class FasePreparacion extends Fase {

	/*
	 * Fase de preparación: ​ En esta fase, es el momento de poner cartas en el 
	 * campo. Se pueden colocar tantas cartas de magia y trampa como se quiera,
	 * pero solo una invocación de monstruo (no se puede cambiar la posición del 
	 * monstruo ni voltearla el mismo turno que es colocada en el campo).
	 */
	
	@Override
	public void ejecutarFase(Jugador jugadorEnTurno) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Estas cartas estan en tu mano:");
		LinkedList<String> listaDeCartas = jugadorEnTurno.obtenerNombresDeCartasEnMano();
		for (int i=0; i<listaDeCartas.size(); i++) {
			System.out.print(listaDeCartas.get(i));
		}
		String nombreCartaElegida = teclado.nextLine();
		while (!listaDeCartas.contains(nombreCartaElegida)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaElegida = teclado.nextLine();
		}
		
		
		
		
		
		
	}

	
	
	
}
