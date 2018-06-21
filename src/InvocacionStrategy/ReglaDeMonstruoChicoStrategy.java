package InvocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;
import exceptions.NoHayLugarVacioException;

public class ReglaDeMonstruoChicoStrategy extends ReglaDeInvocacionStrategy {
	
	
	public ReglaDeMonstruoChicoStrategy() {
		
	}

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		if(!zonaMonstruos.hayEspacioDisponible()) {
			throw new NoHayLugarVacioException();
		}
		zonaMonstruos.colocarCarta(cartaAColocar);
		
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		return monstruosSacrificados;

	}

}
