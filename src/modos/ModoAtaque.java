package modos;

import cartas.Atacable;
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
	public void recibirAtaque(Atacable cartaAtacante, Atacable cartaAtacada) {
		
		if(cartaAtacante.tieneMasPuntosDeAtaqueQue(cartaAtacada)) {
			
			int diferenciaDeDanio = cartaAtacante.diferenciaDeAtaqueCon(cartaAtacada);
			cartaAtacada.destruirCarta(diferenciaDeDanio);	
		}
		else if(cartaAtacada.tieneMasPuntosDeAtaqueQue(cartaAtacante)) {
			
			int diferenciaDeDanio = cartaAtacada.diferenciaDeAtaqueCon(cartaAtacante);
			cartaAtacante.destruirCarta(diferenciaDeDanio);
			
		}
		else {
			cartaAtacante.destruirCarta();
			cartaAtacada.destruirCarta();
		}
			
	}

}
