package efectos;

import campo.Campo;
import cartas.Atacable;

public class EfectoPotOfGreed implements Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.agregarAManoCartaDelMazo();
		campoPropio.agregarAManoCartaDelMazo();
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}

}
