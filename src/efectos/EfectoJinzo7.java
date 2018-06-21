package efectos;

import campo.Cementerio;
import campo.ZonaCampo;
import campo.ZonaMagicasYTrampas;
import campo.ZonaMonstruos;
import cartas.*;
import estadoCarta.EstadoCarta;
import jugador.*;
import modos.Modo;

public class EfectoJinzo7 extends CartaMonstruoDecorator { 
	
	public EfectoJinzo7(Atacable cartaMonstruo) {
		super(cartaMonstruo);
	}

	@Override
	public int obtenerDanioAlHaberSidoDestruida() {
		int danio = getAtacable().obtenerDanioAlHaberSidoDestruida();
		return danio;
	}

	@Override
	public void cambiarA(Modo modoRecibido) {
		getAtacable().cambiarA(modoRecibido);
	}

	@Override
	public int obtenerEstrellas() {
		int estrellas = getAtacable().obtenerEstrellas();
		return estrellas;
	}

	@Override
	public Puntos obtenerPuntosAtaque() {
		Puntos puntosDeAtaque = getAtacable().obtenerPuntosAtaque();
		return puntosDeAtaque;
	}

	@Override
	public void destruirCarta() {
		getAtacable().destruirCarta();
	}

	@Override
	public boolean estaDestruida() {
		boolean estaDestruida = getAtacable().estaDestruida();
		return estaDestruida;
	}

	@Override
	public void colocarse(Jugador jugador, ZonaMonstruos zonaMonstruos, ZonaMagicasYTrampas zonaMagicasYTrampas,
			ZonaCampo zonaCampo, Cementerio cementerio, EstadoCarta estadoAColocar) {
		
		getAtacable().colocarse(jugador, zonaMonstruos, zonaMagicasYTrampas, zonaCampo, cementerio, estadoAColocar);
	}

	@Override
	public void recibirAtaque(Atacable cartaAtacante) {
		getAtacable().recibirAtaque(cartaAtacante);
	}

	@Override
	public void atacar(Atacable cartaAtacable) {
		getAtacable().atacar(cartaAtacable);
	}

	@Override
	public Puntos obtenerPuntosDefensa() {
		Puntos puntosDefensa = getAtacable().obtenerPuntosDefensa();
		return puntosDefensa;
	}

	@Override
	public boolean tieneMasPuntosDeAtaqueQue(Atacable cartaAtacada) {
		boolean tieneMasAtaque = getAtacable().tieneMasPuntosDeAtaqueQue(cartaAtacada);
		return tieneMasAtaque;
	}

	@Override
	public int diferenciaDeAtaqueCon(Atacable cartaAtacada) {
		int diferenciaDeAtaque = getAtacable().diferenciaDeAtaqueCon(cartaAtacada);
		return diferenciaDeAtaque;
	}

	@Override
	public void destruirCarta(int danio) {
		getAtacable().destruirCarta(danio);
	}
	
	@Override
	public boolean estaColocadaBocaArriba() {
		boolean estaColocadaBocaArriba = getAtacable().estaColocadaBocaArriba();
		return estaColocadaBocaArriba;
	}


	@Override
	public boolean estaColocadaBocaAbajo() {
		boolean estaColocadaBocaAbajo = getAtacable().estaColocadaBocaAbajo();
		return estaColocadaBocaAbajo;
	}


	@Override
	public boolean estaEnModoAtaque() {
		boolean estaEnModoAtaque = getAtacable().estaEnModoAtaque();
		return estaEnModoAtaque;
	}


	@Override
	public boolean estaEnModoDefensa() {
		boolean estaEnModoDefensa = getAtacable().estaEnModoDefensa();
		return estaEnModoDefensa;
	}


	@Override
	public void ponerEn(EstadoCarta estado) {
		getAtacable().ponerEn(estado);
	}
	
	//Efecto Jinzo7
	
	@Override
	public void atacar(Jugador jugador) {
		Puntos puntosDeAtaque = getAtacable().obtenerPuntosAtaque();
		int ataqueDirecto = puntosDeAtaque.obtenerPuntosActuales();
		jugador.recibirAtaque(ataqueDirecto);
	}

}