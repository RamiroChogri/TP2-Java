package estadoCarta;

public class EstadoCartaEnCementerio extends EstadoCarta {
	
	int diferenciaDeDanio;
	
	public EstadoCartaEnCementerio() {
		diferenciaDeDanio = 0;
	}
	
	public EstadoCartaEnCementerio(int danioAlJugador) {
		diferenciaDeDanio = danioAlJugador;
	}
	
	public int obtenerDiferenciaDeDanio() {
		return diferenciaDeDanio;
	}
	
	public EstadoCartaEnCementerio colocarCartaEnCementerio() {
		return this;
	}

	public boolean estaEnCementerio() { 
		return true;
	}

}
