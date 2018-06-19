package modos;

import cartas.CartaMonstruo;
import cartas.Puntos;

public class ModoAtaque extends Modo {
	
	
	public ModoAtaque colocarEnModoAtaque() {
		return this;
	}
	
	public ModoDefensa colocarEnModoDefensa() {
		return new ModoDefensa();
	}

	public boolean estaEnModoAtaque() {
		return true;
	}

	public boolean estaEnModoDefensa() {
		return false;
	}

	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		
		Puntos puntosDeAtaqueMonstruoAtacante = cartaAtacante.obtenerPuntosAtaque();
		Puntos puntosDeAtaqueMonstruoAtacado = cartaAtacada.obtenerPuntosAtaque();
		
		
		if(puntosDeAtaqueMonstruoAtacante.sonMayoresA(puntosDeAtaqueMonstruoAtacado)) {
			
			int diferenciaDeDanio = puntosDeAtaqueMonstruoAtacante.obtenerDiferenciaCon(puntosDeAtaqueMonstruoAtacado);
			cartaAtacada.destruirCarta(diferenciaDeDanio);	
		}
		else if(puntosDeAtaqueMonstruoAtacado.sonMayoresA(puntosDeAtaqueMonstruoAtacante)) {
			
			int diferenciaDeDanio = puntosDeAtaqueMonstruoAtacado.obtenerDiferenciaCon(puntosDeAtaqueMonstruoAtacante);
			cartaAtacante.destruirCarta(diferenciaDeDanio);
			
		}
		else {
			cartaAtacante.destruirCarta();
			cartaAtacada.destruirCarta();
		}
		
		
	}

}
