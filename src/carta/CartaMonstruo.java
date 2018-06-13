package carta;
import estadoCarta.*;
public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaEnMazo(); 
	}
	
	public void colocarEnModoAtaque() {
		this.estado = new EstadoCartaEnModoAtaque();
	}
	
	public void colocarEnModoDefensaBocaArriba() {
		this.estado = new EstadoCartaBocaArribaEnModoDefensa();
	}
	
	public void colocarEnModoDefensaBocaAbajo() {
		this.estado = new EstadoCartaBocaAbajoEnModoDefensa();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (this.estado.estaEnModoAtaque());
	}

	public void destruirCarta() {
		
	}
	
}