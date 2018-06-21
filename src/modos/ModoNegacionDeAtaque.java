package modos;

import cartas.Atacable;

public class ModoNegacionDeAtaque extends Modo {

	private Modo modoAnterior;
	
	public ModoNegacionDeAtaque(Modo modoPrevio) {
		
		this.modoAnterior = modoPrevio;
		
	}

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
	
	public Modo colocarEnModoAnterior() {
		return modoAnterior;
	}
	
	@Override
	public void recibirAtaque(Atacable cartaAtacante, Atacable cartaAtacada) {
		
		//Deberia volver al modo que tenia antes.
		cartaAtacada.cambiarA(this.colocarEnModoAnterior());
	}

}
