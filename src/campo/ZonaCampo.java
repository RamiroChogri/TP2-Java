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
	
	public void colocarCarta(CartaCampo cartaAColocar) {
		this.cartaCampo = cartaAColocar;
		this.hayCartaCampo = true;
	}
	
	public void destruirCarta() {
		this.cartaCampo = null;
		this.hayCartaCampo = false;
	}
	
	public int obtenerCantidadDeCartas() {
		int cantidadDeCartaCampo = hayCartaCampo ? 1 : 0;
		return cantidadDeCartaCampo;
	}

}
