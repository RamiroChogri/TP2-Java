package cartas;

import campo.Campo;

public interface Activable extends Destruible, Colocable{

	public void aplicarEfecto(Campo campo, Campo campoEnemigo);
	
}
