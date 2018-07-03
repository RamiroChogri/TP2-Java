package modos;

import cartas.Atacable;
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
	public void recibirAtaque(Atacable cartaAtacante, Atacable cartaAtacada) {
		
		Puntos puntosDeAtaqueMonstruoAtacante = cartaAtacante.obtenerPuntosAtaque();
		Puntos puntosDeDefensaMonstruoAtacado = cartaAtacada.obtenerPuntosDefensa();
		
		if( puntosDeAtaqueMonstruoAtacante.sonMayoresA(puntosDeDefensaMonstruoAtacado) ) {
			cartaAtacada.destruirCarta();
		}
		
	}
	
	public String obtenerNombre() {
		return "Modo Defensa";
	}

	
}
