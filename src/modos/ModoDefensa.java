package modos;

import cartas.CartaMonstruo;
import cartas.Puntos;

public class ModoDefensa extends Modo {
	
	
	@Override
	public ModoDefensa colocarEnModoDefensa() {
		return this;
	}
	
	public ModoAtaque colocarEnModoAtaque() {
		return new ModoAtaque();
	}

	public boolean estaEnModoAtaque() {
		return false;
	}

	public boolean estaEnModoDefensa() {
		return true;
	}

	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		
		Puntos puntosDeAtaqueMonstruoAtacante = cartaAtacante.obtenerPuntosAtaque();
		Puntos puntosDeDefensaMonstruoAtacado = cartaAtacada.obtenerPuntosDefensa();
		
		if( puntosDeAtaqueMonstruoAtacante.sonMayoresA(puntosDeDefensaMonstruoAtacado) ) {
			cartaAtacada.destruirCarta();
		}
		
	}
	
}
