package efectos;

import campo.Campo;

public class EfectoPotOfGreed implements Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.agregarAManoCartaDelMazo();
		campoPropio.agregarAManoCartaDelMazo();
	}

}
