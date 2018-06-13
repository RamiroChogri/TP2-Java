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
	
	//Esto deberia comprobarse en campo si la carta que ataca esta en modo ataque y que la
	//que reciba el ataque este en modo ataque o en modo defensa.
	
	public void atacar(CartaMonstruo otraCartaMonstruo) {
		
		if (otraCartaMonstruo.estaColocadaBocaAbajoEnModoDefensa()) {
			otraCartaMonstruo.colocarBocaArribaEnModoDefensa();
		}
		
		otraCartaMonstruo.recibirAtaque(this, this.puntosDeAtaque);
		
	}
	
	public void recibirAtaque(CartaMonstruo cartaEnemiga, int puntosDeAtaqueMonstruoEnemigo) {
		
		int danioAlJugador = 0;
		
		danioAlJugador = estado.recibirAtaque(puntosDeAtaqueMonstruoEnemigo);
		
		if (danioAlJugador >= 0) {
			this.destruirCarta(danioAlJugador);
		}
		
		if (estado.estaEnModoAtaque() && (danioAlJugador <= 0)) {
			cartaEnemiga.destruirCarta(danioAlJugador);
		}
	}
	
	
	public void colocarEnModoAtaque() {
		this.estado = new EstadoCartaEnModoAtaque(this.puntosDeAtaque);
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
	
	public void destruirCarta(int danioAlJugador) {
		this.estado = new EstadoCartaEnCementerio(danioAlJugador);
	}
	
}