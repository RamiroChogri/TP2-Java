package cartas;

import campo.Campo;

public interface Activable extends Destruible, Colocable{

	public void aplicarEfecto(Campo campo, Campo campoEnemigo);

	public boolean esDeTrampa();

	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado);
	
}
