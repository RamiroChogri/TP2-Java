package partida;

import jugador.Jugador;

public class Partida {

	private Fase faseInicial;
	private Fase fasePreparacion;
	private Fase faseAtaqueYTrampas; 
	private Fase faseFinal;
	private EstadoPartida estado;
	
	public Partida() {
		this.faseInicial = new FaseInicial();
		this.fasePreparacion = new FasePreparacion();
		this.faseAtaqueYTrampas = new FaseAtaqueYTrampas();
		this.faseFinal = new FaseFinal();
		this.estado = new EstadoPartidaEnJuego();
	}
	
	public void comienzaElDuelo() {
		Jugador jugadorEnTurno = null;
		String nombreJugadorEnTurno;
		Jugador jugadorYugi = new Jugador();
		Jugador jugadorKaiba = new Jugador();
		jugadorYugi.setName("Yugi");
		jugadorKaiba.setName("Kaiba");
		String ganador;
		
		jugadorEnTurno = this.elegirQuienComienza(jugadorYugi, jugadorKaiba);
		
		jugadorYugi.enfrentarseA(jugadorKaiba);
		jugadorKaiba.enfrentarseA(jugadorYugi);
		
		int vidaJugadorEnTurno;
		
		while (this.estado.continuaLaPartida()) {
			nombreJugadorEnTurno = jugadorEnTurno.obtenerNombre();
			System.out.println("Turno del jugador " + nombreJugadorEnTurno);
			
			this.faseInicial.ejecutarFase(jugadorEnTurno); //Recibir excepcion por mazo vacio
			this.fasePreparacion.ejecutarFase(jugadorEnTurno);
			this.faseAtaqueYTrampas.ejecutarFase(jugadorEnTurno);
			this.faseFinal.ejecutarFase(jugadorEnTurno);
		
			vidaJugadorEnTurno = jugadorEnTurno.obtenerVida();
			System.out.println("Al jugador " + nombreJugadorEnTurno + "le quedan " + vidaJugadorEnTurno + "puntos de vida");
			
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
	
	public Jugador elegirQuienComienza(Jugador unJugador, Jugador otroJugador) {
		
		Jugador jugadorQueComienza = unJugador ;
		
		if(Math.random() < 0.5) {
			jugadorQueComienza = otroJugador;
		}
		
		return jugadorQueComienza;
	}
	
}
