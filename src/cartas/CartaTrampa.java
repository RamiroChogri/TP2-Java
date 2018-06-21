package cartas;

import campo.Campo;
import efectos.Efecto;

public class CartaTrampa extends CartaMagica{
	
	public CartaTrampa() {
		super();
	}
	
	
	public CartaTrampa(Efecto efectoAColocar) {
		super(efectoAColocar);
	}
	
	public void aplicarEfecto(Campo campoPropio, Campo campoEnemigo, Atacable atacante, Atacable atacado) {
		
		efecto.aplicarEfecto(campoPropio, campoEnemigo, atacante, atacado);
		this.destruirCarta();
	}
	
	@Override
	public boolean esDeTrampa() {
		
		return true;
	}



}
