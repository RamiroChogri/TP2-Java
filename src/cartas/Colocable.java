package cartas;

import campo.*;
import estadoCarta.EstadoCarta;
import jugador.Jugador;

public interface Colocable {
	
	public void colocarse(Jugador jugador, ZonaMonstruos monstruos ,ZonaMagicasYTrampas magicasYTrampas, ZonaCampo campo, Cementerio cementerio, EstadoCarta estadoAColocar);

}
