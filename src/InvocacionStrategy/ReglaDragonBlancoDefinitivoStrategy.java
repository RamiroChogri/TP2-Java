package InvocacionStrategy;

import java.util.LinkedList;

import campo.ZonaMonstruos;
import cartas.CartaMonstruo;
import cartas.Destruible;

public class ReglaDragonBlancoDefinitivoStrategy extends ReglaDeInvocacionStrategy {

	@Override
	public LinkedList<Destruible> colocarCarta(ZonaMonstruos zonaMonstruos, CartaMonstruo cartaAColocar) {
		
		String nombreMonstruoASacrificar = "Dragon Blanco De Ojos Azules";
		if(!zonaMonstruos.tieneElMonstruoTantasVeces( nombreMonstruoASacrificar , 3) ) {
			//tirar excepcion
		}
		LinkedList<Destruible> monstruosSacrificados = new LinkedList<Destruible>();
		
		zonaMonstruos.sacrificarA(nombreMonstruoASacrificar);
		monstruosSacrificados.addAll(zonaMonstruos.recolectarCartasDestruidas());
		
		zonaMonstruos.sacrificarA(nombreMonstruoASacrificar);
		monstruosSacrificados.addAll(zonaMonstruos.recolectarCartasDestruidas());
		
		zonaMonstruos.sacrificarA(nombreMonstruoASacrificar);
		monstruosSacrificados.addAll(zonaMonstruos.recolectarCartasDestruidas());
		
		zonaMonstruos.colocarCarta(cartaAColocar);
		
		return monstruosSacrificados;
		
	}

}
