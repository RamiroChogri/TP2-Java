package efectos;
import campo.*;
import cartas.Atacable;

public class EfectoNulo implements Efecto {

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		//No hace nada
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
