package efectos;

import campo.Campo;
import cartas.Atacable;
import cartas.Puntos;
import view.CajaConsola;

public class EfectoRefuerzos extends Efecto {

	private Puntos puntosAumentar;
	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		
		//Sube 500 puntos de ataque al monstruo que me estan atacando hasta el final del turno.
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
		this.puntosAumentar = new Puntos( 500 );
		atacado.aumentarAtaqueEn( puntosAumentar );
	}

}