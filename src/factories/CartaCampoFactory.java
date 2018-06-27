package factories;

import cartas.CartaCampo;
import efectos.EfectoSogen;
import efectos.EfectoWasteland;

public class CartaCampoFactory {

	public CartaCampoFactory() {
		
	}
	
	public CartaCampo crearWasteland() {
		
		EfectoWasteland efecto = new EfectoWasteland();
		CartaCampo wasteland = new CartaCampo(efecto);
		
		wasteland.setNombre("Wasteland");
		
		wasteland.setNombreDeLaImagen("wasteland.png");
		
		return wasteland;
	}
	
	public CartaCampo crearSogen() {
		EfectoSogen efecto = new EfectoSogen();
		
		CartaCampo sogen = new CartaCampo(efecto);
		
		sogen.setNombre("Sogen");
		
		sogen.setNombreDeLaImagen("sogen.jpg");
		
		return sogen;
	}
}
