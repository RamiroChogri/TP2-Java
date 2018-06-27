package partida;

import jugador.Jugador;

public abstract class EstadoPartida {

	public abstract boolean continuaLaPartida();

	public abstract EstadoPartida terminarPartida();
	
	public abstract EstadoPartida ganoAlgunJugador(Jugador jugadorEnTurno, Jugador jugadorEnemigo);
	
}
