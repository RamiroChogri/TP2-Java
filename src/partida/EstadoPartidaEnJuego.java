package partida;

import jugador.Jugador;

public class EstadoPartidaEnJuego extends EstadoPartida {

	public boolean continuaLaPartida() {

		return true;
	}

	
	public EstadoPartida terminarPartida() {
		
		return new EstadoPartidaTerminada();
	}

	public EstadoPartida ganoAlgunJugador(Jugador jugadorEnTurno , Jugador jugadorEnemigo) {
		EstadoPartida estadoActual = new EstadoPartidaEnJuego();
		
		if( jugadorEnTurno.estaDerrotado() || jugadorEnemigo.estaDerrotado() ) {
			estadoActual = new EstadoPartidaTerminada();
		}
		
		return estadoActual;
		
	}


}
