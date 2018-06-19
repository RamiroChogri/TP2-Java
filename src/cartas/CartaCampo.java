package cartas;

import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import estadoCarta.EstadoCarta;

public class CartaCampo extends CartaMagica {
	
	public void colocarse(ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas, ZonaCampo zonaCampo, EstadoCarta estadoAColocar) {
		this.estado = estadoAColocar;
		zonaCampo.colocarCarta(this);
	}
}
