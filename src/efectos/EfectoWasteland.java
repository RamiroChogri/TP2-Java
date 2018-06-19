package efectos;

import campo.Campo;
import cartas.*;

public class EfectoWasteland implements Efecto {
	
	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		Puntos puntosDeAtaqueExtra = new Puntos(200);
		Puntos puntosDeDefensaExtra = new Puntos(300);
		campoPropio.aumentarAtaqueMonstruosPorEfectoCampo(puntosDeAtaqueExtra);
		campoEnemigo.aumentarDefensaMonstruosPorEfectoCampo(puntosDeDefensaExtra);
	}
}
