package efectos;

import campo.Campo;
import cartas.Atacable;
import view.CajaConsola;

public class EfectoPotOfGreed extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.agregarAManoCartaDelMazo();
		campoPropio.agregarAManoCartaDelMazo();
		CajaConsola.agregarMensaje("Se aplica efecto Olla De La Codicia");

	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}

}
