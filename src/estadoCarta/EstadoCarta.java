package estadoCarta;
public abstract class EstadoCarta {
	
	//La carta por defecto esta en el mazo y no deberia volver, por lo que
	//un metodo que coloque la carta en el mazo es absurdo
	

	public EstadoCartaEnMano colocarCartaEnMano() {
		return new EstadoCartaEnMano();
	}
	
	public EstadoCartaEnCementerio colocarCartaEnCementerio() {
		return new EstadoCartaEnCementerio();
	}
	
	public EstadoCartaEnModoAtaque colocarCartaEnModoAtaque() {
		return new EstadoCartaEnModoAtaque();
	}
	
	public EstadoCartaBocaArribaEnModoDefensa colocarCartaBocaArribaEnModoDefensa() {
		return new EstadoCartaBocaArribaEnModoDefensa();
	}
	
	public EstadoCartaBocaAbajoEnModoDefensa colocarCartaBocaAbajoEnModoDefensa() {
		return new EstadoCartaBocaAbajoEnModoDefensa();
	}
	
	public EstadoCartaBocaArriba colocarCartaBocaArriba() {
		return new EstadoCartaBocaArriba();
	}
	
	public EstadoCartaBocaAbajo colocarCartaBocaAbajo() {
		return new EstadoCartaBocaAbajo();
	}

	public boolean estaEnMazo() {
		return false;
	}
	
	public boolean estaEnMano() {
		return false;
	}
	
	public boolean estaEnCementerio() { 
		return false;
	}
	
	public boolean estaEnModoAtaque() {
		return false;
	}
	
	public boolean estaBocaArribaEnModoDefensa() {
		return false;
	}
	
	public boolean estaBocaAbajoEnModoDefensa() {
		return false;
	}
	
	public boolean estaBocaArriba() {
		return false;
	}
	
	public boolean estaBocaAbajo() {
		return false;
	}
	
}