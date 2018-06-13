package campo;
import carta.CartaCampo;

public class ZonaCampo {

	private CartaCampo cartaCampo;
	private Boolean hayCartaCampo;
	
	public ZonaCampo() {
		this.cartaCampo = new CartaCampo();
		this.hayCartaCampo = false;
	}
	
	public void activarEfectoDeCampo() {
		//this.cartaCampo.activarEfecto();
	}
	
	public void colocarCartaCampo(CartaCampo cartaAColocar) {
		this.cartaCampo = cartaAColocar;
	}
	
	public int obtenerCantidadDeCartas() {
		int cantidadDeCartaCampo = hayCartaCampo ? 1 : 0;
		return cantidadDeCartaCampo;
	}

}
