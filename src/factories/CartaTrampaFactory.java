package factories;

import cartas.CartaTrampa;
import efectos.*;

public class CartaTrampaFactory {

	public CartaTrampaFactory() {
		
	}
	
	public CartaTrampa crearCilindroMagico() {
		
		EfectoCilindroMagico efecto = new EfectoCilindroMagico();
		
		CartaTrampa cilindroMagico = new CartaTrampa(efecto);
		
		cilindroMagico.setNombre("Cilindro Magico");
		
		return cilindroMagico;
	}
	
	public CartaTrampa crearRefuerzos() {
		
		EfectoRefuerzos efecto = new EfectoRefuerzos();
		
		CartaTrampa refuerzos = new CartaTrampa(efecto);
		
		refuerzos.setNombre("Refuerzos");
		
		return refuerzos;
	}
}
