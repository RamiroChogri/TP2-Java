package efectos;
import campo.*;
import cartas.Atacable;

public interface Efecto {

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo);

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado);
	
}
