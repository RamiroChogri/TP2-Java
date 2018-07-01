package partida;

import jugador.Jugador;

public abstract class Fase {

	private Fase faseSiguiente;
	private Jugador jugadorEnTurno;
	
	public boolean esFasePreparacion() {
		return false;
	}
	
	public boolean esFaseAtaqueYTrampas() {
		return false;
	}
	
	public boolean esFaseFinal() {
		return false;
	}
	
	public abstract String getNombreFase();
	
	public abstract Fase obtenerFaseSiguiente();
	
	public abstract EstadoPartida ejecutarFase(EstadoPartida estadoPartidaActual);
	
	public abstract Jugador obtenerJugadorEnTurno();
	
	
}
