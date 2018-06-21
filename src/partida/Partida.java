package partida;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cartas.CartaMonstruo;
import jugador.Jugador;

public class Partida {

	private boolean partidaFinalizada;
	private Fase faseInicial;
	private Fase fasePreparacion;
	private Fase faseAtaque;
	private Fase faseTrampa;
	private Fase faseFinal;
	private Fase faseActual;
	private LinkedList<Fase> listaDeFases;
	
	
	public Partida() {
		
		this.listaDeFases = new LinkedList<Fase>();
		
		this.faseInicial = new FaseInicial();
		this.listaDeFases.addLast(this.faseInicial);
		
		this.fasePreparacion = new FasePreparacion();
		this.listaDeFases.addLast(this.fasePreparacion);
		
		this.faseAtaque = new FaseAtaque();
		this.listaDeFases.addLast(this.faseAtaque);
		
		this.faseTrampa = new FaseTrampa();
		this.listaDeFases.addLast(this.faseTrampa);
		
		this.faseFinal = new FaseFinal();
		this.listaDeFases.addLast(this.faseFinal);
		
		this.faseActual = this.listaDeFases.getFirst();
		this.partidaFinalizada = false;
	
	}
	
	public void jugar(){
		this.partidaFinalizada = false;
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		jugador1.enfrentarseA(jugador2);
		jugador2.enfrentarseA(jugador1);
		
		Jugador jugadorEnTurno;
		
		if (Math.random() < 0.5) {
			jugadorEnTurno = jugador1;
		} else {
			jugadorEnTurno = jugador2;
		}

//		Scanner teclado = new Scanner(System.in);
//		String entradaTeclado;
//		
//		System.out.println(jugadorEnTurno.obtenerNombresCartasEnMano());
//		entradaTeclado = teclado.nextLine();
		
		Iterator<Fase> fasesIterador;
		
		while (!partidaFinalizada) {
			jugadorEnTurno = jugadorEnTurno.obtenerJugadorEnemigo();
			
			fasesIterador = this.listaDeFases.iterator();
			this.faseActual = fasesIterador.next();
			
			if (!(jugadorEnTurno.tieneAExodiaEnMano())) {
		    	while (fasesIterador.hasNext()) {
		    		this.faseActual = fasesIterador.next();
		    		//Verificar que se ingrese el nombre de un monstruo que existe.
		    	
		    		//Ver fases (se manejan con fase actual, que va a recorrer todas las fases
		    		//hasta la final
		    	}
			}
		    
		    //No se verifica quien gano
		    
			if (jugadorEnTurno.estaMuerto() || jugadorEnTurno.obtenerJugadorEnemigo().estaMuerto() || 
					jugadorEnTurno.obtenerCartasMazo() <= 0 || jugadorEnTurno.obtenerJugadorEnemigo().obtenerCartasMazo() <= 0 ||
					jugadorEnTurno.tieneAExodiaEnMano()) {
				this.finalizar();
			}
		}
		
		//No funciona bien, no elige correctamente al jugador ganador, revisar
		String jugadorGanador;
		
		if (jugadorEnTurno == jugador1) {
			jugadorGanador = "Jugador 1";
		} else {
			jugadorGanador = "Jugador 2";
		}
		
		System.out.println("El jugador " + jugadorGanador + " ha ganado!");
	}
	
	public void finalizar() {
		this.partidaFinalizada = true;
	}
	
}
