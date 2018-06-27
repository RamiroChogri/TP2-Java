package partida;

import jugador.Jugador;

public class FaseInicial extends Fase {

	private Fase faseSiguiente;
	
	public FaseInicial() {
		this.faseSiguiente = null;
	}
	
	@Override
	public EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaActual) {
		
		String nombreJugadorEnTurno = jugadorEnTurno.obtenerNombre();
		System.out.println("Turno del jugador " + nombreJugadorEnTurno);
		
		jugadorEnTurno.tomarCartaDelMazo();
		EstadoPartida estadoPartidaADevolver = estadoPartidaActual;
		
		if ((jugadorEnTurno.estaDerrotado()) || (jugadorEnTurno.obtenerJugadorEnemigo()).estaDerrotado()) {
			estadoPartidaADevolver = new EstadoPartidaTerminada();
		}
			
		return estadoPartidaADevolver;
	}

	@Override
	public void setFaseSiguiente(Fase faseSiguienteAColocar) {
		this.faseSiguiente = faseSiguienteAColocar;
	}

	@Override
	public Fase obtenerFaseSiguiente() {
		return this.faseSiguiente;
	}

	@Override
	public Jugador obtenerJugadorEnTurno(Jugador jugadorEnTurno) {
		return jugadorEnTurno.obtenerJugadorEnemigo();
	}

}
