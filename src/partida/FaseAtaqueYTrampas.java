package partida;


import jugador.Jugador;

public class FaseAtaqueYTrampas extends Fase {
	
	public static boolean esPrimerTurno;
	private String nombreFase;
	private Jugador jugadorEnTurno;
	
	public FaseAtaqueYTrampas(Jugador jugadorRecibido) {
		this.nombreFase = "Fase Ataque y Trampas";
		this.jugadorEnTurno = jugadorRecibido;
	}
	
	public String getNombreFase() {
		return this.nombreFase;
	}
	
	@Override
	public Fase obtenerFaseSiguiente() {
		Fase faseADevolver = new FaseFinal(this.jugadorEnTurno);
		return faseADevolver;
	}
	
	@Override
	public Jugador obtenerJugadorEnTurno() {
		return this.jugadorEnTurno;
	}
	
	@Override
	public boolean esFaseAtaqueYTrampas() {
		return true;
	}
	
}
