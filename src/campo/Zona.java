package campo;

import java.util.LinkedList;

import cartas.Colocable;
import cartas.Destruible;

public  abstract class Zona {
	
	public abstract void colocarCarta(Colocable cartaAColocar);
	public abstract boolean hayEspacioDisponible();
	public abstract int obtenerCantidadDeCartas();
	public abstract LinkedList<Destruible> recolectarCartasDestruidas();
	public abstract void vaciar();
}
