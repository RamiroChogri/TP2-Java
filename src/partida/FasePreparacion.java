package partida;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import cartas.Colocable;
import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaColocadaBocaArriba;
import exceptions.NoHayMonstruoParaSacrificarException;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;
import jugador.*;
import modos.Modo;
import modos.ModoAtaque;
import modos.ModoDefensa;

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
		boolean sePudoColocarLaCartaMonstruo = false;
		while (!sePudoColocarLaCartaMonstruo && (jugadorEnTurno.obtenerCantidadCartasEnZonaMonstruos() < 5)) {
			try {
				this.colocarCartaAtacable(jugadorEnTurno);
				sePudoColocarLaCartaMonstruo = true;
			} catch (NoHaySuficientesMonstruosParaSacrificarException e) {
				System.out.println("No se puede colocar ese monstruo");
			}
		}
		
		this.colocarCartasMagicasYTrampas(jugadorEnTurno);
	
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
		if (!listaDeCartasAtacables.isEmpty()) {
			listaDeCartasAtacables.removeLast();
		}
		
		boolean quiereRotar = true;
		while (!listaDeCartasAtacables.isEmpty() && quiereRotar) {
			quiereRotar = this.preguntarSiQuiereRotar(jugadorEnTurno, listaDeCartasAtacables);
		}
		
		return estadoPartidaRecibido;
	}
	
	public boolean preguntarSiQuiereRotar(Jugador jugadorEnTurno, LinkedList<String> listaDeCartasAtacables) {
		
		boolean quiereSeguirRotando = false;
		System.out.println("Estas cartas de Monstruos estan en tu mano, ingrese el nombre de la carta"); 
		System.out.println("que quiera cambiar el modo o ingrese 'no' para no cambiar ninguna carta");
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.println(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoElegida = this.teclado.nextLine();
		while ((!listaDeCartasAtacables.contains(nombreCartaMonstruoElegida)) && (!nombreCartaMonstruoElegida.equals("no"))) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoElegida = this.teclado.nextLine();
		}
		
		if (!nombreCartaMonstruoElegida.equals("no")) {
			
			Atacable cartaARotar = jugadorEnTurno.obtenerCartaDeZonaMonstruo(nombreCartaMonstruoElegida);
			Modo modoAColocar;
			if (cartaARotar.estaColocadaBocaAbajo()) {
				
				EstadoCarta bocaArriba = new EstadoCartaColocadaBocaArriba();
				cartaARotar.ponerEn(bocaArriba);
		
				Modo modoRecibido = this.preguntarAQueModoQuiereRotar(cartaARotar);
				cartaARotar.cambiarA(modoRecibido);
				
			} else {
				
				if(cartaARotar.estaEnModoAtaque()) {
					modoAColocar = new ModoDefensa();
					cartaARotar.cambiarA(modoAColocar);
				} else {
					modoAColocar = new ModoAtaque();
					cartaARotar.cambiarA(modoAColocar);
				}
				
			}
			
			listaDeCartasAtacables.remove(nombreCartaMonstruoElegida);

			System.out.print("Desea seguir rotando cartas? (si/no)");
			quiereSeguirRotando = this.pedirRespuestaValidaSiNo();
			
		}
		
		return quiereSeguirRotando;
	}
	
	public Modo preguntarAQueModoQuiereRotar(Atacable cartaARotar) {
		
		Modo modoADevolver = new ModoDefensa();
		System.out.println("La carta se encuentra en modo defensa, quiere rotarla? (si/no)");
		boolean deseaRotar = this.pedirRespuestaValidaSiNo();
		
		if (deseaRotar) {
			modoADevolver = new ModoAtaque();
		}
		
		return modoADevolver;
		
	}
	
	
	public boolean pedirRespuestaValidaSiNo() {
		
		String quiereSeguir = this.teclado.next();
		while (!quiereSeguir.equals("no") && !(quiereSeguir.equals("si"))) {
			System.out.println("Ingrese una respuesta valida (si/no)");
			quiereSeguir = this.teclado.nextLine();
		}
	
		boolean respuesta = false;
		if (quiereSeguir.equals("si")) {
			respuesta = true;
		}
		
		return respuesta;
	}
	
	
	public String pedirNombreCartaMonstruo(LinkedList<String> listaDeCartasAtacables) {

		System.out.println("Estas cartas de Monstruos estan en tu mano, ingrese el nombre de la carta"); 
		System.out.println("que quiera jugar o ingrese 'no' para no jugar ninguna carta");
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.println(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoElegida = this.teclado.nextLine();
		while ((!listaDeCartasAtacables.contains(nombreCartaMonstruoElegida)) && (!nombreCartaMonstruoElegida.equals("no"))) {
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
		
			if (!nombreCartaMonstruoElegida.equals("no")) {
			
				this.colocar(jugadorEnTurno, nombreCartaMonstruoElegida);
				jugadorEnTurno.eliminarCartaDeLaMano(nombreCartaMonstruoElegida);
								
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
		while ((!listaDeCartasActivables.contains(nombreCartaElegida)) && (!nombreCartaElegida.equals("no"))) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaElegida = teclado.nextLine();
		}
		
		return nombreCartaElegida;
	}
	
	
	
	public void colocarCartasMagicasYTrampas(Jugador jugadorEnTurno) {
		
		//Busco las cartas activables (se pueden jugar las que se quieran)
		LinkedList<String> listaDeCartasActivables = jugadorEnTurno.obtenerNombresDeCartasActivablesEnMano();
		String nombreCartaElegida = " ";
		
		while (!(listaDeCartasActivables.isEmpty()) && (!nombreCartaElegida.equals("no"))) {
			
			nombreCartaElegida = this.pedirNombreCartaActivable(listaDeCartasActivables);
			
			if (listaDeCartasActivables.contains(nombreCartaElegida)) {

				this.colocar(jugadorEnTurno, nombreCartaElegida);
				listaDeCartasActivables.remove(nombreCartaElegida);
				jugadorEnTurno.eliminarCartaDeLaMano(nombreCartaElegida);
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
