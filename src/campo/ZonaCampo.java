package campo;
import carta.CartaCampo;

public class ZonaCampo {

	private CartaCampo cartaCampo;
	private Boolean hayCartaCampo;
	
	public ZonaCampo() {
		this.cartaCampo = new CartaCampo();
		this.hayCartaCampo = true;
	}
	
	public int obtenerCantidadDeCartas() {
		return 0;
	}

}
