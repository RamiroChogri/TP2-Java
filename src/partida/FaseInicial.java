package partida;

import jugador.Jugador;

public class FaseInicial extends Fase {

	private Fase faseSiguiente;
	private String nombreFase;
	private Jugador jugadorEnTurno;
	
	public FaseInicial(Jugador jugadorRecibido) {
		this.faseSiguiente = null;
		this.nombreFase = "Fase Inicial";
		this.jugadorEnTurno = jugadorRecibido;
		jugadorEnTurno.tomarCartaDelMazo();
	}
	
	public String getNombreFase() {
		return this.nombreFase;
	}
	
	@Override
	public EstadoPartida ejecutarFase(EstadoPartida estadoPartidaActual) {
		
		String nombreJugadorEnTurno = jugadorEnTurno.obtenerNombre();
		System.out.println("Turno del jugador " + nombreJugadorEnTurno);
		
		EstadoPartida estadoPartidaADevolver = estadoPartidaActual;
		
		if ((jugadorEnTurno.estaDerrotado()) || (jugadorEnTurno.obtenerJugadorEnemigo()).estaDerrotado()) {
			estadoPartidaADevolver = new EstadoPartidaTerminada();
		}
			
		return estadoPartidaADevolver;
	}

	
	@Override
	public Fase obtenerFaseSiguiente() {
		Fase faseADevolver = new FasePreparacion(this.jugadorEnTurno);
		return faseADevolver;
	}

	@Override
	public Jugador obtenerJugadorEnTurno() {
		return jugadorEnTurno;
	}

}
