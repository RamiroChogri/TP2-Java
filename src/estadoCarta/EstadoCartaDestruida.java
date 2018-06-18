package estadoCarta;

public class EstadoCartaDestruida extends EstadoCarta {
	
	int diferenciaDeDanio;
	
	public EstadoCartaDestruida() {
		diferenciaDeDanio = 0;
	}
	
	public EstadoCartaDestruida(int danioAlJugador) {
		diferenciaDeDanio = danioAlJugador;
	}
	
	public int obtenerDiferenciaDeDanio() {
		return diferenciaDeDanio;
	}
	
	public EstadoCartaDestruida destruirCarta() {
		return this;
	}

	public boolean estaDestruida() { 
		return true;
	}
	
	public int obtenerPuntosDeDanio() {
		
		return diferenciaDeDanio;
	}

}
