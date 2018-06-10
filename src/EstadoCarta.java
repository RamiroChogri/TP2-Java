public interface EstadoCarta {
	
	public EstadoCarta colocarCartaEnMano();
	
	public EstadoCarta colocarCartaEnCementerio();
	
	public EstadoCarta colocarCartaEnModoAtaque();
	
	public EstadoCarta colocarCartaBocaArribaEnModoDefensa();
	
	public EstadoCarta colocarCartaBocaAbajoEnModoDefensa();
	
	public EstadoCarta colocarCartaBocaArriba();
	
	public EstadoCarta colocarCartaBocaAbajo();

	public boolean estaEnMazo();
	
	public boolean estaEnMano();
	
	public boolean estaEnCementerio();
	
	public boolean estaEnAtaque();
	
	public boolean estaEnDefensaBocaArriba();
	
	public boolean estaEnDefensaBocaAbajo();
	
	public boolean estaBocaArriba();
	
	public boolean estaBocaAbajo();
	
}