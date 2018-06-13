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
	
	public void colocarBocaArribaEnModoDefensa() {
		this.estado = new EstadoCartaBocaArribaEnModoDefensa();
	}
	
	public void colocarBocaAbajoEnModoDefensa() {
		this.estado = new EstadoCartaBocaAbajoEnModoDefensa();
	}
	
	public boolean estaColocadaEnModoAtaque() {
		return (this.estado.estaEnModoAtaque());
	}
	
	public boolean estaColocadaBocaArribaEnModoDefensa() {
		return ( this.estado.estaBocaArribaEnModoDefensa() );
	}
	
	public boolean estaColocadaBocaAbajoEnModoDefensa() {
		return (this.estado.estaBocaAbajoEnModoDefensa() );
	}

	public Boolean estaDestruida() {
		return this.estado.estaEnCementerio();
	}
	
	public void destruirCarta() {
		this.estado = new EstadoCartaEnCementerio();
	}
	
}