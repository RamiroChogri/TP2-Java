package InvocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;

public class ReglaDeMonstruoChicoStrategy extends ReglaDeInvocacionStrategy {
	
	
	public ReglaDeMonstruoChicoStrategy() {
		
	}

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		if(!zonaMonstruos.hayEspacioDisponible()) {
			//lanzar excepcion de que no hay espacio para invocar un monstruo
		}
		zonaMonstruos.colocarCarta(cartaAColocar);
		
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		return monstruosSacrificados;

	}

}
