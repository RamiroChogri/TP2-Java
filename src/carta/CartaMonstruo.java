package carta;
import estadoCarta.*;
public class CartaMonstruo implements Atacable{
	
	private EstadoCarta estado;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	private int estrellas;
	private String nombre;
	
	
	public CartaMonstruo() {
		
		//por defecto en el mazo
		this.estado = new EstadoCartaEnMazo(); 
		this.puntosDeAtaque = 1000;
		this.puntosDeDefensa = 700;
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
		
	}
	
	public CartaMonstruo(int puntosDeAtaqueAColocar, int puntosDeDefensaAColocar) {
		this.estado = new EstadoCartaEnMazo();
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
		this.estrellas = 3;
		this.nombre = "MonstruoGenericoACME";
	}
	
	public CartaMonstruo(int ataqueAColocar, int defensaAColocar, int estrellasAColocar) {
		this.puntosDeAtaque = ataqueAColocar;
		this.puntosDeDefensa = defensaAColocar;
		this.estrellas = estrellasAColocar;
		this.nombre = "MonstruoGenericoACME";
	}
	
	public CartaMonstruo(int ataqueAColocar, int defensaAColocar, int estrellasAColocar, String nombreAColocar) {
		this.puntosDeAtaque = ataqueAColocar;
		this.puntosDeDefensa = defensaAColocar;
		this.estrellas = estrellasAColocar;
		this.nombre = nombreAColocar;
	}
	
	//Deberia comprobarse en campo si la carta que ataca esta en modo ataque.
	
	public void atacar(CartaMonstruo otraCartaMonstruo) {
		
		if (otraCartaMonstruo.estaColocadaBocaAbajoEnModoDefensa()) {
			otraCartaMonstruo.colocarBocaArribaEnModoDefensa();
		}
		
		otraCartaMonstruo.recibirAtaque(this, this.puntosDeAtaque);
		
	}
	
	public void recibirAtaque(CartaMonstruo cartaEnemiga, int puntosDeAtaqueMonstruoEnemigo) {
		
		int danioAlJugador = 0;
		
		danioAlJugador = this.estado.recibirAtaque(puntosDeAtaqueMonstruoEnemigo);
		
		if (this.estado.estaEnModoAtaque() && (danioAlJugador <= 0)) {
			cartaEnemiga.destruirCarta(Math.abs(danioAlJugador));	
		}
		
		if ((danioAlJugador >= 0) && ((this.puntosDeDefensa < puntosDeAtaqueMonstruoEnemigo) || (this.estado.estaEnModoAtaque()))) {
			this.destruirCarta(danioAlJugador);
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
	
	public int obtenerEstrellas() {
		return this.estrellas;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}

	@Override
	public int obtenerDanioAlHaberSidoDestruida() {

		return estado.obtenerPuntosDeDanio();

	}
 	
}