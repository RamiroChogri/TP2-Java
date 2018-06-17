package cartas;

public interface Atacable extends Destruible{

	public int obtenerDanioAlHaberSidoDestruida();
	
	public void atacar(Atacable cartaAtacable);
	
	public void atacar(CartaMonstruo cartaMonstruo);
	
	public void recibirAtaque(Atacable atacable, int puntosAtaqueAtacable);
	
	public void recibirAtaque(CartaMonstruo cartaMonstruo, int puntosAtaqueAtacable);
}
