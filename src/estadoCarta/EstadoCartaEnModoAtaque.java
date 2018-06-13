package estadoCarta;

public class EstadoCartaEnModoAtaque extends EstadoCarta {

	private int puntosDeAtaque;
	
	public EstadoCartaEnModoAtaque(int puntosDeAtaqueAColocar) {
		puntosDeAtaque = puntosDeAtaqueAColocar;
	}
	
	public int recibirAtaque(int puntosAtaqueEnemigo) {
		int diferenciaDanio = puntosAtaqueEnemigo - puntosDeAtaque;
		return diferenciaDanio;
	}
	
	public EstadoCartaEnModoAtaque colocarCartaEnModoAtaque() {
		return this;
	}

	public boolean estaEnModoAtaque() {
		return true;
	}
	
}
