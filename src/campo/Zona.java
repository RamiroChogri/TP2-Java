package campo;

import java.util.LinkedList;
import cartas.Destruible;

public  abstract class Zona {
	
	public abstract void colocarCarta(Destruible cartaMonstruoAColocar);
	public abstract boolean hayEspacioDisponible();
	public abstract int obtenerCantidadDeCartas();
	public abstract LinkedList<Destruible> recolectarCartasDestruidas();
	public abstract void vaciar();
}
