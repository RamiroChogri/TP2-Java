package modos;

import cartas.Atacable;

public class ModoNegacionDeAtaque extends Modo {

	@Override
	public boolean estaEnModoAtaque() {

		return false;
	}

	@Override
	public boolean estaEnModoDefensa() {

		return false;
	}
	
	@Override
	public ModoDefensa colocarEnModoDefensa() {
		return new ModoDefensa();
	}
	
	@Override
	public ModoAtaque colocarEnModoAtaque() {
		return new ModoAtaque();
	}
	
	@Override
	public void recibirAtaque(Atacable cartaAtacante, Atacable cartaAtacada) {
		
		//Deberia volver al modo que tenia antes.
		cartaAtacada.cambiarA(this.colocarEnModoAtaque());
	}

}
