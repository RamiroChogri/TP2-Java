package carta;

import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaBocaAbajo;
import estadoCarta.EstadoCartaBocaArriba;
import estadoCarta.EstadoCartaEnMazo;

public class CartaMagica implements Utilizable{
	
	private EstadoCarta estado;
	
	public CartaMagica() {
		estado = new EstadoCartaEnMazo();
	}
	
	public void destruirCarta() {
		
	}

	public void colocarBocaAbajo() {
	
		this.estado = new EstadoCartaBocaAbajo();
		
	}

	public void colocarBocaArriba() {
		
		this.estado = new EstadoCartaBocaArriba();
		
	}

	public boolean estaColocadaBocaAbajo() {
		return ( this.estado.estaBocaAbajo() );
	}

	public boolean estaColocadaBocaArriba() {
		return ( this.estado.estaBocaArriba() );
	}
	
}