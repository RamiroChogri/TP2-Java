package efectos;
import campo.*;
import cartas.Atacable;

public abstract class Efecto {

	public abstract void aplicarEfecto(Campo campoPropio, Campo campoEnemigo);

	public abstract void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado);
	
}
