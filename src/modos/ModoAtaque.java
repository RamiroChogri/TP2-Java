package modos;

import cartas.CartaMonstruo;
import cartas.Puntos;

public class ModoAtaque extends Modo {

	private Puntos puntosDeAtaque;
	private Puntos puntosDeDefensa;
	
	public ModoAtaque() {
		this.puntosDeAtaque = null;
		this.puntosDeDefensa = null;
	}
	
	public ModoAtaque(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
	}
	
	public void asignarPuntos(Puntos puntosDeAtaqueAColocar, Puntos puntosDeDefensaAColocar) {
		this.puntosDeAtaque = puntosDeAtaqueAColocar;
		this.puntosDeDefensa = puntosDeDefensaAColocar;
	}
	
	public ModoAtaque colocarEnModoAtaque() {
		return this;
	}
	
	public ModoDefensa colocarEnModoDefensa() {
		return new ModoDefensa(this.puntosDeAtaque, this.puntosDeDefensa);
	}

	public boolean estaEnModoAtaque() {
		return true;
	}

	public boolean estaEnModoDefensa() {
		return false;
	}

	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, Puntos puntosDeAtaqueMonstruoAtacante,
			CartaMonstruo cartaAtacada) {
		
		if(puntosDeAtaqueMonstruoAtacante.sonMayoresA(this.puntosDeAtaque)) {
			
			int diferenciaDeDanio = puntosDeAtaqueMonstruoAtacante.obtenerDiferenciaCon(this.puntosDeAtaque);
			cartaAtacada.destruirCarta(diferenciaDeDanio);	
		}
		else if(this.puntosDeAtaque.sonMayoresA(puntosDeAtaqueMonstruoAtacante)) {
			int diferenciaDeDanio = this.puntosDeAtaque.obtenerDiferenciaCon(puntosDeAtaqueMonstruoAtacante);
			
			cartaAtacante.destruirCarta(diferenciaDeDanio);
		}
		else {
			cartaAtacante.destruirCarta();
			cartaAtacada.destruirCarta();
		}
		
	}

}
