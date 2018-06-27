package partida;

import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import jugador.Jugador;

public class FaseAtaqueYTrampas extends Fase {
	
	private Scanner teclado;
	private Fase faseSiguiente;
	
	public FaseAtaqueYTrampas() {
		this.teclado = new Scanner(System.in);
		this.faseSiguiente = null;
	}
	
	@Override
	public EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaActual) {
		String respuesta;
		EstadoPartida estadoPartidaADevolver = estadoPartidaActual;
		
		System.out.print("Desea atacar? (si/no)");
		respuesta = teclado.nextLine();
		
		//FALTA VER QUE SE PUEDA ATACAR DIRECTAMENTE AL JUGADOR
		//FALTA VER QUE SI NO TE QUEDAN CARTAS PARA ATACAR QUE NO TE PREGUNTE
		
		while ( respuesta == "si" ) {
			
			Jugador jugadorEnemigo = jugadorEnTurno.obtenerJugadorEnemigo(); 
		
			String nombreAtacante = this.pedirNombreCartaAtacante(jugadorEnTurno); 
			String nombreAtacado = this.pedirNombreCartaAdversario(jugadorEnemigo);
		
			Atacable atacante, atacado;
		
			atacante = jugadorEnTurno.obtenerCartaDeZonaMonstruo( nombreAtacante ); 
		
			atacado = jugadorEnemigo.obtenerCartaDeZonaMonstruo( nombreAtacado ); 
		
			jugadorEnTurno.atacar( atacante , atacado );
			
			System.out.print("Desea seguir atacando? (si/no)");
			respuesta = teclado.nextLine();
		}	
		
		if ((jugadorEnTurno.estaDerrotado()) || (jugadorEnTurno.obtenerJugadorEnemigo()).estaDerrotado()) {
			estadoPartidaADevolver = new EstadoPartidaTerminada();
		}
			
		return estadoPartidaADevolver;
			
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

	@Override
	public void setFaseSiguiente(Fase faseSiguienteAColocar) {
		this.faseSiguiente = faseSiguienteAColocar;
	}

	@Override
	public Fase obtenerFaseSiguiente() {
		return this.faseSiguiente;
	}
	
}
