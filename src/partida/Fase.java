package partida;

import jugador.Jugador;

public abstract class Fase {

	private Fase faseSiguiente;
	
	public abstract void setFaseSiguiente(Fase faseSiguienteAColocar); 
	
	public abstract Fase obtenerFaseSiguiente();
	
	public abstract EstadoPartida ejecutarFase(Jugador jugadorEnTurno, EstadoPartida estadoPartidaActual);
	
	public Jugador obtenerJugadorEnTurno(Jugador jugadorEnTurno) {
		return jugadorEnTurno;
	}
	
}
