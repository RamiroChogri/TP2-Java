package efectos;
import campo.*;
import cartas.Atacable;

public class EfectoAgujeroNegro extends Efecto {

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.vaciarZonaMonstruos();
		campoEnemigo.vaciarZonaMonstruos();
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
