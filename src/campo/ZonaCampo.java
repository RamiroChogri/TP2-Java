package campo;

import cartas.Destruible;

import java.util.LinkedList;

import cartas.Activable;
import cartas.CartaCampo;
import cartas.Colocable;

public class ZonaCampo extends Zona{

	private CartaCampo cartaCampo;
	private Boolean hayCartaCampo;
	
	public ZonaCampo() {
		this.cartaCampo = new CartaCampo();
		this.hayCartaCampo = false;
	}
	
	public void activarEfectoDeCampo(Campo campoPropio, Campo campoEnemigo) {
		this.cartaCampo.aplicarEfecto(campoPropio, campoEnemigo);
	}
	
	public void colocarCarta(Colocable cartaAColocar) {
		//MetodoForzadoPorZona
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
		int cantidadDeCartaCampo = (hayCartaCampo ? 1 : 0);
		return cantidadDeCartaCampo;
	}

	public LinkedList<Destruible> recolectarCartasDestruidas() {
		Destruible cartaCampoADestruir = null;
		if(this.cartaCampo.estaDestruida()) {
			cartaCampoADestruir = this.cartaCampo;
			this.cartaCampo = null;
		}

		LinkedList<Destruible> cartasDestruidas = new LinkedList<Destruible>();
		
		if(cartaCampoADestruir != null) {
		cartasDestruidas.add(cartaCampoADestruir);
		}
		
	    return cartasDestruidas;
	}

	public boolean hayEspacioDisponible() {
		return this.hayCartaCampo;
	}

	public void vaciar() {
		this.destruirCarta();
	}

	public void enviarCampoAlCementerio(Cementerio cementerio) {
		if(this.cartaCampo != null) {
		cementerio.agregarCarta(this.cartaCampo);
		}
	}

	public LinkedList<Activable> obtenerCartaColocada() {
		LinkedList<Activable> cartaColocada = new LinkedList<Activable>();
		
		if(this.hayCartaCampo) {
			cartaColocada.add(this.cartaCampo);
		}
		
		return cartaColocada;
	}
}
