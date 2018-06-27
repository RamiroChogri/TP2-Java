package partida;

import jugador.Jugador;

public class EstadoPartidaTerminada extends EstadoPartida {

	
	public boolean continuaLaPartida() {

		return false;
	}

	public EstadoPartida terminarPartida() {
		return this;
	}

	
	public EstadoPartida ganoAlgunJugador(Jugador jugadorEnTurno, Jugador jugadorEnemigo) {

		return this;
	}

}
