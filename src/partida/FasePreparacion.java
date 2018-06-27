package partida;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cartas.Colocable;
import estadoCarta.EstadoCarta;
import jugador.*;

public class FasePreparacion extends Fase {

	private Scanner teclado;
	private Fase faseSiguiente;
	
	public FasePreparacion() {
		this.teclado = new Scanner(System.in);
		this.faseSiguiente = null;
	}
	
	/*
	 * Fase de preparación: ​ En esta fase, es el momento de poner cartas en el 
	 * campo. Se pueden colocar tantas cartas de magia y trampa como se quiera,
	 * pero solo una invocación de monstruo (no se puede cambiar la posición del 
	 * monstruo ni voltearla el mismo turno que es colocada en el campo).
	 */
	
	@Override
	public EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaRecibido) {
		
		this.colocarCartaAtacable(jugadorEnTurno);
		this.colocarCartasMagicasYTrampas(jugadorEnTurno);
	
		return estadoPartidaRecibido;
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
		
	
	public void colocarCartaAtacable(Jugador jugadorEnTurno) {	
		
		//Busco las cartas monstruo (Se puede jugar solo 1)
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnMano();
		if (!listaDeCartasAtacables.isEmpty()) {
			
			String nombreCartaMonstruoElegida = this.pedirNombreCartaMonstruo(listaDeCartasAtacables);
		
			if (nombreCartaMonstruoElegida != "no") {
			
				this.colocar(jugadorEnTurno, nombreCartaMonstruoElegida);
								
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
		while (!(listaDeCartasActivables.isEmpty()) && (nombreCartaElegida != "no")) {
			
			nombreCartaElegida = this.pedirNombreCartaActivable(listaDeCartasActivables);
			
			if (listaDeCartasActivables.contains(nombreCartaElegida)) {

				this.colocar(jugadorEnTurno, nombreCartaElegida);
				
			}
		}
	}
	
	private void colocar(Jugador jugadorEnTurno, String nombreCartaElegida) {

		Colocable cartaAColocar = jugadorEnTurno.obtenerCartaDeMano(nombreCartaElegida);
		EstadoCarta estadoDeCarta = cartaAColocar.elegirComoColocar();
		jugadorEnTurno.colocar(cartaAColocar, estadoDeCarta);
			
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
