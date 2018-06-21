package efectos;

import campo.Campo;
import cartas.Atacable;
import modos.ModoNegacionDeAtaque;

public class EfectoCilindroMagico extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		
		
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
		ModoNegacionDeAtaque modoNegacion = new ModoNegacionDeAtaque();
		
		campoPropio.hacerDanioAlJugador( atacante.obtenerPuntosAtaque() );
		atacado.cambiarA( modoNegacion );
	}

}