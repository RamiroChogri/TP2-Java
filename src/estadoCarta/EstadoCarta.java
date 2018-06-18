package estadoCarta;
public abstract class EstadoCarta {
	
	//La carta por defecto esta en el mazo y no deberia volver, por lo que
	//un metodo que coloque la carta en el mazo es absurdo
	

	public EstadoCartaDestruida destruirCarta() {
		return new EstadoCartaDestruida();
	}
	
	public EstadoCartaColocadaBocaArriba colocarCartaBocaArriba() {
		return new EstadoCartaColocadaBocaArriba();
	}
	
	public EstadoCartaColocadaBocaAbajo colocarCartaBocaAbajo() {
		return new EstadoCartaColocadaBocaAbajo();
	}

	public boolean estaNoJugada() {
		return false;
	}
	
	public boolean estaBocaArriba() {
		return false;
	}
	
	public boolean estaBocaAbajo() {
		return false;
	}
	
	public boolean estaDestruida() {
		return false;
	}
	
	public int obtenerPuntosDeDanio() {
	
		return 0;
	}

	public int recibirAtaque(int puntosDeAtaqueMonstruoEnemigo) {
		return 0;
	}	

}