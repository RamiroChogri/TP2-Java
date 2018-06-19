package InvocacionStrategy;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;

public class ReglaDeMonstruoGrandeStrategy extends ReglaDeInvocacionStrategy {
	
	public ReglaDeMonstruoGrandeStrategy() {
		
	}

	@Override
	public void colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		
		int cantidadDeMonstruosASacrificar = 2;
		
		if( !zonaMonstruos.tieneMonstruosColocados(cantidadDeMonstruosASacrificar) ) {
			//lanzar excepcion de que no hay 2 monstruos para sacrificar
		}
		
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		zonaMonstruos.colocarCarta(cartaAColocar);	
	}

}
