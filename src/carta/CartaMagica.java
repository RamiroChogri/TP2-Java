package carta;

import estadoCarta.EstadoCarta;
import estadoCarta.EstadoCartaBocaAbajo;
import estadoCarta.EstadoCartaBocaArriba;
import estadoCarta.EstadoCartaEnCementerio;
import estadoCarta.EstadoCartaEnMazo;
import campo.Campo;
import efectos.*;

public class CartaMagica implements Utilizable{
	
	private EstadoCarta estado;
	private Efecto efecto;
	
	
	public CartaMagica() {
		
		this.estado = new EstadoCartaEnMazo();
		Efecto efectoNulo = new EfectoNulo();
		this.efecto = efectoNulo;
	}
	
	public CartaMagica(Efecto efectoAColocar) {
		
		this.estado = new EstadoCartaEnMazo();
		this.efecto = efectoAColocar;
	
	}
	
	public void destruirCarta() {
	
		this.estado = new EstadoCartaEnCementerio();

	}

	public void colocarBocaAbajo() {
	
		this.estado = new EstadoCartaBocaAbajo();
		
	}

	public Efecto colocarBocaArriba() {
		
		this.estado = new EstadoCartaBocaArriba();
		return this.efecto;
		
	}

	public boolean estaColocadaBocaAbajo() {
		return ( this.estado.estaBocaAbajo() );
	}

	public boolean estaColocadaBocaArriba() {
		return ( this.estado.estaBocaArriba() );
	}
	
	public boolean estaDestruida() {
		return this.estado.estaEnCementerio();
	}
	
	public Efecto obtenerEfecto() {
		return this.efecto;
	}


	public void aplicarEfecto(Campo campo, Campo campoEnemigo) {
		
		this.efecto.aplicarEfecto(campo, campoEnemigo);
		this.destruirCarta();
		campo.enviarCartasDestruidasAlCementerio();
		campoEnemigo.enviarCartasDestruidasAlCementerio();
	}

}