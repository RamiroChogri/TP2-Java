package cartas;

import estadoCarta.EstadoCarta;
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
	
	public boolean estaColocadaBocaArriba();
	
	public boolean estaColocadaBocaAbajo();
	
	public boolean estaEnModoAtaque();
	
	public boolean estaEnModoDefensa();
	
	public void ponerEn(EstadoCarta estado);

	public void aumentarAtaqueEn(Puntos puntosAumentar);

	public Modo obtenerModo();

	public void voltear();
	
	public void colocarBocaArriba();

	public void aumentarDefensaEn(Puntos puntosDeDefensaExtra);

	public void eliminarModificadorDeAtaque();

	public void eliminarModificadorDeDefensa();

}
