package jugador;
import campo.*;
import carta.Carta;
import carta.CartaMonstruo;
public class Jugador {

		private Campo campoPropio;
		private Campo campoEnemigo;
		private Mano mano;
	

	public Jugador() {
		
		this.campoPropio = new Campo();
		this.mano = new Mano();	
	}
	
	public void enfrentarseA(Jugador jugadorEnemigo) {
		
		jugadorEnemigo.setCampoEnemigo(this.campoPropio);
	}
	
	public void atacar(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacante.atacar(atacado);
		
		this.campoPropio.enviarCartasDestruidasAlCementerio();
		this.campoEnemigo.enviarCartasDestruidasAlCementerio();
	}
	
	public void colocarCartaEnCampo(CartaMonstruo carta) {
		
		campoPropio.colocarMonstruoEnModoAtaque( carta );
	}
	
	public void setCampoEnemigo(Campo campo) {
		this.campoEnemigo = campo;
	}
	
	public int cantidadDeCartasEnLaMano() {
		
		return mano.obtenerCantidadDeCartas();
	}

	public Object obtenerVidaRestante() {
		
		return campoPropio.obtenerVidaRestante();
	}

	public void colocarMonstruoEnModoAtaque(CartaMonstruo cartaAColocar) {
		
		cartaAColocar.colocarEnModoAtaque();
		this.campoPropio.colocarCarta(cartaAColocar);
		
	}
}
