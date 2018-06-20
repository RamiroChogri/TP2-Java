package cartas;

import campo.*;
import estadoCarta.EstadoCarta;

public interface Colocable {
	
	public void colocarse(ZonaMonstruos monstruos ,ZonaMagicasYTrampas magicasYTrampas, ZonaCampo campo, Cementerio cementerio, EstadoCarta estadoAColocar);

}
