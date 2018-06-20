package cartas;

import jugador.Jugador;
import modos.Modo;

public interface Atacable extends Destruible, Colocable,Daniable{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void cambiarA(Modo modoRecibido);
	
	public int obtenerEstrellas();

	public Puntos obtenerPuntosAtaque();

	public Puntos obtenerPuntosDefensa();
	
	public void atacar(Atacable cartaAtacable);

	public void atacar(Jugador jugador);

	public boolean tieneMasPuntosDeAtaqueQue(Atacable cartaAtacada);

	public int diferenciaDeAtaqueCon(Atacable cartaAtacada);
	
	public void destruirCarta(int danio);

}
