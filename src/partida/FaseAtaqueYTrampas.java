package partida;

import java.util.LinkedList;
import java.util.Scanner;

import cartas.Atacable;
import exceptions.FaltaJugadorEnemigoException;
import exceptions.NoSePuedeAtacarAlJugadorDirectamenteException;
import jugador.Jugador;

public class FaseAtaqueYTrampas extends Fase {
	
	private Scanner teclado;
	private Fase faseSiguiente;
	private boolean esPrimerTurno;
	
	public FaseAtaqueYTrampas() {
		this.teclado = new Scanner(System.in);
		this.faseSiguiente = null;
		this.esPrimerTurno = true;
	}
	
	@Override
	public EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaActual) {
		EstadoPartida estadoADevolver = estadoPartidaActual;
		if (!esPrimerTurno) {
			
			estadoADevolver = this.ejecutarFaseCuandoNoEsPrimerTurno(jugadorEnTurno, estadoPartidaActual);
			
		} else {
			esPrimerTurno = false;
		}
		
		return estadoADevolver;
					
	}
	
	
	public EstadoPartida ejecutarFaseCuandoNoEsPrimerTurno(Jugador jugadorEnTurno, EstadoPartida estadoPartidaActual) {
		Jugador jugadorEnemigo = jugadorEnTurno.obtenerJugadorEnemigo(); 
		String respuesta = "si";
		EstadoPartida estadoPartidaADevolver = estadoPartidaActual;
		LinkedList<String> listaDeCartasAtacables = jugadorEnTurno.obtenerNombresDeCartasAtacablesEnModoAtaqueEnZonaMonstruos();
		
		while (!(listaDeCartasAtacables.isEmpty()) && !respuesta.equals("no")) {
		
			System.out.print("Desea atacar? (si/no)");
			respuesta = this.pedirRespuestaValida();
			
			
			while ( !(listaDeCartasAtacables.isEmpty()) && respuesta.equals("si") ) {
				
				
			
				String nombreAtacante = this.pedirNombreCartaAtacante(jugadorEnTurno, listaDeCartasAtacables); 
				String nombreAtacado = this.pedirNombreCartaAdversario(jugadorEnemigo);
			
				Atacable atacante;
				atacante = jugadorEnTurno.obtenerCartaDeZonaMonstruo( nombreAtacante ); 
				
				if (nombreAtacado.equals("jugador")) {
				
					try {
						jugadorEnTurno.atacar( atacante , jugadorEnemigo);
						listaDeCartasAtacables.remove(nombreAtacante);
						System.out.print("Desea seguir atacando? (si/no)");
						respuesta = this.pedirRespuestaValida();
					
					} catch (NoSePuedeAtacarAlJugadorDirectamenteException e) {
						System.out.println("No se puede atacar al jugador");
						respuesta = "si";
					}
					
				} else {

					Atacable atacado;
					atacado = jugadorEnemigo.obtenerCartaDeZonaMonstruo( nombreAtacado ); 
					jugadorEnTurno.atacar( atacante , atacado );
					listaDeCartasAtacables.remove(nombreAtacante);
					
					System.out.print("Desea seguir atacando? (si/no)");
					respuesta = this.pedirRespuestaValida();
					
				}
				

			}	
			
			if ((jugadorEnTurno.estaDerrotado()) || jugadorEnemigo.estaDerrotado()) {
				estadoPartidaADevolver = new EstadoPartidaTerminada();
			}
			
		}
				
		return estadoPartidaADevolver;

	}
	
	public String pedirRespuestaValida() {
		
		String respuesta = teclado.nextLine();
		while ((!respuesta.equals("no")) && (!respuesta.equals("si"))) {
			System.out.println("Ingrese una respuesta valida (si/no):");
			respuesta = teclado.nextLine();
		}
		
		return respuesta;
		
	}
	
	public String pedirNombreCartaAtacante( Jugador jugadorEnTurno, LinkedList<String> listaDeCartasAtacables ) {
		
		System.out.println("Estas cartas de Monstruos estan en tu Zona de Monstruos, ingrese el nombre de la carta"); 
		System.out.println("que quiera utilizar para atacar");
	
		for (int i=0; i<listaDeCartasAtacables.size(); i++) {
			System.out.println(listaDeCartasAtacables.get(i));
		}
		
		String nombreCartaMonstruoAtacante = this.teclado.nextLine();
		while (!listaDeCartasAtacables.contains(nombreCartaMonstruoAtacante)) {
			System.out.println("Ingrese el nombre de una carta valida");
			nombreCartaMonstruoAtacante = this.teclado.nextLine();
		}
		
		return 	nombreCartaMonstruoAtacante;
	}

	public String pedirNombreCartaAdversario( Jugador jugadorEnemigo ) {
		
		String nombreCartaMonstruoAdversario = "jugador";
		LinkedList<String> listaDeCartasAdversario= jugadorEnemigo.obtenerNombresDeCartasAtacablesEnZonaMonstruos();
		
		if (listaDeCartasAdversario.size() > 0) {
	
			System.out.println("Estas cartas de Monstruos estan en la Zona de Monstruos de tu adversario, ingrese el nombre de la carta"); 
			System.out.println("a la que quiera atacar o ingrese 'jugador' para atacar directamente al adversario");
			
			for (int i=0; i<listaDeCartasAdversario.size(); i++) {
				System.out.println(listaDeCartasAdversario.get(i));
			}
			
			nombreCartaMonstruoAdversario = teclado.nextLine();
			while (!listaDeCartasAdversario.contains(nombreCartaMonstruoAdversario) && (!nombreCartaMonstruoAdversario.equals("jugador"))) {
				System.out.println("Ingrese el nombre de una carta valida");
				nombreCartaMonstruoAdversario = teclado.nextLine();
			}
			
			
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
