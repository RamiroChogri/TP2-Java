package partida;

import jugador.Jugador;

public class FaseInicial extends Fase {

	@Override
	public void ejecutarFase(Jugador jugadorEnTurno) {
		jugadorEnTurno.tomarCartaDelMazo();
	}

}
