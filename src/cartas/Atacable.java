package cartas;

public interface Atacable extends Carta{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void atacar(Atacable cartaAtacable);
	
	public void atacar(CartaMonstruo cartaMonstruo);
	
	public void recibirAtaque(Atacable atacable, int puntosAtaqueAtacable);
	
	public void recibirAtaque(CartaMonstruo cartaMonstruo, int puntosAtaqueAtacable);
}
