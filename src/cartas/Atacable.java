package cartas;

import modos.Modo;

public interface Atacable extends Destruible, Colocable{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void atacar(Atacable cartaAtacable);
	
	public void cambiarA(Modo modoRecibido);
	
	public int obtenerEstrellas();

	void recibirAtaque(CartaMonstruo cartaAtacante);

	public Puntos obtenerPuntosAtaque();
}
