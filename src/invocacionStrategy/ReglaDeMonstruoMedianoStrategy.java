package invocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;
import exceptions.NoHayMonstruoParaSacrificarException;

public class ReglaDeMonstruoMedianoStrategy extends ReglaDeInvocacionStrategy {
	
	public ReglaDeMonstruoMedianoStrategy() {
		
	}
	

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {

		int cantidadDeMonstruosASacrificar = 1;
		
		if(!zonaMonstruos.tieneMonstruosColocados(cantidadDeMonstruosASacrificar)) {
			throw new NoHayMonstruoParaSacrificarException();
		}
		LinkedList<Destruible> monstruoSacrificado = new LinkedList<Destruible>();
		
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		monstruoSacrificado = zonaMonstruos.recolectarCartasDestruidas();
		
		zonaMonstruos.colocarCarta(cartaAColocar);
		
		return monstruoSacrificado;
	}

}
