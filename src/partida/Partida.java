package partida;

import jugador.Jugador;

public class Partida {

	private Fase faseInicial;
	private Fase fasePreparacion;
	private Fase faseAtaque; 
	private Fase faseTrampas;
	private Fase faseFinal;
	
	public Partida() {
		this.faseInicial = new FaseInicial();
		this.fasePreparacion = new FasePreparacion();
		this.faseAtaque = new FaseAtaque();
		this.faseTrampas = new FaseTrampas();
		this.faseFinal = new FaseFinal();
	}
	
	public void comienzaElDuelo() {
		Jugador jugadorEnTurno = null;
		String nombreJugadorEnTurno;
		Jugador jugadorYugi = new Jugador();
		Jugador jugadorKaiba = new Jugador();
		jugadorYugi.setName("Yugi");
		jugadorKaiba.setName("Kaiba");
		String ganador;
		
		if (Math.random() < 0.5) {
			jugadorEnTurno = jugadorYugi;
			nombreJugadorEnTurno = "Yugi";
		} else {
			jugadorEnTurno = jugadorKaiba;
			nombreJugadorEnTurno = "Kaiba";
		}
		
		jugadorYugi.enfrentarseA(jugadorKaiba);
		jugadorKaiba.enfrentarseA(jugadorYugi);
		
		boolean partidaTerminada = false;
		
		while (!partidaTerminada) {
			nombreJugadorEnTurno = jugadorEnTurno.obtenerNombre();
			System.out.println("Turno del jugador " + nombreJugadorEnTurno);
			
			this.faseInicial.ejecutarFase(jugadorEnTurno); //Recibir excepcion por mazo vacio
			this.fasePreparacion.ejecutarFase(jugadorEnTurno);
			this.faseAtaque.ejecutarFase(jugadorEnTurno);
			this.faseTrampas.ejecutarFase(jugadorEnTurno);
			this.faseFinal.ejecutarFase(jugadorEnTurno);
		
			jugadorEnTurno = jugadorEnTurno.obtenerJugadorEnemigo();		
		
		}
		
		if (jugadorKaiba.estaDerrotado()) {
			ganador = jugadorYugi.obtenerNombre();
		} else {
			ganador = jugadorKaiba.obtenerNombre();
		}
		
		if (jugadorYugi.estaDerrotado()) {
			System.out.println("No gano ninguno, son malisimos los dos.");
		} else {
			System.out.println("Gano el jugador " + ganador + ", el otro es malismo.");
		}
		
		
	}
	
	
}
