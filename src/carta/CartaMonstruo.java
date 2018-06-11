package carta;
public class CartaMonstruo {
	
	private Estado estado;
	
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		estado = new CartaEnMazo(); 
		
	}
	
	public void colocarEnModoAtaque() {
		estado = new CartaColocadaEnModoAtaque();
	}
	
	public void colocarEnModoDefensaBocaArriba() {
		estado = new CartaColocadaEnModoDefensaBocaArriba();
	}
	
	public void colocarEnModoDefensaBocaAbajo() {
		estado = new CartaColocadaEnModoDefensaBocaAbajo();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (estado.estaColocadaEnModoAtaque());
	}
	
}