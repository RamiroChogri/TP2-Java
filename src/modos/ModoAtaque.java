package modos;

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

}
