package efectos;

import campo.Campo;

public class EfectoPotOfGreed implements Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.agregarCartaEnMano(campoPropio.levantarCartaDelMazo());
		campoPropio.agregarCartaEnMano(campoPropio.levantarCartaDelMazo());
	}

}
