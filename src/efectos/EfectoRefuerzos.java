package efectos;

import campo.Campo;
import cartas.Atacable;

public class EfectoRefuerzos extends Efecto {

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		
		//Sube 500 puntos de ataque al monstruo que me estan atacando hasta el final del turno.
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}

}