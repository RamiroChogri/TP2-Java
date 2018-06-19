package InvocacionStrategy;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;

public class ReglaDeMonstruoMedianoStrategy extends ReglaDeInvocacionStrategy {
	
	public ReglaDeMonstruoMedianoStrategy() {
		
	}
	

	@Override
	public void colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		
		int cantidadDeMonstruosASacrificar = 1;
		
		if(!zonaMonstruos.tieneMonstruosColocados(cantidadDeMonstruosASacrificar)) {
			// lanzar Excepcion de que no hay ni 1 monstruo para sacrificar
		}
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		zonaMonstruos.colocarCarta(cartaAColocar);
	}

}
