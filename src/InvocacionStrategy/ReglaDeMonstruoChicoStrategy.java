package InvocacionStrategy;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;

public class ReglaDeMonstruoChicoStrategy extends ReglaDeInvocacionStrategy {
	
	
	public ReglaDeMonstruoChicoStrategy() {
		
	}

	@Override
	public void colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		if(!zonaMonstruos.hayEspacioDisponible()) {
			//lanzar excepcion de que no hay espacio para invocar un monstruo
		}
		zonaMonstruos.colocarCarta(cartaAColocar);

	}

}
