public class CartaMonstruo {
	
	private Estado estado;
	
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		estado = new CartaEnMazo(); 
		
	}
	
	public void colocarEnPosicionAtaque() {
		estado = new CartaColocadaEnAtaque();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (estado.estaColocadaEnModoAtaque());
	}
	
}