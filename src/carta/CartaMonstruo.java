package carta;
import estadoCarta.*;
public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaEnMazo(); 
		this.puntosDeAtaque = 1000;
		this.puntosDeDefensa = 700;
		
	}
	
	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar) {
		this.estado = new EstadoCartaEnMazo();
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
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

	public boolean estaDestruida() {
		return this.estado.estaEnCementerio();
	}
	
	public void destruirCarta() {
		this.estado = new EstadoCartaEnCementerio();
	}
	
}