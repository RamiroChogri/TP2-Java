package invocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;
import exceptions.NoHaySuficientesMonstruosParaSacrificarException;

public class ReglaDeMonstruoGrandeStrategy extends ReglaDeInvocacionStrategy {
	
	public ReglaDeMonstruoGrandeStrategy() {
		
	}

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		
		int cantidadDeMonstruosASacrificar = 2;
		
		if( !zonaMonstruos.tieneMonstruosColocados(cantidadDeMonstruosASacrificar) ) {
			throw new NoHaySuficientesMonstruosParaSacrificarException();
		}
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		monstruosSacrificados.addAll(zonaMonstruos.recolectarCartasDestruidas());
		
		zonaMonstruos.eliminarUltimaCartaMonstruoColocada();
		monstruosSacrificados.addAll( zonaMonstruos.recolectarCartasDestruidas() );
		
		zonaMonstruos.colocarCarta(cartaAColocar);
		
		return monstruosSacrificados;
	}

}
