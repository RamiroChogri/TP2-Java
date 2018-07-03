package partida;

import jugador.Jugador;

public abstract class Fase {
	
	public boolean esFasePreparacion() {
		return false;
	}
	
	public boolean esFaseAtaqueYTrampas() {
		return false;
	}
	
	public boolean esFaseFinal() {
		return false;
	}
	
	public abstract String getNombreFase();
	
	public abstract Fase obtenerFaseSiguiente();
	
	public abstract Jugador obtenerJugadorEnTurno();
	
	
}
