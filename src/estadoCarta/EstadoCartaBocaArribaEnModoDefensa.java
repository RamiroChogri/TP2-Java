package estadoCarta;

public class EstadoCartaBocaArribaEnModoDefensa extends EstadoCarta {
	
	public int recibirAtaque(int puntosAtaqueEnemigo) {
		return 0;
	}
	
	public EstadoCartaBocaArribaEnModoDefensa colocarCartaBocaArribaEnModoDefensa() {
		return this;
	}

	public boolean estaBocaArribaEnModoDefensa() {
		return true;
	}
}
