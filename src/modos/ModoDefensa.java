package modos;

import cartas.CartaMonstruo;
import cartas.Puntos;

public class ModoDefensa extends Modo {

	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	
	public ModoDefensa() {
		this.puntosDeAtaque = null;
		this.puntosDeDefensa = null;
	}
	
	public ModoDefensa(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
	}
	
	public void asignarPuntos(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
	}
	
	@Override
	public ModoDefensa colocarEnModoDefensa() {
		return this;
	}
	
	public ModoAtaque colocarEnModoAtaque() {
		return new ModoAtaque(this.puntosDeAtaque, this.puntosDeDefensa);
	}

	public boolean estaEnModoAtaque() {
		return false;
	}

	public boolean estaEnModoDefensa() {
		return true;
	}

	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, Puntos puntosDeAtaqueMonstruoAtacante,
			CartaMonstruo cartaAtacada) {
		
		if( puntosDeAtaqueMonstruoAtacante.sonMayoresA(this.puntosDeDefensa) ) {
			cartaAtacada.destruirCarta();
		}
		
	}
	
	
	
}
