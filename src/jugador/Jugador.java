package jugador;
import campo.*;
public class Jugador {

		private int puntosDeVida;
		private Campo campoPropio;
		private Campo campoEnemigo;
		private Mano mano;
	

	public Jugador() {
		
		this.puntosDeVida = 8000;
		this.campoPropio = new Campo();
		this.mano = new Mano();	
	}
	public void enfrentarseA(Jugador jugadorEnemigo) {
		
		jugadorEnemigo.setCampoEnemigo(this.campoPropio);
	}
	
	public void setCampoEnemigo(Campo campo) {
		this.campoEnemigo = campo;
	}
	
	public int cantidadDeCartasEnLaMano() {
		
		return 0;
	}
}
