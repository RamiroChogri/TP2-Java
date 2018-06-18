package cartas;

import modos.Modo;

public interface Atacable extends Destruible, Colocable{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void atacar(Atacable cartaAtacable);
	
	public void atacar(CartaMonstruo cartaMonstruo);
	
	public void recibirAtaque(Atacable atacable, int puntosAtaqueAtacable);
	
	public void recibirAtaque(CartaMonstruo cartaMonstruo, Puntos puntosAtaqueDeMonstruoAtacante);
	
	public void cambiarA(Modo modoRecibido);
	
	public int obtenerEstrellas();
}
