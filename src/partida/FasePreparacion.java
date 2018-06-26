package partida;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cartas.Colocable;
import jugador.*;

public class FasePreparacion extends Fase {

	private Scanner teclado;
	
	public FasePreparacion() {
		this.teclado = new Scanner(System.in);
	}
	
	/*
	 * Fase de preparación: ​ En esta fase, es el momento de poner cartas en el 
	 * campo. Se pueden colocar tantas cartas de magia y trampa como se quiera,
	 * pero solo una invocación de monstruo (no se puede cambiar la posición del 
	 * monstruo ni voltearla el mismo turno que es colocada en el campo).
	 */
	
	@Override
	public void ejecutarFase(Jugador jugadorEnTurno) {
		
		this.colocarCartaAtacable(jugadorEnTurno);
		this.colocarCartasMagicasYTrampas(jugadorEnTurno);
	
	}
	
	
	public String pedirNombreCartaMonstruo(LinkedList<String> listaDeCartasAtacables) {

		System.out.println("Estas cartas de Monstruos estan en tu mano, ingrese el nombre de la carta"); 
		System.out.println("que quiera jugar o ingrese 'no' para no jugar ninguna carta");
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.println(listaDeCartasAtacables.get(i));
		}
	
		String nombreCartaMonstruoElegida = this.teclado.nextLine();
		while ((!listaDeCartasAtacables.contains(nombreCartaMonstruoElegida)) && (nombreCartaMonstruoElegida != "no")) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoElegida = this.teclado.nextLine();
		}

		return nombreCartaMonstruoElegida;
	}
	
	public String pedirEstadoCarta() {
		System.out.println("Ingrese 'arriba' o ' abajo' para indicar como quiere colocar la carta");
		String estado = teclado.nextLine();
		while ((estado != "arriba") && (estado != "abajo")) {
			System.out.println("Ingrese un estado valido");
			estado = teclado.nextLine();
		}
		
		return estado;
	}
	
	public String pedirModoCartaAtacable() {
		System.out.println("Ingrese 'ataque' o 'defensa' para indicar el modo de la carta");
		String modo = teclado.nextLine();
		while ((modo != "ataque") && (modo != "defensa")) {
			System.out.println("Ingrese un modo valido");
			modo = teclado.nextLine();
		}
		
		return modo;
	}
	
	
	public void colocarCartaAtacable(Jugador jugadorEnTurno) {	
		
		//Busco las cartas monstruo (Se puede jugar solo 1)
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnMano();
		if (!listaDeCartasAtacables.isEmpty()) {
			
			String nombreCartaMonstruoElegida = this.pedirNombreCartaMonstruo(listaDeCartasAtacables);
		
			if (nombreCartaMonstruoElegida != "no") {
			
				String estado = this.pedirEstadoCarta();
				String modo;
				if (estado == "arriba") {
				
					modo = this.pedirModoCartaAtacable();
				
				} else {
					modo = "defensa";
				}
				
				jugadorEnTurno.colocar(nombreCartaMonstruoElegida, estado, modo);
				
			}
		} 
	}
	
	public String pedirNombreCartaActivable(LinkedList<String> listaDeCartasActivables) {
		
		System.out.println("Estas cartas activables estan en tu mano, ingrese el nombre de la carta");
		System.out.println("que quiera jugar o ingrese 'no' para salir");
		for (int i=0; i<listaDeCartasActivables.size(); i++) {
			System.out.println(listaDeCartasActivables.get(i));
		}
		String nombreCartaElegida = teclado.nextLine();
		while ((!listaDeCartasActivables.contains(nombreCartaElegida)) && (nombreCartaElegida != "no")) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaElegida = teclado.nextLine();
		}
		
		return nombreCartaElegida;
	}
	
	
	
	public void colocarCartasMagicasYTrampas(Jugador jugadorEnTurno) {
		
		//Busco las cartas activables (se pueden jugar las que se quieran)
		LinkedList<String> listaDeCartasActivables = jugadorEnTurno.obtenerNombresDeCartasActivablesEnMano();
		String nombreCartaElegida = null;
		String estado = null;
		while (!(listaDeCartasActivables.isEmpty()) && (nombreCartaElegida != "no")) {
			
			nombreCartaElegida = this.pedirNombreCartaActivable(listaDeCartasActivables);
			
			if (listaDeCartasActivables.contains(nombreCartaElegida)) {
				estado = this.pedirEstadoCarta();
				jugadorEnTurno.colocar(nombreCartaElegida, estado);
			}
		}
	}
	
	Iterator<Colocable> posicionesIterador = this.cartasEnMano.iterator();
	while(posicionesIterador.hasNext()) {
		cartaActual = posicionesIterador.next();
	
	
}
