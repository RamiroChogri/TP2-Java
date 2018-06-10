public class CartaMonstruo {
	
	private Estado estado;
	
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		estado = new CartaEnMazo(); 
		
	}
	
	public void colocarEnPosicionAtaque() {
		estado = new CartaColocadaEnAtaque();
	}
	
	public void colocarEnPosicionDefensaBocaArriba() {
		estado = new CartaColocadaEnDefensaBocaArriba();
	}
	
	public void colocarEnPosicionDefensaBocaAbajo() {
		estado = new CartaColocadaEnDefensaBocaAbajo();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (estado.estaColocadaEnModoAtaque());
	}
	
}