package InvocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;

public class ReglaDeMonstruoGrandeStrategy extends ReglaDeInvocacionStrategy {
	
	public ReglaDeMonstruoGrandeStrategy() {
		
	}

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		
		int cantidadDeMonstruosASacrificar = 2;
		
		if( !zonaMonstruos.tieneMonstruosColocados(cantidadDeMonstruosASacrificar) ) {
			//lanzar excepcion de que no hay 2 monstruos para sacrificar
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
