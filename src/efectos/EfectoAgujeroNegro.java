package efectos;
import campo.*;

public class EfectoAgujeroNegro implements Efecto {

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.vaciarZonaMonstruos();
		campoEnemigo.vaciarZonaMonstruos();
	}
	
}
