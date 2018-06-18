package cartas;

import estrategias.Estrategia;
import modos.Modo;

public interface Colocable {
	public void colocar(Estrategia estrategia, Modo modo);
}
