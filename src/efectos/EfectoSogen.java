package efectos;

import campo.Campo;
import cartas.Atacable;
import cartas.Puntos;
import view.CajaConsola;

public class EfectoSogen extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		Puntos puntosDeAtaqueExtra = new Puntos(200);
		Puntos puntosDeDefensaExtra = new Puntos(500);
		campoPropio.aumentarDefensaMonstruosPorEfectoCampo(puntosDeDefensaExtra);
		campoEnemigo.aumentarAtaqueMonstruosPorEfectoCampo(puntosDeAtaqueExtra);
		CajaConsola.agregarMensaje("Se aplica efecto Sogen");

	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
