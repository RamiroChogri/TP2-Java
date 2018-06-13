package estadoCarta;

public class EstadoCartaEnCementerio extends EstadoCarta {
	
	int diferenciaDeDaño;
	
	public EstadoCartaEnCementerio() {
		diferenciaDeDaño = 0;
	}
	
	public EstadoCartaEnCementerio(int dañoAlJugador) {
		diferenciaDeDaño = dañoAlJugador;
	}
	
	public int obtenerDiferenciaDeDaño() {
		return diferenciaDeDaño;
	}
	
	public EstadoCartaEnCementerio colocarCartaEnCementerio() {
		return this;
	}

	public boolean estaEnCementerio() { 
		return true;
	}

}
