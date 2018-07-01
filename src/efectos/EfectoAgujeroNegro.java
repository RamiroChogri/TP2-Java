package efectos;
import campo.*;
import cartas.Atacable;
import view.CajaConsola;

public class EfectoAgujeroNegro extends Efecto {

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo) {
		campoPropio.vaciarZonaMonstruos();
		campoEnemigo.vaciarZonaMonstruos();
		CajaConsola.agregarMensaje("Se aplica efecto Agujero Negro");
	}

	@Override
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		// TODO Auto-generated method stub
		
	}
	
}
