package efectos;

import campo.Campo;
import cartas.Atacable;
import modos.Modo;
import modos.ModoNegacionDeAtaque;

public class EfectoCilindroMagico extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		
		
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
		Modo modoAnterior = atacado.obtenerModo();
		ModoNegacionDeAtaque modoNegacion = new ModoNegacionDeAtaque( modoAnterior );
		
		campoPropio.hacerDanioAlJugador( atacante.obtenerPuntosAtaque() );
		atacado.cambiarA( modoNegacion );
	}

}