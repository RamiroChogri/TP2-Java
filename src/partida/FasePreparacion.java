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
		
		/////////////////////////////////////////
		
		//Busco las cartas monstruo (Se puede jugar solo 1)
		System.out.println("Estas cartas de Monstruos estan en tu mano, ingrese el nombre de la carta"); 
		System.out.println("que quiera jugar o ingrese 'no' para salir");
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnMano();
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.print(listaDeCartasAtacables.get(i));
		}
		String nombreCartaMonstruoElegida = teclado.nextLine();
		while (!listaDeCartasAtacables.contains(nombreCartaMonstruoElegida)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoElegida = teclado.nextLine();
		}
		
		//Pedir estado y modo
		
		///////////////////////////////////
		
		//Busco las cartas activables (se pueden jugar las que se quieran)
		System.out.println("Estas cartas activables estan en tu mano, ingrese el nombre de la carta");
		System.out.println("que quiera jugar o ingrese 'no' para salir");
		LinkedList<String> listaDeCartas = jugadorEnTurno.obtenerNombresDeCartasActivablesEnMano();
		for (int i=0; i<listaDeCartas.size(); i++) {
			System.out.print(listaDeCartas.get(i));
		}
		String nombreCartaElegida = teclado.nextLine();
		while (!listaDeCartas.contains(nombreCartaElegida)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaElegida = teclado.nextLine();
		}
		
		
		//Pedir estado
		
		////////////////////////////////////////
		
	}

	
	
	
}
