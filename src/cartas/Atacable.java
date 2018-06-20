package cartas;

import modos.Modo;

public interface Atacable extends Destruible, Colocable,Daniable{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void cambiarA(Modo modoRecibido);
	
	public int obtenerEstrellas();

	public Puntos obtenerPuntosAtaque();
	
	public void atacar(Atacable cartaAtacable);

	public void atacar(Daniable jugador);
}
