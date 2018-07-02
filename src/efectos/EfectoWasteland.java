package efectos;

import campo.Campo;
import cartas.*;
import view.CajaConsola;

public class EfectoWasteland extends Efecto {
	
	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		Puntos puntosDeAtaqueExtra = new Puntos(200);
		Puntos puntosDeDefensaExtra = new Puntos(300);
		campoPropio.aumentarAtaqueMonstruosPorEfectoCampo(puntosDeAtaqueExtra);
		campoEnemigo.aumentarDefensaMonstruosPorEfectoCampo(puntosDeDefensaExtra);
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
}
