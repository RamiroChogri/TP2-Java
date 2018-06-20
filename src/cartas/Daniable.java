package cartas;

public interface Daniable {

	void recibirAtaque(CartaMonstruo cartaAtacante);
	
	public void atacar(Atacable cartaAtacable);

	public void atacar(Daniable jugador);
}
